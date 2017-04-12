angular.module('excelWireless')
    .factory('StoreService', StoreService);

StoreService.$inject = [ '$http'];


function StoreService($http){

    var vm = {};

    function StoreService() {}


    vm.getData = function (_url){

        return $http({
            method: 'GET',
            url: _url,
            cache: false
        });

    };

    vm.postData = function (_url,_reqData,content_type, accept) {

        var headerObj = {
            Accept : accept
        };
        return $http({
            method:'POST',
            url:_url,
            data:_reqData,
            headers : headerObj
        });

    }
    return vm;



}