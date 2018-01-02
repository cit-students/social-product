(function () {
    'use stricts';
    var todoApp = angular.module('todoApp');
    todoApp.directive('citFooter',citFooter);
    citFooter.$inject = ['$log'];
    function citFooter() {
        return{
            restrict: 'E',
            templateUrl:'../layout/footer.html'
        };

    }

})();