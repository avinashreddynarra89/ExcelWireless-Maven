(function() {
    /**
     * Created by asp5045 on 1/10/17.
     */
    'use strict';

    angular.module('excelWireless').controller('contactUsController',contactUsFunction);

    contactUsFunction.$inject = ['$scope', '$state'];

    function contactUsFunction($scope, $state) {

        $scope.navigate = function () {



            $state.go('contactUs');



        }
    }
}());
