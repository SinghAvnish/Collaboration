

app.factory('BlogLike', ['$resource', function ($resource) {
    return $resource('http://localhost:8081/com.niit.collaborate/bloglike/:blogLikeId', {blogLikeId: '@blogLikeId'},
	{
		updateBlogLike: {method: 'PUT'}
	}
    );
}]);

app.controller('BlogLikeController', ['$scope', 'BlogLike', function($scope, BlogLike) {
    
	var ob = this;
    ob.blogLikes=[];
    ob.blogLike = new BlogLike(); 
    ob.fetchAllBlogLikes = function(){
        ob.blogLikes = BlogLike.query();
    };
    
    ob.fetchAllBlogLikes();
    ob.createBlogLike = function(){
        ob.blogLike.$save(function(blogLikes){
        	ob.flag= 'created';	
   	        ob.reset();	
            ob.fetchAllBlogLikes();
        });
    };
    
    ob.edit = function(blogLikeId){
      	 console.log('Inside edit');
           ob.blogLike = BlogLike.get({ blogLikeId: blogLikeId}, function() {
   	       ob.flag = 'edit'; 
   	    });
           
      };    
       ob.updateBlogLikeDetail = function(){
   	console.log('Inside update');
   	if($scope.blogLikeForm.$valid) {
       	   ob.blogLike.$updateBlogLike(function(blogLike){
       		console.log(blogLike); 
   		ob.updatedId = blogLike.blogLikeId;
   		ob.reset();
   		ob.flag = 'updated'; 
       		ob.fetchAllBlogLikes();
              });
   	}
       };	
       ob.deleteBlogLike = function(identity){
           var blogLike = BlogLike.get({blogLikeId:identity}, function() {
                blogLike.$delete(function(){
                    console.log('Deleting blogComment with blogLikeId ', identity);
                    ob.fetchAllBlogLikes();
                });
           });
        };		
       ob.reset = function(){
       	ob.blogLike = new BlogLike();
           $scope.blogLikeForm.$setPristine();
       };	
       ob.cancelUpdate = function(blogLikeId){
   	    ob.blogLike = new BlogLike();
   	    ob.flag= '';	
      	    ob.fetchAllBlogLikes();
       };    
    
}]);     