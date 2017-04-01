(function () {
    'use strict';

    angular.module('excelWireless').controller('a', body);

    body.inject = ['$scope', 'StoreService', 'GlobalVariable','$state'];

    function body($scope,StoreService,GlobalVariable,$state) {

        var vm = this;
        vm.user =  sessionStorage.validUser;

        vm.getMenu = function(){
            StoreService.getData(GlobalVariable.URLCONSTANT+'getWebMenu').then(
                function (success) {
                    console.log(success.data)
                },
                function (error) {
                    console.log("getReplenishmentInfo call failed");
                });
        }

        vm.getProduct = function(modelId)
        {

            var products;
            StoreService.getData(GlobalVariable.URLCONSTANT+'getEcommerceProductsByModel?model_Id='+modelId).then(
                function (success) {
                    console.log(success.data)

                    GlobalVariable.product = success.data;
                    $state.go('products');
                },
                function (error) {
                    console.log("getReplenishmentInfo call failed");
                });

            console.log("This is test"+ modelId);
        }

    }
})();