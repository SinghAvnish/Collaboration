'use strict';
app.factory('Forum', ['$resource', function ($resource) {
    return $resource('http://localhost:8081/com.niit.collaborate/forum:forumid', {forumid: '@forumid'},
	{
		updateBlog: {method: 'PUT'}
	}
    );
}]);
app.controller('ForumController', ['$scope', 'Forum', function($scope, Forum) {
    var self = this;
    self.forums=[];
    self.forum = new Forum(); 
    self.fetchAllForums = function(){
    	self.blogs = Blog.query();
    };
    self.fetchAllForums();
    self.addForum = function(){
	console.log('Inside save');
	if($scope.forumForm.$valid) {
		self.forum.$save(function(forum){
	     console.log(forum); 
	     self.flag= 'created';	
	     self.reset();	
	     self.fetchAllForums();
	  },
	  function(err){
	     console.log(err.status);
	     self.flag='failed';
	  }
          );
        }
    }; 
    self.editForum = function(forumid){
	    console.log('Inside edit');
	    self.forum = Forum.get({ forumid: forumid}, function() {
	    	self.flag = 'edit'; 
	    });
    };    
    self.updateForumDetail = function(){
	console.log('Inside update');
	if($scope.forumForm.$valid) {
		self.blog.$updateForum(function(forum){
    		console.log(forum); 
    		self.updatedId = forum.forumid;
    		self.reset();
    		self.flag = 'updated'; 
    		self.fetchAllForums();
           });
	}
    };	
    self.Forumdelete = function(forumid){
	    console.log('Inside delete');
	    self.forum Forum.delete({ forumid: forumid}, function() {
	    	self.reset();  
	    	self.flag = 'deleted';
	    	self.fetchAllForums(); 
	    });
    };		
    self.reset = function(){
    	self.forum = new Forum();
        $scope.forumForm.$setPristine();
    };	
    self.cancelUpdate = function(forumid){
    	self.forum = new Forum();
	    self.flag= '';	
	    self.fetchAllForums();
    };   
}]);     
