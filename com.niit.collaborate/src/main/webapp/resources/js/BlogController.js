'use Strict';

app.factory('Blog', ['$resource', function ($resource) {
    return $resource('http://localhost:8070/com.niit.collaborate/blog:id', {id: '@id'},
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
    self.editBlog = function(id){
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
    		self.updatedId = blog.id;
    		self.reset();
    		self.flag = 'updated'; 
    		self.fetchAllBlogs();
           });
	}
    };	
    self.Blogdelete = function(id){
	    console.log('Inside delete');
	    self.blog =delete({ id: id}, function() {
	    	self.reset();  
	    	self.flag = 'deleted';
	    	self.fetchAllBlogs(); 
	    });
    };		
    self.reset = function(){
    	self.blog = new Blog();
        $scope.blogForm.$setPristine();
    };	
    self.cancelUpdate = function(id){
    	self.blog = new Blog();
	    self.flag= '';	
	    self.fetchAllBlogs();
    };   
}]);     
