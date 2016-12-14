<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon" href="resources/images/Capture.PNG">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<style>
.msg-val {
	color: red;
}
.msg-success {
	color: blue;
} 
body{
    background-color: ;
    color: #0000;
}
th {
    background-color:#09568d ;
    color:#FFFFFF;	
}
</style>
<title>Collaboration Website</title>
</head>
<body ng-app="myApp" ng-controller="getData" class="container">

<h1>Blog Details</h1>
 <a class="w3-btn  w3-indigo w3-border w3-border-dark-blue w3-round-xlarge" href="/zeedle" role="button">Home</a>
<hr>
  <br>
      <h3>Title: {{blogdata.blogTitle}}</h3>
      <h3>Description: {{blogdata.blogDesc}}</h3>
      
    <script src="resources/js/angular.min.js"></script> 
    <script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	 <script>
		var myApp = angular.module('myApp',[]);
		myApp.controller('getData', function($scope)
		 { 	
			$scope.blogdata = ${blogdetails};
		 });	
</script>
</body>
</html>