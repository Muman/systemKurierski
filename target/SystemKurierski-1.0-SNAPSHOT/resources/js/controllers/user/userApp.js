
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
 
'use strict';
var UserApp = angular.module('UserApp', ['ngRoute','UserControllers']);
 
// Declare app level module which depends on filters, and services
 
UserApp.config(['$routeProvider', function($routeProvider){
    $routeProvider.when('/monitorPackage', {
        templateUrl: 'monitorPackage',
        controller: 'UserLocationContorller'
    }).when('/location', {
        templateUrl: 'locations',
        controller: 'UserLocationController'
    }).when('/packageOption', {
        templateUrl: 'packageOptions',
        controller: 'UserPackageOptionController'
    }).otherwise({redirectTo: '/location'});
}]);