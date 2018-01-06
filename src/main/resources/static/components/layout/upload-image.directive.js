(function () {
    'use stricts';
    var todoApp = angular.module('todoApp');
    todoApp.directive('uploadImage',uploadImage);
    uploadImage.$inject = ['$log'];
    function uploadImage() {
        return{
            restrict: 'E',
            templateUrl:'components/layout/upload-image.html'
        };

    }

})();