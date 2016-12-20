<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container panel">
<div ng-controller="UserController as ctrl">
<h1 style="color:#22d686;">Profile</h1>
<h3>
Name: {{selectedUser.username}}</br></br>
Email: {{selectedUser.email}}</br></br>
Addres: {{selectedUser.address}}</br></br>
Role: {{selectedUser.role}}</br></br>
</h3>
</div>
</div>
</body>
</html>