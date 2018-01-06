(function () {
    'use stricts';
    var todoApp = angular.module('todoApp');
    todoApp.directive('changeAvatar',changeAvatar);
    changeAvatar.$inject = ['$log'];
    function changeAvatar() {
        return{
            restrict: 'E',
            templateUrl:'components/layout/change-avatar.html'
        };

    }

})();