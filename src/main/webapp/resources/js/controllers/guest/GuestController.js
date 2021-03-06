/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var GuestControllers = angular.module('GuestControllers', []);

GuestControllers.controller('GuestLocationController', ['$scope', '$http', function ($scope, $http) {

        $scope.selectLocation = function (location) {
            $scope.selectedLocation = location;
            console.log($scope.selectedLocation);
        };

        $scope.getAllLocations = function () {

            $http.get('location/').success(function (response) {
                $scope.locations = response;
            }).error(function () {
                console.log('so sad');
            })
        };

        $scope.getAllLocations();
    }]);

GuestControllers.controller('GuestPackageOptionController', ['$scope', '$http', function ($scope, $http) {

        $scope.selectPackageOption = function (packageOption) {
            $scope.selectedPackageOption = packageOption;
            console.log($scope.selectedPackageOption);
        };

        $scope.getAllPackageOptions = function () {

            $http.get('packageOption/').success(function (response) {
                $scope.packageOptions = response;
            }).error(function () {
                console.log('so sad');
            })
        };
        
        $scope.getAllPackageOptions();
    }]);

GuestControllers.controller('GuestMonitorPackageController', ['$scope', '$http', function ($scope, $http) {

    $scope.monitorPackage = function (packageToMonitorId) {

            $http.get('package/' + packageToMonitorId).success(function (response) {
                $scope.packageToMonitor = response;
                console.log(response);
            }).error(function () {

            });

            $http.get('package/' + packageToMonitorId + '/packageStatus').success(function (response) {
                $scope.packageStatuses = response;
                console.log(response);
            }).error(function () {

            });
        }
        $scope.packageId = 0;
    
    }]);