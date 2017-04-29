(function(){
    'use strict';
    angular.module('excelWireless').controller('PartsController', getPartsProduct);

    getPartsProduct.$inject = ['util','GlobalVariable', 'StoreService', '$state', 'AppState', '$rootScope','$log', '$scope','RestrictedCharacter.Types'];

    function getPartsProduct(util,GlobalVariable, StoreService, $state, AppState,$rootScope,$log, $scope,restrictCharacter) {

        var vm = this;

        vm.productDto = {};
        vm.barLimit = 10;
        vm.showDIV = false;
        $scope.GlobalVariable = GlobalVariable;

        $scope.restrictCharacter = restrictCharacter;

        vm.brandAndModelDetails = [];
        vm.brandAndModelDetails = GlobalVariable.brandModelDto;

        //console.log(brandAndModelDetails);
        $log.info("WebBrandArray" + GlobalVariable.brandModelDto);

        vm.increaseLimit = function () {
            vm.barLimit += 20;
        }
        vm.isValidUser = function () {
            vm.user = sessionStorage.validUser;
            console.log("is valid user" + vm.user);
        }

        vm.getProductDetails = function (product) {
            // Set the selected product;
            // AppState.state.selectProduct = product || {};
            GlobalVariable.productDetails = product;
            $state.go('productDetails');
        }

        var product1 = [];
        //getting no of products count as well as the product details and storing in to session to show on the order page.
        vm.updateCartCountParts = function (value, product) {
            console.log("Product details from product to product details" + product.description);
            product.quantity = value;
            product.phoneNo = sessionStorage.customerPhoneNo;
            product.retailWithDis = product.retailPrice;
            product.totalProductPrice = parseFloat(product.retailPrice * value);
            product.totalProductPriceWithTax = parseFloat(product.retailPrice * value);
            product1.push(product);

            sessionStorage.orderDetails = JSON.stringify(product1);
            $rootScope.$emit('updateCount', value);

            util.Wait(true);
            StoreService.postData(GlobalVariable.URLCONSTANT+"addTransactionLineItem", product, "application/json", "application/json").then(function (response) {
                    var data = response.data;

                    util.Wait(false);
                    console.log("response data", data);
                },
                function (error) {
                 util.Wait(false);
                    console.log("getReplenishmentInfo call failed");
                });
        }

        vm.isValidUser = function () {
            vm.user = sessionStorage.validUser;
            console.log("is valid user" + vm.user);
        }
        function renderData() {


            util.Wait(true);
            //call to get the price of the product by customer
            StoreService.getData(GlobalVariable.URLCONSTANT+'getProductPriceByCustomer?phoneNo='+sessionStorage.customerPhoneNo).then(
                function (success) {
                    // console.log(success.data)

                    GlobalVariable.productPriceDto = success.data;
                },
                function (error) {
                 util.Wait(false);
                    console.log("getReplenishmentInfo call failed");
                });

            //Call to get all parts product
            StoreService.getData(GlobalVariable.URLCONSTANT+'getProductsByCategory?category_Id=6').then(
                function (success) {
                    // console.log(success.data)
                    //var i = 0;
                    util.Wait(false);
                    var temProductDto = success.data;

                    if(sessionStorage.validUser)
                    {
                        for(var i = 0; i< temProductDto.length; i++)
                        {
                            for(var j = 0; j< GlobalVariable.productPriceDto.length; j++)
                            {
                                if(GlobalVariable.productPriceDto[j].productNo == temProductDto[i].productNo)
                                {
                                    temProductDto[i].retailPrice = GlobalVariable.productPriceDto[j].retailPrice;
                                }
                            }
                        }
                        vm.productDto = temProductDto;
                    }
                    else
                    {
                        vm.productDto = success.data;
                    }
                },
                function (error) {
                util.Wait(false);
                    console.log("getReplenishmentInfo call failed");
                });

            StoreService.getData(GlobalVariable.URLCONSTANT+'getSideBardForParts').then(
                function (success) {
                    // console.log(success.data)
                    $scope.items = success.data;
                    GlobalVariable.items = $scope.items;
                },
                function (error) {
                    console.log("getReplenishmentInfo call failed");
                });

            $scope.default = '';

            $scope.$parent.isopen = ($scope.$parent.default === $scope.item);

            $scope.$watch('isopen', function (newvalue, oldvalue, scope) {
                $scope.$parent.isopen = newvalue;
            });


        }

        function render() {
            vm.isValidUser();
            renderData();

        }

        render();

    }


})();
