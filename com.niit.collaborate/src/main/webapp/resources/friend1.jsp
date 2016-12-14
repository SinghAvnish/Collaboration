<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</style>
<style type="text/css">
.msg-val {
	color: red;
}
.msg-success {
	color: blue;
} 
body{
    background-color:#5DADEC ;
    color: #0000;
}
th {
    background-color:#09568d ;
    color:#FFFFFF;	
}
</style>

</head>
<body>
<div class="container" ng-controller="FriendController as ctr"> 
<input type="submit" ng-click="ctr.getMyFriend()" class="btn btn-primary" value="get Friend"/>  
<div ng-repeat="friend in ctr.friend | filter: sear_text">
<div class="container" ng-controller="UserController as ctrl">
<div ng-hide="currentUser.id !== friend.friendId">
<p>friend Id: {{friend.id}} &nbsp;&nbsp;&nbsp;Status: {{friend.status}}
<!-- <input type="submit" ng-click="ctr.unFriend(friend.id)" class="btn btn-warning" value="unfriend"/> -->
<a href="#/chat"><input type="submit" class="btn btn-warning" value="Send Message"/></a>
</p></div>
</div> 
</div>
</div>

</body>
</html>
