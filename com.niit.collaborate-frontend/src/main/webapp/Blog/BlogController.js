'use strict';
app.factory('Blog', ['$resource', function ($resource) 
   {
    return $resource('http://localhost:8081/com.niit.collaborate/blog/:c_id', {c_id: '@c_id'},
	{
		updateBlog: {method: 'PUT'}
	}
    );
}]);

app.controller('BlogController', ['Blog', '$scope', function(Blog, $scope) {
    var self = this;
    self.blogs=[];
    self.blog = new Blog(); 
    self.fetchAllBlogs = function(){
    	self.blogs = Blog.query();
    };
    
    self.fetchAllBlogs();
    self.addBlog = function(){
	console.log('Inside save');
	if($scope.blogForm.$valid) {
		self.blog.$save(function(blog){
	     console.log(blog); 
	     self.flag= 'created';	
	     self.reset();	
	     self.fetchAllBlogs();
	  },
	  
	  function(err){
	     console.log(err.status);
	     self.flag='failed';
	  }
          );
        }
    }; 
    
    self.editBlog = function(c_id){
	    console.log('Inside edit');
	    self.blog = Blog.get({ id: id}, function() {
	    	self.flag = 'edit'; 
	    });
    };    
    
    self.updateBlogDetail = function(){
	console.log('Inside update');
	if($scope.blogForm.$valid) {
		self.blog.$updateBlog(function(blog){
    		console.log(blog); 
    		self.updatedId = blog.c_id;
    		self.reset();
    		self.flag = 'updated'; 
    		self.fetchAllBlogs();
           });
	}
    };	
    
    self.Blogdelete = function(c_id){
	    console.log('Inside delete');
	    self.blog =Blog.delete({ c_id: c_id}, function() {
	    	self.reset();  
	    	self.flag = 'deleted';
	    	self.fetchAllBlogs(); 
	    });
    };		
    
    self.viewBlog = function(c_id){
     	 console.log('Inside view');
          self.viewBlog = Blog.get({ c_id: c_id}, function() {
        	  console.log(self.viewBlog.title)
  	       self.flag = 'view'; 
  	    });
          
     };  
    self.reset = function(){
    	self.blog = new Blog();
        $scope.blogForm.$setPristine();
    };	
    self.cancelUpdate = function(c_id){
    	self.blog = new Blog();
	    self.flag= '';	
	    self.fetchAllBlogs();
    };   
}]);     
