(function() {
    angular.module('excelWireless')
        .factory("dataService", dataService);

    dataService.$inject = ['$http', '$log'];

    function dataService($http, $log) {
        var service = {}, cache = false, vm = this;
        //vm.domain = 'https://excelwireless.cfapps.io';
        vm.domain = 'https://firstproject-159400.appspot.com/';
        vm.port = '';
        vm.defaultMethodPath = '/getWebMenu';

        service.callGenericMethod = function (methodPath, methodType, data, headers, successCallback, errorCallback) {
            var _headers = headers ? headers : {"Content-Type": "application/json"},
                _domain = vm.domain,
                _port = (vm.port && vm.port.length > 0) ? (":" + vm.port) : "",
                _path = methodPath || vm.defaultMethodPath,
                _methodType = (methodType === "GET" || methodType === "PUT" || methodType === "POST" || methodType === 'PATCH' || methodType === "DELETE") ? methodType : "GET",
                _successCallback, _errorCallback;

            function successMethod(response){
                return response;
            }

            function errorMethod(reason) {
                $log.error("called default error method: {0}", reason);
                return reason;
            }

            _successCallback = (typeof successCallback === 'function') ? successCallback : successMethod;
            _errorCallback = (typeof errorCallback === 'function') ? errorCallback : errorMethod;
            return $http({
                cache: cache,
                data: data ? data : {},
                headers: _headers,
                method: _methodType,
                url: _domain + _port + _path
            }).then(_successCallback, _errorCallback);
        };

        return service;
    }
}());