var phonecatControllers = angular.module('phonecatControllers', []);

phonecatControllers.controller('CourierController', ['$scope', '$http','$filter', function ($scope, $http, $filter) {

        $scope.selectCourier = function (courier) {
            $scope.selectedCourier = courier;
            $scope.selectedCourier.hireDate = $filter('date')($scope.selectedCourier.hireDate,"yyyy-MM-dd");
            $scope.selectedCourier.dismissDate = $filter('date')($scope.selectedCourier.dismissDate,"yyyy-MM-dd");
            console.log($scope.selectedCourier);
        };

        $scope.getAllCouriers = function () {

            $http.get('courier/all').success(function (response) {
                $scope.couriers = response;
            }).error(function () {
                console.log(response);
            })
        };

        $scope.addCourier = function (newCourier) {
            var _newCourier = angular.copy(newCourier);
            _newCourier.hireDate = new Date(newCourier.hireDate).getTime();
            _newCourier.dismissDate = new Date(newCourier.dismissDate).getTime();
            
            alert("hire date " + _newCourier.hireDate);
            
            $http.post('courier/add', _newCourier).success(function (response) {
                $scope.getAllCouriers();
            }).error(function () {

            })
        };
        
        $scope.updateCourier = function (courierToUpdate) {
            
            var _newCourier = angular.copy(courierToUpdate);
            _newCourier.hireDate = new Date(courierToUpdate.hireDate).getTime();
            _newCourier.dismissDate = new Date(courierToUpdate.dismissDate).getTime();
            
            alert("hire date " + _newCourier.hireDate);
            
            $http.post('courier/update', _newCourier).success(function (response) {
                $scope.getAllCouriers();
            }).error(function () {
                console.log('so sad');
            })
        }

        $scope.deleteCourier = function (courierToDelete) {
            if (!courierToDelete)
                alert("delete null!!");
            $http.post('courier/delete', courierToDelete).success(function (response) {
                $scope.getAllCouriers();
            }).error(function () {
                console.log('so sad');
            })
        }

        $scope.getAllCouriers();
    }]);

phonecatControllers.controller('LocationController', ['$scope', '$http', function ($scope, $http) {

        $scope.selectLocation = function (location) {
            $scope.selectedLocation = location;
            console.log($scope.selectedLocation);
        };

        $scope.getAllLocations = function () {

            $http.get('location/all').success(function (response) {
                $scope.locations = response;
            }).error(function () {
                console.log('so sad');
            })
        };

        $scope.addLocation = function (newLocation) {
            $http.post('location/add', newLocation).success(function (response) {
                $scope.getAllLocations();
                newLocation = {};
            }).error(function () {
                console.log('so sad');
            })
        };

        $scope.updateLocation = function (locationToUpdate) {
            $http.post('location/update', locationToUpdate).success(function (response) {
                $scope.getAllLocations();
            }).error(function () {
                console.log('so sad');
            })
        }

        $scope.deleteLocation = function (locationToDelete) {
            if (!locationToDelete)
                alert("delete null!!");
            $http.post('location/delete', locationToDelete).success(function (response) {
                $scope.getAllLocations();
            }).error(function () {
                console.log('so sad');
            })
        }

        $scope.getAllLocations();
    }]);

phonecatControllers.controller('PackageOptionController', ['$scope', '$http', function ($scope, $http) {

        $scope.selectPackageOption = function (packageOption) {
            $scope.selectedPackageOption = packageOption;
            console.log($scope.selectedPackageOption);
        };

        $scope.getAllPackageOptions = function () {

            $http.get('packageOption/all').success(function (response) {
                $scope.packageOptions = response;
            }).error(function () {
                console.log('so sad');
            })
        };

        $scope.addPackageOption = function (newPackageOption) {
            $http.post('packageOption/add', newPackageOption).success(function (response) {
                $scope.getAllPackageOptions();
            }).error(function () {
                console.log('so sad');
            })
        };
        
        $scope.updatePackageOption = function (packageOption) {
            $http.post('packageOption/update', packageOption).success(function (response) {
                $scope.getAllPackageOptions();
            }).error(function () {
                console.log('so sad');
            })
        };
        
        $scope.deletePackageOption = function (packageOption) {
            $http.post('packageOption/delete', packageOption).success(function (response) {
                $scope.getAllPackageOptions();
            }).error(function () {
                console.log('so sad');
            })
        };

        $scope.getAllPackageOptions();
    }]);
