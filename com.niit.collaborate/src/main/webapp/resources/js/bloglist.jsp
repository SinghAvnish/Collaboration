<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <table>
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

</body>
</html>