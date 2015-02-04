var AdminControllers = angular.module('AdminControllers', ['ngAnimate','xeditable','ui.bootstrap']);

AdminControllers.factory('alertService', ['$timeout', '$filter',
    function ($timeout, $filter) {
        var alerts = [];

        var closeAlert = function (index) {
            alerts.splice(index, 1);
        };

        return {
            add: function (msg, type, timeout) {
                var alert = {
                    msg: msg,
                    type: type
                };
                alerts.push(alert);

                if (timeout) {
                    $timeout(function () {
                        closeAlert(alerts.indexOf(alert));
                    }, timeout);
                }
            },
            handleErrors: function (data) {
                if (data.status == 500) {
                    this.add("Oops! Something went wrong!", 'danger', 3000);
                } else if (data.status == 901) {
                    this.add("Session expired. Please refresh page and log in again.", 'danger', 3000);
                } else {
                    this.add(data.response, 'danger');
                }
            },
            closeAlert: closeAlert,
            alerts: alerts
        };
    }]);

AdminControllers.controller('AdminCourierController', ['$scope', '$http', '$filter', function ($scope, $http, $filter) {

        $scope.selectCourier = function (courier) {
            $scope.selectedCourier = courier;
            $scope.selectedCourier.hireDate = $filter('date')($scope.selectedCourier.hireDate, "yyyy-MM-dd");
            $scope.selectedCourier.dismissDate = $filter('date')($scope.selectedCourier.dismissDate, "yyyy-MM-dd");
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
            $http.delete('courier/' + courierToDelete.id).success(function (response) {
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

            if (!locationToDelete) {
                alert("delete null!!");
            }
            $http.delete('location/' + locationToDelete.id).success(function (response) {
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
            $http.delete('packageOption/' + packageOption.id).success(function (response) {
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
            $http.delete('user/' + user.name).success(function (response) {
                $scope.getAllUsers()();
            }).error(function () {
                console.log('so sad');
            })
        };

        $scope.getAllUserRoles = function () {
            $http.get('allUserRoles/').success(function (response) {
                $scope.userRoles = response;
            }).error(function (response) {

            });
        }

        $scope.selectUserRole = function (userRole) {
            $scope.selectedUserRole = userRole;
            console.log($scope.selectedUserRole);
        };

        $scope.getAllUserRoles();
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

AdminControllers.controller('AdminProfileController', ['$scope', '$http', 'alertService', function ($scope, $http, alertService,$timeout) {

        $scope.newAdminPassword = '';
        $scope.newAdminPasswordConfirm = '';
        $scope.updatedAdminInfo = {};
        $scope.alerts = alertService.alerts;

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

        $scope.changePassword = function () {

            $scope.map = new Object();
            $scope.map["username"] = $scope.currentUser.username.toString();
            $scope.map["password"] = $scope.newAdminPassword.toString();

            $http.put('changePassword/', $scope.map).success(function (response) {
                console.log(response);
                alertService.add("Has³o zosta³o zmienione", 'success', 3000);
                $scope.resetPasswordFields();
            }).error(function (response) {
                alertService.add("Spróbuj ponownie", 'success', 3000);
                console.log(response);
            });
        }

        $scope.resetPasswordFields = function () {
            $scope.newAdminPassword = '';
            $scope.newAdminPasswordConfirm = '';
        }

        $scope.getUserData();
    }]);