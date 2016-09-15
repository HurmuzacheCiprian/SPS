(function() {
     'use strict';

     angular
         .module('sps')
         .controller('ProductSelectionController', ProductSelectionController);

     ProductSelectionController.$inject = ['$scope', '$state', '$cookies', 'ProductSelectionService'];

     function ProductSelectionController($scope, $state, $cookies, ProductSelectionService) {
        $scope.selections = [];
        $scope.catalogue = [];
        $scope.addToSelection = addToSelection;
        $scope.locationError = false;
        $scope.goToConfirmationPage = goToConfirmationPage

        init();

        function init() {
            $cookies.put('customerId','test-customer1');
            ProductSelectionService.getLocationId($cookies.get('customerId'))
                .then(function(data) {
                    ProductSelectionService.getCatalogue(data.data.locationId)
                        .then(function(data) {
                           $scope.catalogue = data.data.catalogueOfProducts;
                        });
                    $scope.locationError = false;
                }, function(error) {
                    $scope.locationError = true;
                    $scope.errorMessage = error.data.message;
                });
        }

        function addToSelection(sport) {
            var index = $scope.selections.indexOf(sport);
            if(index != -1) {
                $scope.selections.splice(index,1);
            } else {
                $scope.selections.push(sport);
            }
        }

        function goToConfirmationPage() {
            $state.go('confirmation', {selected: $scope.selections, customerId:$cookies.get('customerId')});
        }

     }


 })();