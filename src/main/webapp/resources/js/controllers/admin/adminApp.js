/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


'use strict';

var AdminApp = angular.module('AdminApp', ['ngRoute', 'AdminControllers','ngAnimate','ngCookies']);



// Declare app level module which depends on filters, and services

AdminApp.config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/courier', {
            templateUrl: 'couriers',
            controller: 'AdminCourierController'
        }).when('/location', {
            templateUrl: 'locations',
            controller: 'AdminLocationController'
        }).when('/packageOption', {
            templateUrl: 'packageOptions',
            controller: 'AdminPackageOptionController'
        }).when('/user', {
            templateUrl: 'users',
            controller: 'AdminUserController'
        }).when('/monitorPackage', {
            templateUrl: 'monitorPackage',
            controller: 'AdminMonitorPackageController'
        }).when('/myProfile', {
            templateUrl: 'myProfile',
            controller: 'AdminProfileController'
        }).when('/track', {
            templateUrl: 'tracks',
            controller: 'AdminTracksController'
        }).otherwise({redirectTo: '/courier'});
    }]);