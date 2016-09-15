(function() {
    'use strict';

    angular
        .module('sps')
        .controller('ConfirmationController', ConfirmationController)

    ConfirmationController.$inject = ['$scope', '$stateParams'];

    function ConfirmationController($scope, $stateParams) {
        $scope.message = 'Confirmation';
        $scope.customer = $stateParams.customerId;
        $scope.selections = $stateParams.selected;
    }


})();