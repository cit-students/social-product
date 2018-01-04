(function () {
    'use stricts';
    var todoApp = angular.module('todoApp');
    todoApp.directive('citProfile',citProfile);
    citProfile.$inject = ['$log'];
    function citProfile() {
        return{
            restrict: 'E',
            templateUrl:'components/layout/profile.html'
        };

    }

})();