var app = angular.module('app',['ngRoute','ngResource','ngCookies']);

app.config(function($routeProvider){
	$routeProvider
	
    .when('/', {
         controller: 'HomeController',
         templateUrl: 'resources/home.jsp',
         
     })

    .when('/login', {
         controller: 'UserController',
         templateUrl: 'resources/login.jsp',
     })

     .when('/blog', {
        controller: 'BlogController',
         templateUrl: 'resources/blog.jsp',
         
     })
     
      .when('/user', {
         controller: 'UserController',
         templateUrl: 'resources/login.jsp',
         
     })
      .when('/event', {
        controller: 'EventController',
         templateUrl: 'resources/event.jsp',
        
     })
     
     .when('/Signup', {
        controller: 'UserController',
         templateUrl: 'resources/user.jsp',
        
     })
     
     .when('/user', {
        controller: 'UserController',
         templateUrl: 'resources/user.jsp',
        
     })
     
      .when('/chat', {
        controller: 'ChatController',
         templateUrl: 'resources/chat.jsp',
        
     })
     
      .when('/friend', {
        controller: 'FriendController',
         templateUrl: 'resources/viewfriend.jsp',
        
     })
       .when('/friendrequest', {
                controller: 'FriendController',
                templateUrl: 'resources/friend.jsp'
            })
  
     
     .otherwise({ redirectTo: '/' });
	
	
	app.run(function ($rootScope, $location, $cookieStore, $http){
		
		$rootScope.$on('$locationChangeStart', function(event, next, current){
			console.log("$locationChangeStart")
			// Redirect to login page if not logged in and trying to access a restricted page page
			var restrictedPage= $.inArray($location.path(),['//','home','/blog','/','/login','/register'])===-1;
			console.log("restrictedPage:"+restrictedPage);
			var loggedIn=$rootScope.currentUser.id;
			console.log("loggedIn:"+loggedIn)
			if(restrictedPage & !loggedIn){
				console.log("Navigation to login page:")
				$location.path('/login');
				
			}
		});
		



	// KEEP USER LOGGED IN AFTER PAGE REFRESH

	$rootScope.currentUser=$cookieStore.get('CurrentUser') || {};
	if($rootScope.currentUser){
		
		$http.defaults.headers.common['Authorization']='Basic'+ $rootScope.currentUser;
	}												//'Basic ' + $rootScope.globals.currentUser.authdata;
	});

});


