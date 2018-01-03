(function () {
    var todoApp = angular.module('todoApp');
    todoApp.directive('citTable',citTable);
    citTable.$inject = ['$log'];
    function citTable() {
        return{
            restrict: 'E',
            templateUrl:'components/list/list.html'
        };

    }
})();