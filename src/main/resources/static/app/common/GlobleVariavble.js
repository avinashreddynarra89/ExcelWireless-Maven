<<<<<<< HEAD
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
         globalVar.URLCONSTANT = '';
         globalVar.customerPhoneNo = '';
         globalVar.productForSearch = '';
         globalVar.isValidUser = 'false';
         globalVar.userRole = 'Customer';

         return globalVar;
     }



=======
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
         globalVar.URLCONSTANT = ''; 
//         globalVar.URLCONSTANT = 'https://firstproject-159400.appspot.com/'
//       globalVar.URLCONSTANT = 'http://localhost:8080/';
//         globalVar.URLCONSTANT = 'https://exwireless.cfapps.io/';
         globalVar.customerPhoneNo = '';
         globalVar.productForSearch = '';
         globalVar.isValidUser = 'false';
         globalVar.userRole = 'Customer';

         return globalVar;
     }



>>>>>>> c613016912602a1203f6979537a1764a5a211bc8
})();