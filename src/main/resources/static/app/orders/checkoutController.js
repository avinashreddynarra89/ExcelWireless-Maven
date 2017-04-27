(function () {

    'use strict';

    angular.module('excelWireless').controller('CheckoutController', productCheckout);

    productCheckout.inject = ['$scope','$rootScope','GlobalVariable', 'StoreService', '$state', 'AppState'];

    function productCheckout($scope,$rootScope,GlobalVariable, StoreService, $state, AppState) {

        var vm = this;

        var request = [];

        vm.orderDto = {};
        vm.phoneNo = sessionStorage.customerPhoneNo;
        vm.street = sessionStorage.street;
        vm.city = sessionStorage.city;
        vm.state = sessionStorage.state;
        vm.country = sessionStorage.country;
        vm.zipcode = sessionStorage.zipcode;
        // vm.fax = sessionStorage.fax;
        vm.email = sessionStorage.email;
        vm.firstName = sessionStorage.firstName;
        vm.lastName = sessionStorage.lastName;
        vm.companyName = sessionStorage.companyName;

        vm.total = 0;
        vm.totalQuantity = 0;
        vm.transactionTotal = 0;
        vm.totalTransactionQuantity = 0;

        function js_yyyy_mm_dd_hh_mm_ss () {
            var now = new Date();
            var year = "" + now.getFullYear();
            var month = "" + (now.getMonth() + 1); if (month.length == 1) { month = "0" + month; }
            var day = "" + now.getDate(); if (day.length == 1) { day = "0" + day; }
            var  hour = "" + now.getHours(); if (hour.length == 1) { hour = "0" + hour; }
            var minute = "" + now.getMinutes(); if (minute.length == 1) { minute = "0" + minute; }
            var second = "" + now.getSeconds(); if (second.length == 1) { second = "0" + second; }
            return year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;
        }

        //TODO need to fix this whole code with storing the data in local storage
        vm.getOrderDetails = function () {

            StoreService.getData(GlobalVariable.URLCONSTANT + "getTransactionLineItem?phoneNo="+sessionStorage.customerPhoneNo).then(
                function (success) {
                    vm.orderDto = success.data;
                    vm.getTotalValue();
                },
                function (error) {
                    console.log("Failed to get customers order details");
                });
            //vm.orderDto = JSON.parse(sessionStorage.orderDetails);
        }

        vm.getTotalValue = function()
        {

            for(var i=0;i<vm.orderDto.length;i++)
            {
                vm.total = vm.total + (parseFloat(vm.orderDto[i].retailPrice) * parseInt(vm.orderDto[i].quantity));
                sessionStorage.total = vm.total;
                vm.totalQuantity = vm.totalQuantity + parseInt(vm.orderDto[i].quantity);
                sessionStorage.quantity = vm.totalQuantity;
            }
            vm.checkoutTotal = sessionStorage.total;
            vm.checkoutQuantity = sessionStorage.quantity;
        }

        //Placing final oder
        vm.finalCheckout = function (transactionLineItemDto) {

            for(var p=0;p<transactionLineItemDto.length;p++)
            {
                vm.transactionTotal = vm.transactionTotal + (parseFloat(transactionLineItemDto[p].retailPrice) * parseInt(transactionLineItemDto[p].quantity));
               // sessionStorage.total = vm.total;
                vm.totalTransactionQuantity = vm.totalTransactionQuantity + parseInt(transactionLineItemDto[p].quantity);
                //sessionStorage.quantity = vm.totalQuantity;
            }



            //Adding transaction details into DB.

            var transactionDto = new Object();
            var transactionDate = js_yyyy_mm_dd_hh_mm_ss();

            //calling this method to set the total values in session in case user is not changing anything by the time of ordering, cause this
            //method only calls when user change something in order.
            //vm.getTotalValue();

            transactionDto =
                {

                    "transactionDate" :transactionDate,
                    "totalAmount" : parseFloat(vm.transactionTotal),
                    "tax" : '0.0',
                    "discount" : '0.0',
                    "subTotal" : parseFloat(vm.transactionTotal),
                    "customerPhoneNo" : sessionStorage.customerPhoneNo,
                    "customerName" : sessionStorage.firstName +sessionStorage.lastName,
                    "status" : 'O',
                    "totalQuantity":parseInt(vm.totalTransactionQuantity),
                    "prevBalance":'0.0', //TODO need to handle this after talking to asif
                    "balance":0.0, //TODO need to handle this after talking to asif
                    "receiptNote":'TestNotes', //TODO Need to replace with with text box by the time of order.
                    "transactionCompId":parseInt(sessionStorage.transactionId)+1
                };

                //setting up order id here to show on the thank you page.
                sessionStorage.orderId = parseInt(sessionStorage.transactionId)+1;

            transactionDto = JSON.stringify(transactionDto);

            StoreService.postData(GlobalVariable.URLCONSTANT+"checkoutTransaction",transactionDto,"application/json","application/json").then(
                function (success) {
                },
                function (error) {
                    console.log("Failed to checkout final order");
                });

            //Adding transaction LineItemDetails into DB.

            for(var i =0; i<transactionLineItemDto.length; i++)
            {
                request.push({

                    "transactionCompId":parseInt(sessionStorage.transactionId)+1,
                    "productNo":transactionLineItemDto[i].productNo,
                    "quantity":transactionLineItemDto[i].quantity,
                    "retailPrice":transactionLineItemDto[i].retailPrice,
                    "costPrice":transactionLineItemDto[i].costPrice,
                    "discount":transactionLineItemDto[i].discount,
                    "retailWithDis":transactionLineItemDto[i].retailPrice,
                    "totalProductPrice":parseFloat(transactionLineItemDto[i].retailPrice * transactionLineItemDto[i].quantity).toFixed(2),
                    "transactionDate":transactionDate,
                    // "discountPercentage":discPer,
                    "transactionStatus":'O',
                     "totalProductPriceWithTax":parseFloat(transactionLineItemDto[i].retailPrice * transactionLineItemDto[i].quantity).toFixed(2)
                    // "imeiNo":$rootScope.testData[i].imeiNo,
                    // "phoneId":$rootScope.testData[i].phoneId

                });

                // transactionLineItemDto.transactionCompId = parseInt(sessionStorage.transactionId)+1;
                // transactionLineItemDto.transactionDate = transactionDate;
            }
            StoreService.postData(GlobalVariable.URLCONSTANT+"checkoutTransactionLineItem",request,"application/json","application/json").then(
                function (success) {

                $rootScope.$broadcast('updateCount',0);
                },
                function (error) {
                    console.log("Failed to checkout final order");
                });

            $state.go('thankYou');
        }

        function render()
        {
            vm.getOrderDetails();

            //First getting last transaction id and doing + 1 to generate uniqueId always.

            StoreService.getData(GlobalVariable.URLCONSTANT + "getLastTransactionId").then(
                function (success) {
                    sessionStorage.transactionId = success.data;

                },
                function (error) {
                    console.log("Failed to get customers order details");
                });
        }
        render();


    }
})();