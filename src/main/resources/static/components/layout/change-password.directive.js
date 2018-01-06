(function () {
    'use stricts';
    var todoApp = angular.module('todoApp');
    todoApp.directive('changePassword',changePassword);
    changePassword.$inject = ['$log'];
    function changePassword() {
        return{
            restrict: 'E',
            templateUrl:'components/layout/change-password.html'
        };

    }

})();