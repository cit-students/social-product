(function () {
    'use stricts';
    var todoApp = angular.module('todoApp');
    todoApp.controller('ProductController', ProductController);

    ProductController.$inject = ['$log','$state', '$stateParams','$uibModal','SweetAlert'];

    function ProductController($log,$state,$stateParams,$uibModal,SweetAlert) {
    }
})();