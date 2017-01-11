var app = angular.module('app',['ngRoute','ngResource','ngCookies']);

app.config(function($routeProvider){
	$routeProvider
	
    .when('/', {
         controller: 'HomeController',
         templateUrl: 'Home/home.html',
         
     })
     
       
     .when('/aboutus', {
                controller: 'UserController',
                templateUrl: 'Aboutus/aboutus.html',
            })
     
     .when('/myProfile', {
                controller: 'UserController',
                templateUrl: 'User/profile.html',
            })

    .when('/login', {
         controller: 'UserController',
         templateUrl: 'User/login.html',
     })
     
      .when('/userlist', {
         controller: 'UserController',
         templateUrl: 'User/userlist.html',
     })

     .when('/blog', {
        controller: 'BlogController',
        controller: 'BlogCommentController',
        controller: 'BlogLikeController',
        
        templateUrl: 'Blog/blog.html',
         
     })
     
    
     .when('/viewblog', {
         controller: 'BlogController',
         templateUrl: 'Blog/viewblog.html',
        
     })
     
      .when('/user', {
         controller: 'UserController',
         templateUrl: 'User/login.html',
         
     })
      .when('/event', {
        controller: 'EventController',
         templateUrl: 'Event/event.html',
        
     })
     
     .when('/register', {
        controller: 'UserController',
         templateUrl: 'User/user.html',
        
     })
     
     .when('/user', {
        controller: 'UserController',
         templateUrl: 'User/user.html',
        
     })
     
      .when('/chat', {
        controller: 'ChatController',
         templateUrl: 'Chat/chat.html',
        
     })		
     
      .when('/chatforum', 
    		  {
                controller: 'ChatForumController',
                templateUrl: 'ChatForum/chatforum.html',
            })
     
     
     
     
       .when('/forum',
    	{
        controller: 'ForumController',
        controller: 'ForumCommentController',
        controller: 'ForumLikeController',
        templateUrl: 'Forum/forum.html',
        
    	})
     
    
	/*.when('/postjob', {
         controller: 'JobController',
         templateUrl: 'Job/postjob.html',
        
     })
     .when('/searchjob', {
         controller: 'JobController',
         templateUrl: 'Job/searchjob.html',
        
     })
     .when('/viewjob', {
         controller: 'JobController',
         templateUrl: 'Job/viewjob.html',
        
     })
    .when('/viewjobdetails', {
         controller: 'JobController',
         templateUrl: 'Job/viewjobdetails.html',
        
     })
     */
    	 .when('/joblist', {
		        controller: 'JobController',
		        controller: 'JobApplicationController',
		        templateUrl: 'Job/joblist.html',
		        
		    })
		    .when('/viewappliedjob', {
		         controller: 'JobApplicationController',
		         templateUrl: 'Job/viewappliedjob.html',
		        
		     })
		    
      .when('/friend', {
        controller: 'FriendController',
         templateUrl: 'Friend/view_friends.html',
        
     })
     
       .when('/friendrequest', {
                controller: 'FriendController',
                templateUrl: 'Friend/friend.html',
            })
  
     
     .otherwise({ redirectTo: '/' });
	
});

app.run( function ($rootScope, $location,$cookieStore, $http)
		{ 
		
			$rootScope.$on('$locationChangeStart', function (event, next, current) {
	        // redirect to login page if not logged in and trying to access a restricted page
	        var restrictedPage = $.inArray($location.path(), ['/login','/user',]) === -1;
	        console.log("restrictedPage:" +restrictedPage)
	        var loggedIn = $rootScope.currentUser.id;
	        console.log("loggedIn:" +loggedIn)
	        if(!loggedIn)
	        	{
	        		if (restrictedPage) {
	        			console.log("Navigating to login page")
	        			$location.path('/login');
	        		}
	        	}
			
    
        else
        	
        	{
        		var role= $rootScope.currentUser.role;
        		var userRestrictedPage=  $.inArray($location.path(), ['/user']) == 0;
        		
        		if(userRestrictedPage && role!='admin')
        			{
        				alert("You can not do this operation as you are logged as :" + role);
        				$location.path('/');
        			}
        	}
        
    });
	
// KEEP USER LOGGED IN AFTER PAGE REFRESH
		
    $rootScope.currentUser=$cookieStore.get('CurrentUser') || {};
	if($rootScope.currentUser){
		
		$http.defaults.headers.common['Authorization']='Basic'+ $rootScope.currentUser;
	}												
});



