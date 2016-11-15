'use strict';

var app = angular.module('myApp', ['ngRoute','ngResource']);
app.config(function($routeProvider){
	
	$routeProvider
	
	/*.when('/' ,{
		templatUrl:'c_home/home.html',
		controller:'Homecontroller'
		})
	*/
	.when('/userPage' ,{
		controller:'UserController',
		templateUrl:'resources/user.jsp'
		
		})
	
	.when('/blogPage' ,{
		controller:'BlogController',
		templateUrl:'resources/blog.jsp'
		
		})
	
	.when('/loginpage' ,{
		controller:'UserController',
		templateUrl:'resources/login.jsp'
		});
	

		
});