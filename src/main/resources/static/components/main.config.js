

todoApp.config(function ($stateProvider) {
    var loginState = {
        name: 'main',
        url: '/',
        templateUrl: 'components/login/login.html',
        controller: 'LoginController',
        controllerAs: '$ctrl',
        reloadOnSearch: false
    };

    var productState = {
        name: 'product',
        url: '/product',
        templateUrl: 'components/products/product.html',
        controller: 'ProductController',
        controllerAs: '$ctrl',
        reloadOnSearch: false
    };

    $stateProvider.state(loginState);
    $stateProvider.state(productState);
});