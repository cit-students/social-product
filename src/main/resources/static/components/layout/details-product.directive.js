(function () {
    'use stricts';
    var todoApp = angular.module('todoApp');
    todoApp.directive('detailsProduct',detailsProduct);
    detailsProduct.$inject = ['$log'];
    function detailsProduct() {
        return{
            restrict: 'E',
            templateUrl:'components/layout/details-product.html'
        };

    }

})();