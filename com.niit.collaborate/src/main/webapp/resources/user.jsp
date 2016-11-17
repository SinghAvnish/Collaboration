<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<html lang="en-US">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


</head>
  <body >
  
   <div ng-controller="UserController as userCtrl">
   
       <div class="container">
	<form name="userForm" method="POST" >
	    <table>
		<tr><td colspan="2">
		  <div ng-if="userCtrl.flag != 'edit'">
		     <h3> Add New User </h3> 
		  </div>
		  <div ng-if="userCtrl.flag == 'edit'">
		     <h3> Update User for ID: {{ userCtrl.user.id }} </h3> 
		  </div> </td>
		</tr>
		
	<div class="form-group">
		  
		<tr>
		      <td>name: </td> <td><input type="text" name="username" ng-model="userCtrl.user.username" required/> 
         	      <span ng-show="userForm.username.$error.required" class="msg-val">Name is required.</span> </td>
		</tr>
		<tr>
		      <td>mail: </td> <td><input type="text" name="email" ng-model="userCtrl.user.email" required/> 
         	      <span ng-show="userForm.email.$error.required" class="msg-val">Email is required.</span> </td>
		</tr>
		<tr>
		      <td>password: </td> <td><input type="text" name="password" ng-model="userCtrl.user.password" required/> 
         	      <span ng-show="userForm.password.$error.required" class="msg-val">Password is required.</span> </td>
		</tr>
		

		<tr>
		      <td>address: </td> <td><input type="text" name="address" ng-model="userCtrl.user.address" required/> 
         	      <span ng-show="userForm.address.$error.required" class="msg-val">Address is required.</span> </td>
		</tr>
		<tr>
		      <td>role: </td> <td><input type="text" name="role" ng-model="userCtrl.user.role" required/> 
         	      <span ng-show="userForm.role.$error.required" class="msg-val">Role is required.</span> </td>
		</tr>
		
		<div class="form-group">
		<tr>
		     <td colspan="2"> <span ng-if="userCtrl.flag=='created'" class="msg-success">User successfully added.</span>
		     <span ng-if="userCtrl.flag=='failed'" class="msg-val">User already exists.</span> </td>
		</tr>
	        <tr><td colspan="2">
	        
	            <div ng-if="userCtrl.flag != 'edit'">
		       <input  type="submit" ng-click="userCtrl.addUser()" value="Add User"/> 
		       <input type="button" ng-click="userCtrl.reset()" value="Reset"/>
		    </div>
		    
		    <div ng-if="userCtrl.flag == 'edit'">
		       <input  type="submit" ng-click="userCtrl.updateUserDetail()" value="update User"/> 	
			   <input type="button" ng-click="userCtrl.cancelUpdate()" value="Cancel"/>				   
		    </div> </td>
		</tr>
		<tr>
		     <td colspan="2"> <span ng-if="userCtrl.flag=='deleted'" class="msg-success">User successfully deleted.</span>
		</tr>
	    </table>     
	</form>
        <table>
	      <tr><th>User Id</th> 
	          <th>UserName</th>
	          <th>EMail</th>  
	          <th>Password</th> 
	          <th>Address</th>
	          <th>Role</th>  
	      </tr>
	        <tr ng-repeat="row in userCtrl.users">
	         <td><span ng-bind="row.id"></span></td>
	         <td><span ng-bind="row.username"></span></td>
	         <td><span ng-bind="row.email"></span></td>
	         <td><span ng-bind="row.password"></span></td>
	         <td><span ng-bind="row.address"></span></td>
	         <td><span ng-bind="row.role"></span></td>
	         
	         <td>
		    <input type="button" ng-click="userCtrl.Userdelete(row.id)" value="Delete"/>
		    <input type="button" ng-click="userCtrl.editUser(row.id)" value="Edit"/>
		    <span ng-if="userCtrl.flag=='updated' && row.id==userCtrl.id" class="msg-success">User successfully updated.</span> </td> 
	      </tr>	
	</table> 
	</div>  
<script src="resources/js/angular.min.js"></script>
<script src="resources/js/angular-resource.min.js"></script>
 <script src="resources/js/user.js"></script>   
 </body>
 
</html>  