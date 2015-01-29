var AdminControllers = angular.module('AdminControllers', []);

AdminControllers.controller('AdminCourierController', ['$scope', '$http','$filter', function ($scope, $http, $filter) {

        $scope.selectCourier = function (courier) {
            $scope.selectedCourier = courier;
            $scope.selectedCourier.hireDate = $filter('date')($scope.selectedCourier.hireDate,"yyyy-MM-dd");
            $scope.selectedCourier.dismissDate = $filter('date')($scope.selectedCourier.dismissDate,"yyyy-MM-dd");
            console.log($scope.selectedCourier);
        };

        $scope.getAllCouriers = function () {

            $http.get('courier/').success(function (response) {
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
            
            $http.post('courier/', _newCourier).success(function (response) {
                $scope.getAllCouriers();
            }).error(function () {

            })
        };
        
        $scope.updateCourier = function (courierToUpdate) {
            
            var _newCourier = angular.copy(courierToUpdate);
            _newCourier.hireDate = new Date(courierToUpdate.hireDate).getTime();
            _newCourier.dismissDate = new Date(courierToUpdate.dismissDate).getTime();
            
            alert("hire date " + _newCourier.hireDate);
            
            $http.put('courier/', _newCourier).success(function (response) {
                $scope.getAllCouriers();
            }).error(function () {
                console.log('so sad');
            })
        }

        $scope.deleteCourier = function (courierToDelete) {
            if (!courierToDelete)
                alert("delete null!!");
            $http.delete('courier/'+courierToDelete.id).success(function (response) {
                $scope.getAllCouriers();
            }).error(function () {
                console.log('so sad');
            })
        }

        $scope.getAllCouriers();
    }]);

AdminControllers.controller('AdminLocationController', ['$scope', '$http', function ($scope, $http) {

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

        $scope.addLocation = function (newLocation) {
            $http.post('location/', newLocation).success(function (response) {
                $scope.getAllLocations();
                newLocation = {};
            }).error(function () {
                console.log('so sad');
            })
        };

        $scope.updateLocation = function (locationToUpdate) {
            $http.put('location/', locationToUpdate).success(function (response) {
                $scope.getAllLocations();
            }).error(function () {
                console.log('so sad');
            })
        }

        $scope.deleteLocation = function (locationToDelete) {
            console.log("deleting location ");
            console.log(locationToDelete);
            
            if (!locationToDelete)
                alert("delete null!!");
            $http.delete('location/'+locationToDelete.id).success(function (response) {
                $scope.getAllLocations();
            }).error(function () {
                console.log('so sad');
            })
        }

        $scope.getAllLocations();
    }]);

AdminControllers.controller('AdminPackageOptionController', ['$scope', '$http', function ($scope, $http) {

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

        $scope.addPackageOption = function (newPackageOption) {
            $http.post('packageOption/', newPackageOption).success(function (response) {
                $scope.getAllPackageOptions();
            }).error(function () {
                console.log('so sad');
            })
        };
        
        $scope.updatePackageOption = function (packageOption) {
            $http.put('packageOption/', packageOption).success(function (response) {
                $scope.getAllPackageOptions();
            }).error(function () {
                console.log('so sad');
            })
        };
        
        $scope.deletePackageOption = function (packageOption) {
            $http.delete('packageOption/'+packageOption.id).success(function (response) {
                $scope.getAllPackageOptions();
            }).error(function () {
                console.log('so sad');
            })
        };

        $scope.getAllPackageOptions();
    }]);


AdminControllers.controller('AdminUserController', ['$scope', '$http', function ($scope, $http) {

        $scope.selectUser = function () {
            $scope.selectedUser = this.user;
            console.log($scope.selectedUser);
        };

        $scope.getAllUsers = function () {

            $http.get('user/').success(function (response) {
                $scope.users = response;
                console.log(response);
            }).error(function () {
                console.log('so sad');
            })
        };

        $scope.addUser = function (newUser) {
            
//            var newUserWrapper = {};
//            newUserWrapper.user = newUser;
//            newUserWrapper.userInfo = newUserInfo;
//            
            newUser.enabled = true;
            newUser.userInfo.company = false;
            
            console.log(newUser);
            
            $http.post('user/', newUser).success(function (response) {
                $scope.getAllUsers();
            }).error(function () {
                console.log('so sad');
            })
        };
        
        $scope.updateUser = function (user) {
            $http.put('user/', user).success(function (response) {
                $scope.getAllUsers()();
            }).error(function () {
                console.log('so sad');
            })
        };
        
        $scope.deleteUser = function (user) {
            $http.delete('user/'+user.name).success(function (response) {
                $scope.getAllUsers()();
            }).error(function () {
                console.log('so sad');
            })
        };

        $scope.getAllUsers();
    }]);

AdminControllers.controller('AdminMonitorPackageController', ['$scope', '$http', function ($scope, $http) {

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