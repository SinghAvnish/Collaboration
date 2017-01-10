'use strict';

app.controller('JobController',['JobService','$scope','$location','$rootScope',
                                function(JobService,$scope,$location,$rootScope){
	console.log("JobController...")
	var self = this;
	self.job = {
			jobId : '',
			title :'',
			id :'',
			description :'',
			dateTime:'',
			qualification:'',
			status:'',
			errorCode:'',
			errorMessage:''			
	};
	self.jobs=[];
	
	self.jobapplied = {
			jobAppId : '',
			id : '',
			jobID :'',
			dateTime :'',
			remarks :'',
			status :'',
			errorCode:'',
			errorMessage:''			
	};
	self.jobsapplied=[];
	
	
	self.jobaccept = function(jobapplied){
		{
			self.accept(jobapplied,jobapplied.jobAppId);
		}
	};

	self.accept =function (jobapplied,jobAppId){
		console.log('accepting the jobapplied');
		JobService.accept(jobapplied,jobAppId).then(self.getAllJobsApplied,
		  function(errresponse){
			console.log('Error while accepting jobapplied')
		});
	};
	
	self.jobreject = function(jobapplied){
		{
			self.reject(jobapplied,jobapplied.jobAppId);
		}
	};

	self.reject =function (jobapplied,jobAppId){
		console.log('rejecting the jobapplied');
		JobService.reject(jobapplied,id).then(self.getAllJobsApplied,
		  function(errresponse){
			console.log('Error while rejecting jobapplied')
		});
	};
	
	
	self.applyForJob = applyForJob
		function applyForJob (jobID){
		var currentUser = $rootScope.currentUser
		if(typeof currentUser =='undefined')
		{
			alert("Please login to apply for the job")
			console.log("User not logged in, Cannot apply for job")
			$location.path('/login');
		}
		console.log("-->userID:"+currentUser.id+"applying for job:"+jobID)
		
		JobService.applyForJob(jobID)
		.then(
				function(d){
					self.job=d;
					alert("You have successfully applied for job,")
								},
								function(errResponse){
									console.error('Error while applying for job')
								});
	}
	
		self.getMyAppliedJobs=function(){
			console.log('calling the method getMyAppliedJobs');
			JobService.getMyAppliedJobs()
			   .then(function(d){
				self.jobs=d;
			}, function(errResponse){
				console.error('Error while fetching jobs');
			}
			);
		};
		
		
		
		  self.rejectJobApplication=function(id){
			  var jobID=$rootScope.selectedJob.id;
			  console.log('calling the method rejectJobApplication of the user'+id);
			  JobService.rejectJobApplication(id,selectedJobID)
			  .then(function(d){
				  self.job=d;
				  alert("You have successfully rejected the job")
			  },
			  function(errResponse){
				  console.error('Error while rejecting job application');
			  });		  
			  };
			  
		  self.canCallForInterview = function(id){
			  var jobID=$rootScope.selectedJob.id;
			  JobService.canCallForInterview(userID,jobID)
			  .then(
					  function(d){
						  self.job=d;
						  alert("Application status changed as call for job")
					  },
					  function(errResponse){
						  console.error('Error while changing status');
					  });
		  };
		  
	        self.selectUser = function(id){
	        	 var jobID=$rootScope.selectedJob.id;
	        	console.log('calling the method selecteduser with user ID:',id)
	       
	        	JobService.selectUser(id, selectedJobID)
	        	.then(
	        			function(d){
	        				self.job=d;
	        				alert("Application status set as selected")
	        			},
	        			function(errResponse){
	        				console.error('Error while changning the status');
	        			});     	
	        };
	        
	        self.getAllJobs=function(){
	        	console.log('calling the method getAllJobs');
	        	JobService.getAllJobs()
	        	.then(
	        			function(d){
	        				self.jobs=d;
	        			},
	        			function(errResponse){
	        				console.error('Error while fetching all opened jobs');
	        			});
	        };
	        
	        self.getAllJobsApplied=function(){
	        	console.log('calling the method getAllJobsApplied');
	        	JobService.getAllJobsApplied()
	        	.then(
	        			function(d){
	        				self.jobsapplied=d;
	        			},
	        			function(errResponse){
	        				console.error('Error while fetching all opened jobs');
	        			});
	        };
	        
          self.getAllJobs();
          
          self.getAllJobsApplied();
          
          self.submit=function(){
        	  {
        		  console.log('submit a new job',self.job);
        		  self.postAJob(self.job);
        	  }
        	  self.reset();
          };
          
          self.postAJob=function(job){
        	console.log('Submit a new job',self.job);
        	JobService.postAJob(job)
        	.then(function(d){
        		self.job=d;
        	},function(errResponse){
        		console.error('Error while posting job');
        	});
          };
          
          self.getJobDetails=getJobDetails
          function getJobDetails(jobID){
        	  console.log('get Job details of the id',jobID);
        	  JobService.getJobDetails(jobID)
        	  .then(
        			  function(d){
        				  self.job=d;
        				  $location.path('/viewjobdetails');
        			  },function(errResponse){
        				  console.error('Error while fetching job details');
        			  });
          };
     
          
          self.reset=function(){
           	  console.log('resetting the form');
           	  self.job={
           			jobId : '',
          			title :'',
          			description : '',
          			id : '',
          			qualification : '',
          			dateTime : '',
          			status : '',
          		  errorCode:'',
    			  errorMessage:''
           			  
           	  };
           	  $scope.myForm.$setPristine();//reset form
             };
}])