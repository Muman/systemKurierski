'use strict';

var IndexApp = angular.module('IndexApp', []);

// Declare app level module which depends on filters, and services

IndexApp.controller('IndexController', ['$scope', '$http', function ($scope, $http) {
        console.log('In Controller index');

        $scope.registerUser = function (newUser,newUserInfo) {
            console.log(newUser);

            newUser.enabled = true;
            newUserInfo.company = true;

            var newUserWrapper = {};
            
            newUserWrapper.user = newUser;
            newUserWrapper.userInfo = newUserInfo;

            $http.post('/SystemKurierski/register', newUserWrapper).success(function (response) {
                document.location.href='/SystemKurierski/login';
            }).error(function (response) {
                console.log(response);
            });
        }
    }]);