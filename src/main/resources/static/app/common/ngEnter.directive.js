(function() {
	'use strict';
	angular.module('excelWireless').directive('ngEnter', Enter);

	Enter.$inject = [];

	function Enter() {
		return {
			link : function(scope, elem, attrs) {
				elem.on('keypress', function(event) {
					if (event.which === 13) {
						//elem.trigger('change');
						//angular.element(event.target).trigger('change');
						scope.$apply(function() {
							scope.$eval(attrs.ngEnter);
						});
						event.preventDefault();
					}
				});
			}
		};
	}

})();