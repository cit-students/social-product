(function () {
    'use stricts';
    var todoApp = angular.module('todoApp');
    todoApp.directive('citHeader',citHeader);
    citHeader.$inject = ['$log'];
    function citHeader() {
        return{
            restrict: 'E',
            templateUrl:'../layout/header.html'
        };

    }

})();