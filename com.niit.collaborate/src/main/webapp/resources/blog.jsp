<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en-US">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
  </head>
  <body >
   <div ng-controller="BlogController as blogCtrl">
       <div class="container">
	<form name="blogForm" method="POST">
	    <table  class="table table-hover">
		<tr><td colspan="2">
		  <div ng-if="blogCtrl.flag != 'edit'">
		     <h2> Add New Blog </h2> 
		  </div>
		  <div ng-if="blogCtrl.flag == 'edit'">
		     <h3> Update Blog for ID: {{ blogCtrl.blog.id }} </h3> 
		  </div> </td>
		</tr>
		
		<div class="form-group">
		<!-- <tr>
		      <td>id: </td> <td><input type="text" name="id" ng-model="blogCtrl.blog.id" required/> 
         	      <span ng-show="blogForm.id.$error.required" class="msg-val">id is required.</span> </td>
		</tr> -->
		<tr>
		      <td><label><h3>Title: </h3></label></td> <td><input type="text" name="title" id="title"class="form-control" ng-model="blogCtrl.blog.title" required/> 
         	      <span ng-show="blogForm.title.$error.required" class="msg-val">title is required.</span> </td>
		</tr>
		<tr>
		      <td><label><h3>Description: </h3></label></td> <td><input type="text" name="description" id="description" class="form-control" ng-model="blogCtrl.blog.description" required/> 
         	      <span ng-show="blogForm.description.$error.required" class="msg-val">description is required.</span> </td>
		</tr>
		
		
		<div class="form-group">
		<tr>
		     <td colspan="2"> <span ng-if="blogCtrl.flag=='created'" class="msg-success">Blog successfully added.</span>
		     <span ng-if="blogCtrl.flag=='failed'" class="msg-val">Blog already exists.</span> </td>
		</tr>
	        <tr><td colspan="12">
	            <div ng-if="blogCtrl.flag != 'edit'">
		        <button type="submit" ng-click="blogCtrl.addBlog()" value="Add Blog"> Add Blog</button> 
		       <input type="button" ng-click="blogCtrl.reset()" value="Reset"/>
		    </div>
		    <div ng-if="blogCtrl.flag == 'edit'">
		       <input  type="submit" ng-click="blogCtrl.updateBlogDetail()" value="Update Blog"/> 	
			   <input type="button" ng-click="blogCtrl.cancelUpdate()" value="Cancel"/>				   
		    </div> </td>
		</tr>
		<tr>
		     <td colspan="2"> <span ng-if="blogCtrl.flag=='deleted'" class="msg-success">Blog successfully deleted.</span>
		</tr>
	    </table>     
	</form>
        <table  class="table table-bordered">
	      <tr><th>Blog Id</th> 
	          <th>Title</th> 
	          <th>Description</th> 
	          <th>Action</th>
	      </tr>
	      <tr ng-repeat="row in blogCtrl.blogs">
	          <td><span ng-bind="row.id"></span></td>
	         <td><span ng-bind="row.title"></span></td>
	         <td><span ng-bind="row.description"></span></td>
	         
	         <td>
		    <input type="button" ng-click="blogCtrl.Blogdelete(row.id)" value="Delete"/>
		    <input type="button" ng-click="blogCtrl.editBlog(row.id)" value="Edit"/>
		    <span ng-if="blogCtrl.flag=='updated' && row.id==blogCtrl.updatedId" class="msg-success">Blog successfully updated.</span> </td> 
	      </tr>	
	</table>
	</div>     
 </body>
 
</html>  