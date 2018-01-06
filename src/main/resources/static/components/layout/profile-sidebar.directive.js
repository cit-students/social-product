(function () {
    'use stricts';
    var todoApp = angular.module('todoApp');
    todoApp.directive('profileSidebar',profileSidebar);
    profileSidebar.$inject = ['$log'];
    function profileSidebar() {
        return{
            restrict: 'E',
            templateUrl:'components/layout/profile-sidebar.html'
        };

    }

})();