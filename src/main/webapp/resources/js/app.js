/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
 
'use strict';
 
var AngularSpringApp = {};
 
var App = angular.module('AngularSpringApp', ['ngRoute']);
 
// Declare app level module which depends on filters, and services
 
App.config(['$routeProvider', function($routeProvider){
    $routeProvider.when('/courier', {
        templateUrl: '/couriers.html',
        controller: 'CourierController'
    });
}]);
 
