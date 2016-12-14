 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
 
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page isELIgnored="false" %>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html  ng-app="app" lang="en">
<head>
  <title>HOME PAGE</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="resources/css/bootstrap.min.css">  
 

</head>
<body >

<!-- style="background-color:#00bfff; -->
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/zeedle"></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#/">Home</a></li>
         <li><a href="#/userlist">User List</a></li> 
        
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="">Blogs <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#/blog">Add New Blogs</a></li>
            <li><a href="#/blogList">Blog List</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Friends <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#/friend">View friends</a></li>
            <li><a href="#/friendrequest">Friend request</a></li>
          </ul>
        </li>
        <li><a href="#/event">Events</a>
		  <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Chat Forums <span class="caret"></span></a>
          <ul class="dropdown-menu">
          <li><a href="#/chatforum">Chat Forum</a></li>
           <li><a href="#/chat">Chat</a></li>
          </ul>
        </li>
       
      </ul>
      
      <ul class="nav navbar-nav navbar-right">
       <div ng-controller="UserController as ctrl">
    <div ng-hide="currentUser.name!==ctrl.user.name">  
        <!-- <li><a href="#/userpage"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li> -->
        <!-- <li><a href="#/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li> -->
       <a href="#/login"><input type="submit" class="btn btn-primary navbar-btn" value="Login"/></a>
      </div>
      <div ng-hide="currentUser.name===ctrl.user.name">
         <!-- <li><a href="#/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li> -->
         <input type="submit" ng-click="ctrl.logout()" class="btn btn-primary navbar-btn" value="Logout"/>
      </div>
      </div>      </ul>
     </div>
  </div>
</nav>

  <div>
 </div>
 
</div>
<div ng-view></div>
<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>  

<script src="resources/js/angular.js"></script> 
 <script src="resources/js/angular-resource.min.js"></script> 
<script src="resources/js/angular-route.js"></script>
<script src="resources/js/angular-cookies.js"></script>
 <script src="resources/js/sockjs.js"></script>
<script src="resources/js/stomp.js"></script>
 <script src="resources/js/lodash.min.js"></script>
 <script src="resources/lodash/dist/lodash.min.js"></script>
  
<script src="resources/js/myapp.js"></script>
<script src="resources/HomeController.js"></script> 
  <script src="resources/UserController.js"></script>
<script src="resources/UserService.js"></script> 
  <script src="resources/BlogController.js"></script>
 <script src="resources/EventController.js"></script>
 <script src="resources/ChatController.js"></script>
 <script src="resources/ChatService.js"></script>
  <script src="resources/FriendController.js"></script> 
  <script src="resources/FriendService.js"></script> 
 
</body>
</html>

