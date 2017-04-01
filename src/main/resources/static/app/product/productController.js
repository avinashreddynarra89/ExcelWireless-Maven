(function () {

    'use strict';

    angular.module('excelWireless').controller('ProductController', getProduct);

    getProduct.$inject = ['$scope','$rootScope','GlobalVariable', 'StoreService', '$state', 'AppState','RestrictedCharacter.Types'];

    function getProduct($scope,$rootScope,GlobalVariable, StoreService, $state, AppState,restrictCharacter) {

        var vm = this;
        $scope.GlobalVariable = GlobalVariable;

        vm.brandAndModelDetails = [];
        vm.brandAndModelDetails = GlobalVariable.brandModelDto;

        $scope.restrictCharacter = restrictCharacter;

        //

        // $scope.items = [
        //     {
        //         "brandId": 1,
        //         "brandName": "EX",
        //         "modelDtoList": [
        //             {
        //                 "modelId": 1,
        //                 "modelName": "test",
        //                 "description": null,
        //                 "noOfProducts": 0
        //             }
        //         ]
        //     },
        //     {
        //         "brandId": 2,
        //         "brandName": "MYBAT",
        //         "modelDtoList": []
        //     },
        //     {
        //         "brandId": 3,
        //         "brandName": "MERCURY",
        //         "modelDtoList": []
        //     }
        // ];

        vm.productDto = {};

        vm.isValidUser = function () {
            vm.user =  sessionStorage.validUser;
            console.log("is valid user"+ vm.user);

            StoreService.getData(GlobalVariable.URLCONSTANT + 'getSideBardForParts').then(
                function (success) {
                    // console.log(success.data)
                    $scope.items = success.data;
                    GlobalVariable.items = $scope.items;
                },
                function (error) {
                    console.log("getReplenishmentInfo call failed");
                });
        }

        //vm.productDto = GlobalVariable.product;


        vm.getProductDetails = function (product) {
            // Set the selected product;
            GlobalVariable.productDetails = product;
            $state.go('productDetails');
        }
        var a = [];
        //getting no of products count as well as the product details and storing in to session to show on the order page.
        vm.updateCartCount = function(value, product)
        {
            console.log("Product details from product to product details"+product.description);
            product.quantity = value;
            product.phoneNo = sessionStorage.customerPhoneNo;
            a.push(product);

            sessionStorage.orderDetails = JSON.stringify(a);
            $rootScope.$emit('updateCount',value);

            StoreService.postData(GlobalVariable.URLCONSTANT + "addTransactionLineItem", product, "application/json", "application/json").then(function (response) {
                    var data = response.data;

                    console.log("response data", data);
                },
                function (error) {
                    console.log("getReplenishmentInfo call failed");
                });
        }

        function render()
        {
            vm.isValidUser();
        }
        render();

    }

})();