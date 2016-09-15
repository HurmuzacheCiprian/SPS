(function() {
    'use strict';

    angular
        .module('sps')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider','$urlRouterProvider'];

    function stateConfig($stateProvider, $urlRouterProvider) {
       $urlRouterProvider.otherwise('/product-selection');
       $stateProvider.state('confirmation', {
            url: '/confirmation?selected&customerId',
            parent: 'app',
            views: {
                'content@': {
                    templateUrl: 'app/confirmation/confirmation.html',
                    controller: 'ConfirmationController'
                }
            }
        });
    }
})();