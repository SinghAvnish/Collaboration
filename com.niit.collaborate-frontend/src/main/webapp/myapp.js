var app = angular.module('app',['ngRoute','ngResource','ngCookies']);

app.config(function($routeProvider){
	$routeProvider
	
    .when('/', {
         controller: 'HomeController',
         templateUrl: 'home.html',
         
     })
     
     .when('/myProfile', {
                controller: 'UserController',
                templateUrl: 'profile.html',
            })

    .when('/login', {
         controller: 'UserController',
         templateUrl: 'login.html',
     })
     
      /*.when('/userlist', {
         controller: 'UserController',
         templateUrl: 'userlist.html',
     })
*/
     .when('/blog', {
        controller: 'BlogController',
        controller: 'BlogCommentController',
        controller: 'BlogLikeController',
        
        templateUrl: 'blog.html',
         
     })
     
    
     .when('/viewblog', {
         controller: 'BlogController',
         templateUrl: 'viewblog.html',
        
     })
     
      .when('/user', {
         controller: 'UserController',
         templateUrl: 'login.html',
         
     })
      .when('/event', {
        controller: 'EventController',
         templateUrl: 'event.html',
        
     })
     
     .when('/register', {
        controller: 'UserController',
         templateUrl: 'user.html',
        
     })
     
     .when('/user', {
        controller: 'UserController',
         templateUrl: 'user.html',
        
     })
     
      .when('/chat', {
        controller: 'ChatController',
         templateUrl: 'chat.html',
        
     })		
     
       .when('/forum', {
        controller: 'ForumController',
         templateUrl: 'forum.html',
        
     })
     .when('/chatforum', {
		controller : 'ChatForumController',
		templateUrl : 'chatforum.html'
	})
	.when('/postjob', {
         controller: 'JobController',
         templateUrl: 'postjob.html',
        
     })
     .when('/searchjob', {
         controller: 'JobController',
         templateUrl: 'searchjob.html',
        
     })
     .when('/viewjob', {
         controller: 'JobController',
         templateUrl: 'viewjob.html',
        
     })
    .when('/viewjobdetails', {
         controller: 'JobController',
         templateUrl: 'viewjobdetails.html',
        
     })
     
      .when('/friend', {
        controller: 'FriendController',
         templateUrl: 'viewfriend.html',
        
     })
     
       .when('/friendrequest', {
                controller: 'FriendController',
                templateUrl: 'friend.html',
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



