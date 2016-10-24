<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@page isElIgnored="false" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring 4 MVC  Index Page</title>
<script src="resources/js/angular.min.js"></script>
        <script src="resources/js/angular-resource.js"></script>
	<script src="resources/app.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}app-resources/css/style.css"/>
</head>
 
<body ng-app="myApp">

   <div ng-controller="usercontroller as userCtrl">
       <h1> Spring MVC 4 REST + AngularJS </h1>
	<form name="userForm" method="POST">
	    <table>
		<tr><td colspan="2">
		  <div ng-if="userCtrl.flag != 'edit'">
		     <h3> Add New Person </h3> 
		  </div>
		  <div ng-if="userCtrl.flag == 'edit'">
		     <h3> Update Person for ID: {{ userCtrl.user.userId }} </h3> 
		  </div> </td>
		</tr>
		<tr>
		      <td>Name: </td> <td><input type="text" name="name" ng-model="userCtrl.user.name" required/> 
         	      <span ng-show="userForm.name.$error.required" class="msg-val">Name is required.</span> </td>
		</tr>
		<tr>
		      <td>Email: </td> <td> <input type="text" name="Email" ng-model="userCtrl.user.Email" required/> 
	              <span ng-show="userForm.Email.$error.required" class="msg-val">Email is required.</span> </td>
		</tr>
		<tr>
		      <td>Password: </td> <td> <input type="text" name="Email" ng-model="userCtrl.user.Password" required/> 
	              <span ng-show="userForm.Password.$error.required" class="msg-val">Password is required.</span> </td>
		</tr>
		<tr>
		      <td>Address: </td> <td> <input type="text" name="Address" ng-model="userCtrl.user.Address" required/> 
	              <span ng-show="userForm.Address.$error.required" class="msg-val">Address is required.</span> </td>
		</tr>
		
		
		<tr>
		     <td colspan="2"> <span ng-if="personCtrl.flag=='created'" class="msg-success">User successfully added.</span>
		     <span ng-if="userCtrl.flag=='failed'" class="msg-val">User already exists.</span> </td>
		</tr>
	        <tr><td colspan="2">
	            <div ng-if="userCtrl.flag != 'edit'">
		       <input  type="submit" ng-click="userCtrl.save()" value="Add Person"/> 
		       <input type="button" ng-click="userCtrl.reset()" value="Reset"/>
		    </div>
		    <div ng-if="personCtrl.flag == 'edit'">
		       <input  type="submit" ng-click="userCtrl.update()" value="Update Person"/> 	
			   <input type="button" ng-click="userCtrl.cancelUpdate()" value="Cancel"/>				   
		    </div> </td>
		</tr>
		<tr>
		     <td colspan="2"> <span ng-if="userCtrl.flag=='deleted'" class="msg-success">User successfully deleted.</span>
		</tr>
	    </table>     
	</form>
        <table>
	      <tr><th>ID </th> <th>Name</th> <th>Email</th><th>Password</th><th>Address</th></tr>
	      <tr ng-repeat="row in userCtrl.User">
	         <td><span ng-bind="row.userId"></span></td>
	         <td><span ng-bind="row.name"></span></td>
	         <td><span ng-bind="row.Email"></span></td>
	         <td><span ng-bind="row.Password"></span></td>
	         <td><span ng-bind="row.Address"></span></td>
	         <td>
		    <input type="button" ng-click="userCtrl.deleteuser(row.userId)" value="Delete"/>
		    <input type="button" ng-click="userCtrl.edituser(row.userId)" value="Edit"/>
		    <span ng-if="personCtrl.flag=='updated' && row.userId==userCtrl.updatedId" class="msg-success">User successfully updated.</span> </td> 
	      </tr>	
	</table>
	</div>
  </body>
</html>   