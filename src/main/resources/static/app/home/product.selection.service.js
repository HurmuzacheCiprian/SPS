(function() {
    'use strict';

    angular
        .module('sps')
        .factory('ProductSelectionService', ProductSelectionService);

    ProductSelectionService.$inject = ['$http'];

    function ProductSelectionService($http) {
        return {
            getLocationId: getLocationId,
            getCatalogue: getCatalogue
        };

        function getLocationId(customerId) {
            return $http({
                url: '/api/customer-location?customerID='+ customerId,
                method: 'GET'
            });
        }

        function getCatalogue(locationId) {
            return $http({
                url: '/api/catalogue/products?locationID='+ locationId,
                method: 'GET'
            });
        }

    }

})();