'use strict';

app.factory('JobApplication', ['$resource', function ($resource) {
    return $resource('http://localhost:8081/com.niit.collaborate/jobapplication/:jobApplicationId', {jobApplicationId: '@jobApplicationId'},
	{
		updateJobApplication: {method: 'PUT'}
	}
    );
}]);
app.controller('JobApplicationController', ['$scope', 'JobApplication','$location', function($scope, JobApplication, $location) {
    var ob = this;
    ob.jobapplications=[];
    ob.jobapplication = new JobApplication(); 
    ob.fetchAllJobApplications = function(userId){
        ob.jobapplications = JobApplication.query({userId: userId});
    };
    ob.fetchAllJobApplications();
    ob.addJobApplication = function(){
	console.log('Inside save');
	if($scope.jobApplicationForm.$valid) {
	  ob.jobapplication.$save(function(jobapplication){
	     console.log(jobapplication); 
	     ob.flag= 'created';
	     alert("you applied successfully");
	     ob.reset();	
	     ob.fetchAllJobApplications();
	  },
	  function(err){
	     console.log(err.status);
	     ob.flag='failed';
	  }
          );
        }
    }; 
    ob.editJobApplication = function(jobApplicationId){
	    console.log('Inside edit');
            ob.jobapplication = JobApplication.get({ jobApplicationId: jobApplicationId}, function() {
	       ob.flag = 'edit'; 
	    });
    };
    ob.updateJobApplicationDetail = function(){
	console.log('Inside update');
	if($scope.jobApplicationForm.$valid) {
    	   ob.jobapplication.$updateJobApplication(function(jobapplication){
    		console.log(jobapplication); 
		ob.updatedId = jobapplication.jobApplicationId;
		ob.reset();
		ob.flag = 'updated'; 
    		ob.fetchAllJobApplications();
           });
	}
    };	
    ob.viewJobApplication = function(jobApplicationId){
    	console.log('Inside view');
    	ob.viewjobapplication = JobApplication.get({ jobApplicationId: jobApplicationId}, function(){
    		ob.flag = 'view';
    	});
    };
    ob.deleteJobApplication = function(jobApplicationId){
	    console.log('Inside delete');
	    ob.jobapplication = JobApplication.delete({ jobApplicationId: jobApplicationId}, function() {
		ob.reset();  
		ob.flag = 'deleted';
    		ob.fetchAllJobApplications(); 
	    });
    };		
    ob.reset = function(){
    	ob.jobapplication = new JobApplication();
        $scope.jobApplicationForm.$setPristine();
    };	
    ob.cancelUpdate = function(jobApplicationId){
	    ob.jobapplication = new JobApplication();
	    ob.flag= '';	
   	    ob.fetchAllJobApplications();
    }; 
    ob.close = function(){
    	location.reload();
    };
}]);     