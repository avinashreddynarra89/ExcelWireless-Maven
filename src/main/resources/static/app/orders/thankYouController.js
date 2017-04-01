(function () {

    'use strict';

    angular.module('excelWireless').controller('ThankYouController', ThankYouPage);

    ThankYouPage.inject = ['$scope','$rootScope','GlobalVariable', 'StoreService', '$state', 'AppState'];

    function ThankYouPage($scope,$rootScope,GlobalVariable, StoreService, $state, AppState) {

        var vm = this;

        vm.orderDto = {};
        vm.phoneNo = sessionStorage.customerPhoneNo;
        vm.firstName = sessionStorage.firstName;
        vm.lastName = sessionStorage.lastName;
        vm.companyName = sessionStorage.companyName;

        vm.transactionTotal = 0;
        vm.totalTransactionQuantity = 0;

        vm.orderId = sessionStorage.orderId;

        vm.getOrderDetails = function () {

            StoreService.getData(GlobalVariable.URLCONSTANT + "getTransactionLineItem?phoneNo="+sessionStorage.customerPhoneNo).then(
                function (success) {
                    vm.orderDto = success.data;
                    //vm.getTotalValue();
                },
                function (error) {
                    console.log("Failed to get customers order details");
                });

            //Deleting customer's line item details from web_transaction_line_item table

            StoreService.postData(GlobalVariable.URLCONSTANT + "deleteAllTransactionLineItem?customerPhoneNo="+sessionStorage.customerPhoneNo,'',"application/json","application/json").then(
                function (success) {
                    if(success.data)
                    {
                        console.log("delete all transaction line item details successfully");
                    }
                }
                ,
                function (error) {
                    console.log("Failed to get customers order details");
                });
        }
        function render()
        {
            vm.getOrderDetails();
        }
        render();


    }
})();