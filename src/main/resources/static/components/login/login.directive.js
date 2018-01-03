(function () {
    'use stricts';
    var todoApp = angular.module('todoApp');
    todoApp.directive('citLogin',citLogin);
    citLogin.$inject = ['$log'];
    function citLogin() {
        return{
            restrict: 'E',
            templateUrl:'components/login/login.html'
        };

    }

})();