(function () {
    'use stricts';
    var todoApp = angular.module('todoApp');
    todoApp.directive('personalInfo',personalInfo);
    personalInfo.$inject = ['$log'];
    function personalInfo() {
        return{
            restrict: 'E',
            templateUrl:'components/layout/personal-info.html'
        };

    }

})();