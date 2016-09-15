(function() {
    'use strict';

    angular
        .module('sps')
        .controller('NavbarController', NavbarController);

    NavbarController.$inject = ['$scope'];

    function NavbarController ($scope) {
        $scope.message = 'Navbar';
    }
})();
