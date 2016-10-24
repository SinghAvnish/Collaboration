 var app = angular.module('myApp', ['ngResource']);
app.factory('User', ['$resource', function ($resource) {
    return $resource('http://localhost:8090/com.niit.collaborate/user/:userId', {userId: '@userId'},
	{
		updateUser: {method: 'PUT'}
	}
    );
}]);
app.controller('UserController', ['$scope', 'User', function($scope, user) {
    var ob = this;
    ob.user=[];
    ob.user = new user(); 
    ob.fetchAlluser = function(){
        ob.user = User.query();
    };
    ob.fetchAllUser();
    ob.addUser = function(){
	console.log('Inside save');
	if($scope.userForm.$valid) {
	  ob.user.$save(function(user){
	     console.log(user); 
	     ob.flag= 'created';	
	     ob.reset();	
	     ob.fetchAlluser();
	  },
	  function(err){
	     console.log(err.status);
	     ob.flag='failed';
	  }
          );
        }
    }; 
    ob.editUser = function(userId){
	    console.log('Inside edit');
            ob.user = User.get({ userId: userId}, function() {
	       ob.flag = 'edit'; 
	    });
    };    
    ob.updatePersonDetail = function(){
	console.log('Inside update');
	if($scope.userForm.$valid) {
    	   ob.user.$updateUser(function(user){
    		console.log(user); 
		ob.updatedId = user.userId;
		ob.reset();
		ob.flag = 'updated'; 
    		ob.fetchAlluser();
           });
	}
    };	
    ob.deleteUser = function(userId){
	    console.log('Inside delete');
	    ob.user = userdelete({ UserId: userId}, function() {
		ob.reset();  
		ob.flag = 'deleted';
    		ob.fetchAlluser(); 
	    });
    };		
    ob.reset = function(){
    	ob.user = new User();
        $scope.userForm.$setPristine();
    };	
    ob.cancelUpdate = function(id){
	    ob.user = new User();
	    ob.flag= '';	
   	    ob.fetchAlluser();
    };    
}]);     
 