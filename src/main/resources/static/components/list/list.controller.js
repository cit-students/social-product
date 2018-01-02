(function () {
    'use stricts';
    var todoApp = angular.module('todoApp');
    todoApp.controller('MainController', MainController);

    MainController.$inject = ['$log','$state', '$stateParams','$uibModal','SweetAlert'];

    function MainController($log,$state,$stateParams,$uibModal,SweetAlert) {
        var vm = this;
        vm.error = "";
        vm.create = create;
        vm.edit = edit;
        vm.delete = _delete;
        // vm.search = search;
        function create() {
            $log.info('Create products!');
            openFormModal();
        }

        function edit() {
            $log.info('edit products!');

            openFormModal();
        }
        function _delete() {
            SweetAlert.swal({
                    title: "Are you sure?",
                    text: "Your will not be able to recover Product ",
                    type: "warning",
                    showCancelButton: true,
                    confirmButtonColor: "#DD6B55", confirmButtonText: "Yes, delete it!",
                    cancelButtonText: "No, cancel plx!",
                    closeOnConfirm: false,
                    closeOnCancel: true
                },
                function (isConfirm) {
                    $log.info(isConfirm);
                    if (isConfirm) {

                            SweetAlert.swal("Deleted!", 'Product ' +  musican.musicanName + ' file has been deleted.', "success");
                    }
                });
        }

        // function search() {
        //     vm.filter.page = 1;
        //     getData(vm.filter);
        // }
        function openFormModal() {
            var modalInstance = $uibModal.open({
                animation: false,
                ariaLabelledBy: 'modal-title',
                ariaDescribedBy: 'modal-body',
                templateUrl: '../form/form.html',
                controller: 'ProductFormController',
                controllerAs: '$ctrl',
                size: 'modal-md',
                resolve: {
                    id: function () {

                    },
                    form: function () {

                    }


                }
            });

            modalInstance.result.then(function (resp) {
                $log.info('Success');
                getData(vm.filter);
            }, function () {
                $log.info('Modal dismissed at: ' + new Date());
            });
        }
    }
})();