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

           //var user = {"firstName": "asd", "lastName": "ad", "companyName": "asd", "username": "asd", "password": "asd", "email": "asd@asd.pl", "phoneNumber": "231123", "city": "asdasd", "address": "asdsad", "postalCode": "asd", "enabled": true, "company": true};

            $http.post('/SystemKurierski/register', newUserWrapper).success(function (response) {
                console.log(response);
            }).error(function (response) {
                console.log(response);
            });
        }
    }]);