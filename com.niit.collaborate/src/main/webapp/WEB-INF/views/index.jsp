<!DOCTYPE html>
<html  ng-app="app" lang="en">
<head>
  <title>Index PAGE</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <body>
 <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/com.niit.collaborate"></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="/com.niit.collaborate">Home</a></li>
         
       		 <li><a href="#/blogList">Blog</a></li>
             <li><a href="#/blogList">Blog List</a></li>
          
          
           <li><a href="#/event">Events</a></li>
           
           
            <li><a href="#/friend">Friends</a></li>
             <li><a href="#/friendrequest">Friendlist</a></li>
            <li><a href="#/blogList">Blog List</a></li>
       
         	<li><a href="#/chat">Chat</a></li>
       
       <ul class="nav navbar-nav navbar-right">
       <div ng-controller="UserController as ctrl">
    <div ng-hide="currentUser.username!==ctrl.user.username">  
        <!-- <li><a href="#/userpage"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li> -->
        <!-- <li><a href="#/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li> -->
       <a href="#/login"><input type="submit" class="btn btn-primary navbar-btn" value="Login"/></a>
      </div>
      <div ng-hide="currentUser.username===ctrl.user.username">
         <!-- <li><a href="#/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li> -->
         <input type="submit" ng-click="ctrl.logout()" class="btn btn-primary navbar-btn" value="Logout"/>
      </div>
      </div>      </ul>
    
  </div>
</nav>
  </body>
  </head>
  <div>
 </div>
 
</div>
<div ng-view></div>
<script src="resources/js/jquery-1.12.4.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>  

<script src="resources/js/angular.js"></script>
<script src="resources/js/angular-resource.min.js"></script>
<script src="resources/js/angular-route.js"></script>
<script src="resources/js/angular-cookies.js"></script>
<script src="resources/js/sockjs.js"></script>
<script src="resources/js/stomp.js"></script>
<script src="resources/js/lodash.js"></script>
<script src="resources/js/npm.js"></script>
 <script src="resources/js/lodash.min.js"></script> 
 
 <script src="resources/js/myapp.js"></script>

 <script src="resources/js/HomeController.js"></script>
<script src="resources/js/UserController.js"></script>
<script src="resources/js/UserService.js"></script>
 <script src="resources/js/BlogController.js"></script> 
<script src="resources/js/EventController.js"></script>
 <script src="resources/js/ChatController.js"></script> 
 <script src="resources/js/ChatService.js"></script>
  <script src="resources/js/FriendController.js"></script> 
  <script src="resources/js/FriendService.js"></script> 
  


</body>
</html>