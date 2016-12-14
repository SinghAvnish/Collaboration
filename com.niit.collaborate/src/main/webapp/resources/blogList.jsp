<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
<%@page isELIgnored="false"%><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BlogList</title>
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
</head>
<body>
<div ng-controller="BlogController as blogCtrl" class="container">
    <table class="table table-bordered">
        <thead>
            <tr>
            	<th>Id</th>
                <th>Title</th>
                <th>Description</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <tr ng-repeat="row in blogCtrl.blogs">
            	<td><span ng-bind="row.id"></span></td>
	        	<td><span ng-bind="row.title"></span></td>
	         	<td><span ng-bind="row.description"></span></td>
                <td><a href="<c:url value='/blogview{{row.id}}' />">view</a></td>
            </tr>
        </tbody>
    </table>
</div>
</body>
</html>