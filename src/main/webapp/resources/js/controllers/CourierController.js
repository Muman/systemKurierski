App.controller('CourierController', ['$scope', '$http', function ($scope, $http) {

    $scope.getAllCouriers = function () {
        
        $http.get('courier/all.json').success(function (response) {
            $scope.couriers = response;
        }).error(function () {
            $scope.setError('Could not display all couriers');
        })};

    $scope.getAllCouriers();
}]);

