(function () {
    'use stricts';
    var todoApp = angular.module('todoApp');
    todoApp.directive('citContent',citContent);
    citContent.$inject = ['$log'];
    function citContent() {
        return{
            restrict: 'E',
            templateUrl:'components/layout/content.html'
        };

    }

})();