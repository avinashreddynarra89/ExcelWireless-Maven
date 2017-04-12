(function () {

    'use strict';

    angular.module('excelWireless').factory('GlobalVariable',global)

    global.inject = [];

     function global() {

         var globalVar = {};

         globalVar.product='';
         globalVar.prodcutDetails = '';
         globalVar.partsProduct = '';
         globalVar.lineItemDto = '';
         globalVar.productBtCategory = '';
         globalVar.items = [];
         globalVar.URLCONSTANT = 'https://firstproject-159400.appspot.com/'
//       globalVar.URLCONSTANT = 'http://localhost:8080/';
//       globalVar.URLCONSTANT = 'https://exwireless.cfapps.io/';
         globalVar.customerPhoneNo = '';
         globalVar.productForSearch = '';
         globalVar.isValidUser = 'false';
         globalVar.userRole = 'Customer';

         return globalVar;
     }



})();