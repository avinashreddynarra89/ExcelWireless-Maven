(function () {

    'use strict';

    angular.module('excelWireless').controller('CategoryProductController', getProduct);

    getProduct.inject = ['util','$scope','$rootScope','GlobalVariable', 'StoreService', '$state', 'AppState'];

    function getProduct(util,$scope,$rootScope,GlobalVariable, StoreService, $state, AppState) {

        var vm = this;

        vm.productDto = {};

        vm.isValidUser = function () {
            vm.user =  sessionStorage.validUser;
            console.log("is valid user"+ vm.user);
        }

        vm.getProductsByCategoryId = function (categoryId) {

            var products;

            console.log("CategoryId ="+ categoryId)

            util.Wait(true);

            StoreService.getData(GlobalVariable.URLCONSTANT+'getProductsByCategory?category_Id='+categoryId).then(
                function (success) {
                    console.log("category Product details"+ success.data)

                    util.Wait(false);

                    GlobalVariable.productBtCategory = success.data;
                    vm.productDto = GlobalVariable.productBtCategory;
                    $state.go('categoryProducts');
                },
                function (error) {
                 util.Wait(false);
                    console.log("Can not get products by category"+ error);

                });

        }

        //vm.productDto = GlobalVariable.productBtCategory;

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
            product.saleQuantity = value;
            a.push(product);

            sessionStorage.orderDetails = JSON.stringify(a);
            $rootScope.$emit('updateCount',value);
        }

        function render()
        {

            vm.isValidUser();
        }
        render();

    }

})();