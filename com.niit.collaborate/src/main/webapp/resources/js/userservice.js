'use strict';
app.factory('UserService', ['$http', '$q','$rootScope', function($http, $q, $rootScope)
   {
	    console.log("UserService")
	var BASE_URL = 'http://localhost:8010/com.niit.collaborate/';
		
		return {
			authenticate: function(user){
        	console.log("Calling the method authenticate with the user :"+user)
        	
        	return $http.post(BASE_URL+'/user/authenticate',user)
        			.then(
        					function(response){
        						return response.data;
        					},
        					null
        			);
        
        }
		
		};
}])