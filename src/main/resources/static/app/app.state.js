(function() {
    'use strict';

    angular
        .module('sps')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
       $stateProvider.state('app', {
            abstract: true,
            views: {
                'navbar@': {
                    templateUrl: 'app/navbar/navbar.html',
                    controller: 'NavbarController'
                }
            }
        });
    }
})();