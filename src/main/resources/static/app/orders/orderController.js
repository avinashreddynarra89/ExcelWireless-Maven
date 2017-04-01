(function () {

    'use strict';

    angular.module('excelWireless').controller('OrderController', getProduct);

    getProduct.$inject = ['$scope','$rootScope','GlobalVariable', 'StoreService', '$state', 'AppState','RestrictedCharacter.Types','$timeout'];

    function getProduct($scope,$rootScope,GlobalVariable, StoreService, $state, AppState,restrictCharacter,$timeout) {

        var vm = this;
        vm.orderDto = {};
        var c =0;
        vm.total = 0;
        vm.totalQuantity = 0;
        $scope.restrictCharacter = restrictCharacter;
        vm.updateSuccess = false;


        // vm.orderDto1 = JSON.parse(sessionStorage.orderDetails);
        vm.test1 = function(value,index,retail)
        {
            console.log("value");
           // if(value != undefined && value != null && value != '')
            vm.getTotalValue(value,index,retail);
        }

        vm.getOrderDetails = function () {

            StoreService.getData(GlobalVariable.URLCONSTANT + "getTransactionLineItem?phoneNo="+sessionStorage.customerPhoneNo).then(
                function (success) {
                    vm.orderDto = success.data;
                    vm.getTotalValue('',-1,'');
                },
                function (error) {
                    console.log("Failed to get customers order details");
                });
            //vm.orderDto = JSON.parse(sessionStorage.orderDetails);
        }
        vm.invokePopup = function(prodNo,index)
        {
            GlobalVariable.proNo =prodNo;
            GlobalVariable.prodIndex = index;
        }
        vm.removeProduct = function(productNo,index)
        {
            StoreService.postData(GlobalVariable.URLCONSTANT+"deleteTransactionLineItem?phoneNo="+sessionStorage.customerPhoneNo+"&productNo="+GlobalVariable.proNo).then(
                function (success) {
                    console.log("Removed product successfully");
                    vm.orderDto.splice(GlobalVariable.prodIndex, 1);
                    vm.getOrderDetails();
                },
                function (error) {
                    console.log("Failed to remove product from order");
                });
        }
        vm.updateProductQuantity = function(productQuantity,productNo)
        {
            StoreService.postData(GlobalVariable.URLCONSTANT+"updateTransactionLineItem?phoneNo="+sessionStorage.customerPhoneNo+"&productNo="+productNo+"&quantity="+productQuantity).then(
                function (success) {

                    if(success)
                    {
                        vm.updateSuccess = true;
                        vm.showUpdateMsg="Product quantity updated successfully";
                        callbackCust();
                    }
                    console.log("Updated product successfully");
                },
                function (error) {
                    if(error)
                    {
                        vm.showErrorMsg="Something goes wrong not able to update product quantity";
                    }
                    console.log("Failed to update product from order");
                });
        }

        function callbackCust() {
            $timeout(function() {
                vm.updateSuccess = false;
            }, 3500);
        }

        vm.continueOrder = function () {

            $state.go('checkout');
        }
        vm.getTotalValue = function(value,index,retail)
        {
            vm.total = 0;
            vm.totalQuantity = 0;
            for(var i=0;i<vm.orderDto.length;i++)
            {
                if(index != i)
                {
                    if(vm.orderDto[i].quantity != '')
                    {
                        vm.total = vm.total + (parseFloat(vm.orderDto[i].retailPrice) * parseInt(vm.orderDto[i].quantity));
                        vm.totalQuantity = vm.totalQuantity + parseInt(vm.orderDto[i].quantity);
                    }
                }
            }

            if(value != '' && value != undefined)
            {
                vm.totalQuantity = vm.totalQuantity + parseFloat(value);
                vm.total = vm.total + parseFloat(parseFloat(retail) * parseFloat(value));
            }

            sessionStorage.checkoutTotal = vm.total;
            sessionStorage.checkoutQuantity = vm.totalQuantity;


        }
        function render()
        {

            vm.getOrderDetails();

        }
        render();
    }



})();