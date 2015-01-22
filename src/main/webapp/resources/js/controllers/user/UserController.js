/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var UserControllers = angular.module('UserControllers', []);

UserControllers.controller('UserLocationController', ['$scope', '$http', function ($scope, $http) {

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

UserControllers.controller('UserPackageOptionController', ['$scope', '$http', function ($scope, $http) {

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

UserControllers.controller('UserNewPackageController', ['$scope', '$http','$location', function ($scope, $http,$location) {
        $scope.idik = 1;

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
        
            $scope.showPdf = function(){
                $http.get('/SystemKurierski/user/newPackage/pdf/1');
                        
                        console.log("Showing new pdf");
                        $location.url("//newPackage/pdf/1");
            }

        $scope.registerNewPackage = function (newPackage) {

            console.log(newPackage);
            
            $http.post('newPackage/',newPackage).success(function (response) {

            }).error(function () {
                console.log('so sad');
            })
        }

        $scope.getAllPackageOptions();
    }]);

