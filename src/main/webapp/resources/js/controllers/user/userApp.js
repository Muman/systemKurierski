
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
        controller: 'UserMonitorPackageController'
    }).when('/location', {
        templateUrl: 'locations',
        controller: 'UserLocationController'
    }).when('/packageOption', {
        templateUrl: 'packageOptions',
        controller: 'UserPackageOptionController'
    }).when('/newPackage',{
        templateUrl: 'newPackage',
        controller: 'UserNewPackageController'
    }).when('/viewPdf',{
        templateUrl: '/newPackage/pdf/1',
        controller: 'UserNewPackageController'
    }).when('/myPackages',{
        templateUrl: 'myPackages',
        controller: 'UserMyPackagesController'
    }).when('/myProfile',{
        templateUrl: 'myProfile',
        controller: 'UserMyProfileController'
    }).otherwise({redirectTo: '/location'});
}]);