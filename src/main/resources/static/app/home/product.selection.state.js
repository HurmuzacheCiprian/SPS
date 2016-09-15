(function() {
    'use strict';

    angular
        .module('sps')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider','$urlRouterProvider'];

    function stateConfig($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('/product-selection');
       $stateProvider.state('productSelection', {
            url: '/product-selection',
            parent: 'app',
            views: {
                'content@': {
                    templateUrl: 'app/home/product.selection.html',
                    controller: 'ProductSelectionController'
                }
            }
        });
    }
})();