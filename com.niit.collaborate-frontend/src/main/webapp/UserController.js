'use strict';
app.factory('User', ['$resource', function ($resource) {
    return $resource('http://localhost:8070/com.niit.collaborate/user:id', {id: '@id'},
	{
		updateUser: {method: 'PUT'}
	}
    );
}]);
app.controller('UserController', ['$http','$scope','$cookieStore','User','UserService','$rootScope','$location',function($http,$scope,$cookieStore,User, UserService,$rootScope,$location){ 
    var ob = this;
    ob.users=[];
    ob.user = new User(); 
    ob.fetchAllUsers = function(){
        ob.users = User.query();
    };
    
    ob.getSelectedUser = myProfile
    function myProfile(){
        console.log("MyProfile...")
    	UserService.myProfile().then(function(d){
   				ob.user = d;
   				$location.path("/myProfile");
   			},function(errResponse){
   				console.error('Error while fetch profile');
    	});
    };
    
    ob.fetchAllUsers();
    ob.addUser = function(){
	console.log('Inside save');
	if($scope.userForm.$valid) {
	  ob.user.$save(function(user){
	     console.log(user); 
	     ob.flag = 'created';	
	     ob.reset();	
	     ob.fetchAllUsers();
	  },
	  function(err){
	     console.log(err.status);
	     ob.flag='failed';
	  }
          );
        }
    }; 
    ob.editUser = function(id){
	    console.log('Inside edit');
            ob.user = User.get({ id: id}, function() {
	       ob.flag = 'edit'; 
	    });
    };    
    ob.updateUserDetail = function(){
	console.log('Inside update');
	if($scope.userForm.$valid) {
    	   ob.user.$updateUser(function(user){
    		console.log(user); 
		ob.updatedId = user.id;
		ob.reset();
		ob.flag = 'updated'; 
    		ob.fetchAllUsers();
           });
	}
    };	
    ob.Userdelete = function(id){
	    console.log('Inside delete');
	    ob.user = User.delete({ id: id}, function() {
		ob.reset();  
		ob.flag = 'deleted';
    		ob.fetchAllUsers(); 
	    });
    };		
    ob.reset = function(){
    	ob.user = new User();
        $scope.userForm.$setPristine();
    };	
    ob.cancelUpdate = function(id){
	    ob.user = new User();
	    ob.flag= '';	
   	    ob.fetchAllUsers();
    };  
    
    
   ob.authenticate=function(user)
   {
		console.log("authenticate...")
		UserService
		.authenticate(user)
		.then(	
		        		   
		        		 function(d){
		        			 
		        			 ob.user= d;
		        			 console
		        			        .log("user.errorCode: "
		        			 + ob.user.errorCode);
		        			      if(ob.user.errorCode=="404")
		        			      {
		        			    	 alert("Invalid Credentials.  Please try again."); 
		        			    	 
		        			    	 ob.user.id="";
		        			    	 ob.user.password="";
		        			    	   
		        			     }
		        			      else
		        			      {
		        			    	 console
		                                     .log("Valid credentials. Navigating to home page");
		                            
		        			    	 $rootScope.currentUser = {
		                                    		 
		                             	username : ob.user.username,
		                                id : ob.user.id,
		                                role : ob.user.role
		                                    		 
		                                };
		        			    	    $http.defaults.headers.common['Authorization'] = 'Basic' 
		        			    	    		+$rootScope.currentUser;
		        			    	    $cookieStore
		        			    	          .put(
		        			    	        		  'currentUser',
		        			    	        		  $rootScope.currentUser);
		        			    	    $location.path('/') 
		        			     }
		        		 },
		        		function (errResponse){
		        			 console.err('Error while authenticate Blogs ');
		        			 })
		        		 };
		        		 
		        		 
		 ob.login = function() {
			 {
				console.log('login validation?????',
						ob.user);
				ob.authenticate(ob.user);
			 }
		 }
		
		 /*ob.submit = funtion() 
		 {
				{
					console.log('Saving New User', ob.user);
					ob.createUser(ob.user);	 
				}
				ob.reset();
		    }
		*/	        
		 ob.logout = function() 
		 	{
				$rootScope.currentUser = {};
				$cookieStore.remove('currentUser');
				 
				console.log('calling the method logout of User Service')
				UserService.logout()
				$location.path('/');
				 
			};      		 
}]);  
