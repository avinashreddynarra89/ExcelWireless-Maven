(function () {
    'use strict';

    angular.module('excelWireless').controller('loginController', loginFunction);

    loginFunction.$inject = ['$http', '$state', 'GlobalVariable','StoreService','$rootScope','util','$timeout'];

    function loginFunction($http, $state, GlobalVariable,StoreService,$rootScope,util, $timeout) {

        var vm = this;
        var quantity = 0;
        var errorArray = [];
        vm.showError =false;

        vm.validations = function()
        {
                errorArray = [];
                if(vm.username == undefined || vm.username == '' || vm.username == null)
                {
                    errorArray.push({
                        'id' : 'username',
                        'msg' : 'UserName is not valid'
                    });
                }
                else if(vm.password == undefined || vm.password == '' || vm.password == null)
                {
                    errorArray.push({
                        'id' : 'password',
                        'msg' : 'Password is not valid'
                    });
                }
            if (errorArray.length >= 1) {
                util.customError.show(errorArray, "");

                return false;
            } else {
                return true;
            }
        }

        vm.onLoginClicked = function (username,password) {
            var userDetail;
            console.log(username + password);
            util.customError.hide(['username','password']);
          if(vm.validations())
          {
              $http.get(GlobalVariable.URLCONSTANT+'getUserLoginDetails?username=' + username + '&password=' + password).then(function (response) {

                  userDetail = response.data;

                  if(userDetail.validUser)
                  {
                      sessionStorage.validUser = true;
                      sessionStorage.customerPhoneNo = userDetail.phoneNo;
                      sessionStorage.street = userDetail.street;
                      sessionStorage.city = userDetail.city;
                      sessionStorage.state = userDetail.state;
                      sessionStorage.country = userDetail.country;
                      sessionStorage.zipcode = userDetail.zipcode;
                      sessionStorage.fax = userDetail.fax;
                      sessionStorage.email = userDetail.email;
                      sessionStorage.firstName = userDetail.firstName;
                      sessionStorage.lastName = userDetail.lastName;
                      sessionStorage.companyName = userDetail.companyName;
                      sessionStorage.userRole = userDetail.userRole;
                      $rootScope.$emit('setTypeOfUser',userDetail.userRole);
                      vm.getOrderDetails(userDetail.phoneNo);

                      // TODO Redundant code using same function need to fix and find the way to use one function
                      $state.go('home');
                  }
                  else
                  {
                      errorArray = [];
                      vm.showError = true;
                      vm.showErrorMsg="Invalid Username/password";
                      callbackCust();
                      sessionStorage.validUser = false;
                  }
                  $rootScope.$broadcast('isValid',sessionStorage.validUser);
              });
          }


        }

        function callbackCust() {
            $timeout(function() {
               vm.showError = false;
            }, 9000);
        }
        vm.getOrderDetails = function(phn) {

            StoreService.getData(GlobalVariable.URLCONSTANT + "getTransactionLineItem?phoneNo="+phn).then(
                function (success) {
                    vm.orderDto = success.data;
                    quantity = 0;
                    for(var i=0;i<vm.orderDto.length;i++)
                    {
                        quantity = quantity + parseInt(vm.orderDto[i].quantity);
                    }
                    sessionStorage.totalQuantity = quantity;
                    $rootScope.$broadcast('updateCount',quantity);
                },
                function (error) {
                    console.log("Failed to get customers order details");
                });
            //vm.orderDto = JSON.parse(sessionStorage.orderDetails);
        }

    }
}());
