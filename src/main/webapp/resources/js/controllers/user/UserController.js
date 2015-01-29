
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

UserControllers.controller('UserNewPackageController', ['$scope', '$http', '$location', function ($scope, $http, $location) {
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

        $scope.showPdf = function () {
            $http.get('/SystemKurierski/user/newPackage/pdf/1');
            console.log("Showing new pdf");
            $location.url("//newPackage/pdf/1");
        }

        $scope.registerNewPackage = function (newPackage) {

            console.log(newPackage);

            $http.post('newPackage/', newPackage).success(function (response) {

            }).error(function () {
                console.log('so sad');
            })
        }

        $scope.getAllPackageOptions();
    }]);

UserControllers.controller('UserMonitorPackageController', ['$scope', '$http', '$location', function ($scope, $http, $location) {
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

UserControllers.controller('UserMyPackagesController', ['$scope', '$http', '$location', function ($scope, $http, $location) {
        $scope.getMyPackages = function (packageToMonitorId) {

            $http.get('package/').success(function (response) {
                $scope.myPackages = response;
                console.log(response);
            }).error(function () {

            });
        }

        $scope.getMyPackages();
    }]);

UserControllers.controller('UserMyProfileController', ['$scope', '$http', '$location', function ($scope, $http, $location) {
        $scope.newPassword = '';
        
        $scope.updatedUserInfo = {};

        $scope.getUserData = function () {

            $http.get('myData/').success(function (response) {
                $scope.currentUser = response;
                $scope.updatedUserInfo = $scope.currentUser.userInfo;
                console.log(response);
            }).error(function () {

            });
        }

        $scope.updateUserInfo = function (updatedUserInfo) {

            $http.put('update/' + $scope.currentUser.username, updatedUserInfo).success(function (response) {
                console.log(response);
            });
        }

        $scope.changePassword = function (username,newPassword) {

            $scope.map = new Object();
            $scope.map["username"] = username.toString();
            $scope.map["password"] = newPassword.toString();

            $http.put('changePassword/', $scope.map).success(function (response) {
                console.log(response);
            }).error(function (response) {
                console.log(response);
            });
        }

        $scope.getUserData();
    }]);