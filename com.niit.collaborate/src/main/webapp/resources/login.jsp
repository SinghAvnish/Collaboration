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
 
<div
    ng-controller="UserController as ctrl">
    
    <div ng-show='ctrl.user.errorMessage'>
      <!-- <div class="alert alert-danger fade in">
           {{ctrl.user.errorMessage}}</div>
    --> </div>
    
    <span ng-hide="ctlr.userLoggedIn">
        <form name="form" ng-submit="ctrl.Login()" role="form" method="post">
   
        <div class="form-group" 
             ng-class="{ 'has-error': form.username.$dirty && form.username.$error.required}" >
               
                <label for="username">Username</label> <input type="text" name="username" id="username" class="form-control"
                ng-model="ctrl.user.id" required/> <span 
                ng-show="form.username.$dirty && form.username.$error.required"
                class="help-block"> Username is required </span>
                 </div>  
                 <div class="form-group" 
             ng-class="{ 'has-error': form.password.$dirty && form.password.$error.required}" >
               
                <label for="password">password</label> <input type="password" name="password" id="password" class="form-control"
                ng-model="ctrl.user.password" required/> <span 
                ng-show="form.password.$dirty && form.password.$error.required"
                class="help-block"> password is required </span>
                 </div>
                 <div class="form-actions">
                    <button type="submit"
                    ng-disabled="form.$invalid // ctrl.dataloading"
                    class="btn btn-primary">Login</button>
                   <!--  <a href="#/register" class="btn btn-link">Register</a>
                 --> </div>
                 </form>
    </span>
    </div>