(function () {
    'use stricts';
    var todoApp = angular.module('todoApp');
    todoApp.controller('ProfileController', ProfileController);

    ProfileController.$inject = ['$log', '$state', '$stateParams', '$uibModal', 'SweetAlert'];

    function ProfileController($log, $state, $stateParams, $uibModal, SweetAlert) {

    }
})();