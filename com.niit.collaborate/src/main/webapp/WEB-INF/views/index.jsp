<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 <%@page isELIgnored="false" %>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring 4 MVC  Index Page</title>
<!-- <script src="resources/js/bootstrap.min.js"></script>
 -->  
 <script src="resources/js/angular.js"></script>
<script src="resources/js/angular-resource.min.js"></script>
<script src="resources/js/angular-route.js"></script>

<script src="resources/js/app.js"></script> 
<script src="resources/js/UserController.js"></script> 
<script src="resources/js/userservice.js"></script> 
<script src="resources/js/BlogController.js"></script> 




</head>
 
<body ng-app= "myApp">
	<nav class="navbar navbar-inverse" >
  <div class="container-fluid">
    <div class="navbar-header">
     </div>
    <ul class="nav navbar-nav">
      <li class="active">
      <a href="home">Home</a></li>
       <li><a href="blogPage">Blog</a></li>
      <li><a href="userPage">User</a></li>
      
       <ul class="nav navbar-nav navbar-right">
      
       <li><a href="loginpage" ><span class="glyphicon glyphicon-log-in"></span>Login</a></li>
     
	
	
		
     </ul>
   </div>
    
</nav>
<div ng-view></div>
</body>

   