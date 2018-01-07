

todoApp.config(function ($stateProvider) {
    var loginState = {
        name: 'main',
        url: '',
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
    var profileState = {
        name: 'profile',
        url: '/profile',
        templateUrl: 'components/profile/profile.html',
        controller: 'ProfileController',
        controllerAs: '$ctrl',
        reloadOnSearch: false
    };
    var detailsState = {
        name: 'details',
        url: '/details',
        templateUrl: 'components/products/details.html',
        controller: 'DetailsController',
        controllerAs: '$ctrl',
        reloadOnSearch: false
    };


    $stateProvider.state(loginState);
    $stateProvider.state(productState);
    $stateProvider.state(profileState);
    $stateProvider.state(detailsState);

});