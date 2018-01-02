
var todoApp = angular.module('todoApp');

todoApp.config(function ($stateProvider) {
    var loginState = {
        name: 'main',
        url: '',
        templateUrl: '../list/list.html',
        controller: 'MainController',
        controllerAs: '$ctrl',
        reloadOnSearch: false
    };

    var productState = {
        name: 'product',
        url: '/product',
        templateUrl: '../products/product.html',
        controller: 'MainController',
        controllerAs: '$ctrl',
        reloadOnSearch: false
    };
    $stateProvider.state(loginState);
    $stateProvider.state(productState);
});