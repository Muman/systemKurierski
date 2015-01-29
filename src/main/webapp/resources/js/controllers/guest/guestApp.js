/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
 
'use strict';
 
var GuestApp = angular.module('GuestApp', ['ngRoute','GuestControllers']);
 
// Declare app level module which depends on filters, and services
 
GuestApp.config(['$routeProvider', function($routeProvider){
    $routeProvider.when('/location', {
        templateUrl: 'locations',
        controller: 'GuestLocationController'
    }).when('/packageOption', {
        templateUrl: 'packageOptions',
        controller: 'GuestPackageOptionController'
    }).when('/monitorPackage', {
        templateUrl: 'monitorPackage',
        controller: 'GuestMonitorPackageController'
    }).otherwise({redirectTo: '/location'});
}]);