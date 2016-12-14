'use strict';
/*var app = angular.module('myApp', ['ngResource']);*/
app.factory('User', ['$resource', function ($resource) {
    return $resource('http://localhost:8070/com.niit.collaborate/user:id', {id: '@id'},
	{
		updateUser: {method: 'PUT'}
	}
    );
}]);
app.controller('UserController', ['$http','$scope','$cookieStore','User','UserService','$location','$rootScope',function($http,$scope,$cookieStore,User, UserService,$location, $rootScope)  {
    var self = this;
    self.user= new User();
     
    self.users=[];
         
    self.fetchAllUsers = function(){
      /*  self.users = User.query();*/
    };
      
    
 self.getSelectedUser = myProfile
    
    function myProfile(){
        console.log("MyProfile...")
    	UserService.myProfile()
    	.then(
    			function(d){
   				self.user = d;
   				$location.
   				path("/myProfile");
   			},function(errResponse){
   				console.error('Error while fetch profile');
    	});
    };
    self.createUser = function(){
        self.user.$save(function(){
            self.fetchAllUsers();
            self.flag='created';
            self.reset();
            self.fetchAllUsers();
        });
    };
     
    self.updateUser = function(){
    	console.log('Inside update');
    	if($scope.userForm.$valid) {
        	   self.user.$updateUser(function(user){
        		console.log(user); 
    		self.updatedId = user.id;
    		self.reset();
    		self.flag = 'updated'; 
        		self.fetchAllUsers();
               });
    	}
        };

   self.deleteUser = function(identity){
       var user = User.get({id:identity}, function() {
            user.$delete(function(){
                console.log('Deleting user with id ', identity);
                self.fetchAllUsers();
            });
       });
    };

    self.fetchAllUsers();

    self.submit = function() {
        if(self.user.id==null){
            console.log('Saving New User', self.user);    
            self.createUser();
        }else{
            console.log('Updating user with id ', self.user.id);
            self.updateUser();
            console.log('User updated with id ', self.user.id);
        }
        self.reset();
    };
         
    self.edit = function(id){
    	 console.log('Inside edit');
         self.user = User.get({ id: id}, function() {
	       self.flag = 'edit'; 
	    });
         
    };
         
    self.remove = function(id){
        console.log('id to be deleted', id);
        if(self.user.id === id) {//If it is the one shown on screen, reset screen
           self.reset();
        }
        self.deleteUser(id);
    };

     
    self.reset = function(){
        self.user= new User();
        $scope.myForm.$setPristine(); //reset Form
    };
    
    self.login= function (){
    	{
    	console.log('Login Validation????????', self.user);
    	self.authenticate(self.user);
    	/*document.location.reload(true);*/
    }
    };
    self.logout = function(){
    	$rootScope.currentUser = {};
    	$cookieStore.remove('currentUser');
    	
    	console.log('calling the method logout of user service');
    	UserService.logout()
    	
    	$location.path('/');	
    };


    self.authenticate = function(user){
    	console.log("authenticate...")
    	UserService
    	.authenticate(user)
    	.then(
    			function(d){
    				self.user=d;
    				console.log("user.errorCode:"+self.user.errorCode)
    				if(self.user.errorCode== "404")
    					{
    					alert("Invalid Credentials.Please try again")
    					self.user.username="";
    					self.user.password="";
    					}
    				else{
    					console.log("Valid creditials.Navigating to index page")
    					$rootScope.currentUser={
    						username:self.user.username,
    						id:self.user.id,
    						role:self.user.role
    					};
    					$http.defaults.headers.common['Authorization']= 'Basic'+$rootScope.currentUser;
    					$cookieStore.put(
    								'currentUser',$rootScope.currentUser);
    					$location.path('/')
    					
    				
    				}
    			},
    			function(errResponse){
    				console.err('Error while authenticate Users');
    			});
    	 
    }
   

}]);