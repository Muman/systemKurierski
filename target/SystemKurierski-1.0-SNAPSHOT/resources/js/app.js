/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
 
'use strict';
 
var AngularSpringApp = {};
 
var App = angular.module('App', ['ngRoute','phonecatControllers']);
 
// Declare app level module which depends on filters, and services
 
App.config(['$routeProvider', function($routeProvider){
    $routeProvider.when('/courier', {
        templateUrl: 'courier/layout',
        controller: 'CourierController'
    }).when('/location', {
        templateUrl: 'location/layout',
        controller: 'LocationController'
    }).when('/packageOption', {
        templateUrl: 'packageOption/layout',
        controller: 'PackageOptionController'
    }).otherwise({redirectTo: '/courier'});
}]);