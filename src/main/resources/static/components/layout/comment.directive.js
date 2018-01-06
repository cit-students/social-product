(function () {
    'use stricts';
    var todoApp = angular.module('todoApp');
    todoApp.directive('commentProduct',commentProduct);
    commentProduct.$inject = ['$log'];
    function commentProduct() {
        return{
            restrict: 'E',
            templateUrl:'components/layout/comment.html'
        };

    }

})();