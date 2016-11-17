<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>

<html lang="en-US">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 
  </head>
  <body >
   <div ng-controller="EventController as eventCtrl">
       <div class="container">
	<form name="eventForm" method="POST">
	    <table>
		<tr><td colspan="2">
		  <div ng-if="eventCtrl.flag != 'edit'">
		     <h3> Add New event </h3> 
		  </div>
		  <div ng-if="eventCtrl.flag == 'edit'">
		     <h3> Update event for ID: {{ eventCtrl.event.id }} </h3> 
		  </div> </td>
		</tr>
		
		<div class="form-group">
		<!-- <tr>
		      <td>id: </td> <td><input type="text" name="id" ng-model="eventCtrl.event.id" required/> 
         	      <span ng-show="eventForm.id.$error.required" class="msg-val">id is required.</span> </td>
		</tr> -->
		<tr>
		      <td>name: </td> <td><input type="text" name="name" ng-model="eventCtrl.event.name" required/> 
         	      <span ng-show="eventForm.name.$error.required" class="msg-val">name is required.</span> </td>
		</tr>
		
		<tr>
		      <td>venue: </td> <td><input type="text" name="venue" ng-model="eventCtrl.event.venue" required/> 
         	      <span ng-show="eventForm.venue.$error.required" class="msg-val">venue is required.</span> </td>
		</tr>
		<tr>
		      <td>description: </td> <td><input type="text" name="description" ng-model="eventCtrl.event.description" required/> 
         	      <span ng-show="eventForm.description.$error.required" class="msg-val">description is required.</span> </td>
		</tr>
		<tr>
		      <td>dateTime: </td> <td><input type="text" name="dateTime" ng-model="eventCtrl.event.dateTime" required/> 
         	      <span ng-show="eventForm.dateTime.$error.required" class="msg-val">dateTime is required.</span> </td>
		</tr>
		
		<div class="form-group">
		<tr>
		     <td colspan="2"> <span ng-if="eventCtrl.flag=='created'" class="msg-success">event successfully added.</span>
		     <span ng-if="eventCtrl.flag=='failed'" class="msg-val">event already exists.</span> </td>
		</tr>
	        <tr><td colspan="2">
	            <div ng-if="eventCtrl.flag != 'edit'">
		       <input  type="submit" ng-click="eventCtrl.addEvents()" value="Add Event"/> 
		       <input type="button" ng-click="eventCtrl.reset()" value="Reset"/>
		    </div>
		    <div ng-if="eventCtrl.flag == 'edit'">
		       <input  type="submit" ng-click="eventCtrl.updateEventDetail()" value="Update Event"/> 	
			   <input type="button" ng-click="eventCtrl.cancelUpdate()" value="Cancel"/>				   
		    </div> </td>
		</tr>
		<tr>
		     <td colspan="2"> <span ng-if="eventCtrl.flag=='deleted'" class="msg-success">Event successfully deleted.</span>
		</tr>
	    </table>     
	</form>
        <table>
	      <tr><th>EventId</th> 
	          <th>Name</th>
	          <th>Venue</th>
	          <th>Description</th> 
	          <th>dateTime</th>
	          
	      </tr>
	      <tr ng-repeat="row in eventCtrl.events">
	         <td><span ng-bind="row.id"></span></td>
	         <td><span ng-bind="row.name"></span></td>
	         <td><span ng-bind="row.venue"></span></td>
	         <td><span ng-bind="row.description"></span></td>
	         <td><span ng-bind="row.dateTime"></span></td>
	         
	         
	         <td>
		    <input type="button" ng-click="eventCtrl.Eventdelete(row.id)" value="Delete"/>
		    <input type="button" ng-click="eventCtrl.editEvent(row.id)" value="Edit"/>
		    <span ng-if="eventCtrl.flag=='updated' && row.id==eventCtrl.updatedId" class="msg-success">event successfully updated.</span> </td> 
	      </tr>	
	</table>
	</div>     
<script src="resources/js/angular.min.js"></script>
<script src="resources/js/angular-resource.min.js"></script>
<script src="resources/js/event.js"></script> 
 </body>
 
</html> 