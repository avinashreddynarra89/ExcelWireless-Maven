(function() {
    angular.module('excelWireless')
        .component('homeComponent', {
            templateUrl: 'app/home/home.html',
            controller: 'homeController',
            controllerAs: 'HomeCtrl',
            bindings: {
                myAttribute: '='
            }
        });
}());