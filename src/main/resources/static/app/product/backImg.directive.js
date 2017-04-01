/**
 * Created by asp5045 on 3/28/17.
 */


angular.module('excelWireless').directive('backImg', function(){
    return function(scope, element, attrs){
        var url = attrs.backImg;
        element.css({
            'background-image': 'url(' + url +')',
            'background-size' : 'cover'
        });
    };
});