(function() {
    angular.module('excelWireless')
        .controller('ProductDetailsController', productDetailsController);

    productDetailsController.$inject = ['GlobalVariable','$scope','RestrictedCharacter.Types','$rootScope','StoreService']


    function  productDetailsController(GlobalVariable,restrictCharacter,$scope,$rootScope,StoreService) {

        var vm = this;
        vm.a = {};

        $scope.restrictCharacter = restrictCharacter;

        vm.a = GlobalVariable.productDetails;

        vm.isValidUser = function () {
            vm.user = sessionStorage.validUser;
            console.log("is valid user in product details" + vm.user);
        }

        vm.updateCartCountParts = function (value, product) {
            // console.log("Product details from product to product details" + product.description);
            product.quantity = value;
            product.phoneNo = sessionStorage.customerPhoneNo;
            //a.push(product);

            //sessionStorage.orderDetails = JSON.stringify(a);
            $rootScope.$emit('updateCount', value);

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

}());