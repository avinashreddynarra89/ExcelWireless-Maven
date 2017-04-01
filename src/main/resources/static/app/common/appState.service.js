(function () {
    angular.module('excelWireless')
        .factory('AppState', applicationState);

    function applicationState() {
        var m = this;


        m.appState = {
            selectedProduct: {},
            selectedCategory: {}
        }

        return {
            state: m.appState
        }
    }
}());