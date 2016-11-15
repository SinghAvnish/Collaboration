'use strict';

app.factory('Event', ['$resource', function ($resource) {
    return $resource('http://localhost:8020/com.niit.collaborate/event:id', {id: '@id'},
	{
		updateEvent: {method: 'PUT'}
	}
    );
}]);
app.controller('EventController', ['$scope', 'Event', function($scope, Event) {
    var self = this;
    self.events=[];
    self.event = new Event(); 
    self.fetchAllEvents = function(){
    	self.events = Event.query();
    };
    self.fetchAllEvents();
    self.addEvents = function(){
	console.log('Inside save');
	if($scope.eventForm.$valid) {
		self.event.$save(function(event){
	     console.log(event); 
	     self.flag= 'created';	
	     self.reset();	
	     self.fetchAllEvents();
	  },
	  function(err){
	     console.log(err.status);
	     self.flag='failed';
	  }
          );
        }
    }; 
    self.editEvent = function(id){
	    console.log('Inside edit');
	    self.event = Event.get({ id: id}, function() {
	    	self.flag = 'edit'; 
	    });
    };    
    self.updateEventDetail = function(){
	console.log('Inside update');
	if($scope.eventForm.$valid) {
		self.event.$updateEvent(function(event){
    		console.log(event); 
    		self.updatedId = event.id;
    		self.reset();
    		self.flag = 'updated'; 
    		self.fetchAllEvents();
           });
	}
    };	
    self.Eventdelete = function(id){
	    console.log('Inside delete');
	    self.event =Event.delete({ id: id}, function() {
	    	self.reset();  
	    	self.flag = 'deleted';
	    	self.fetchAllEvents(); 
	    });
    };		
    self.reset = function(){
    	self.event = new Event();
        $scope.eventForm.$setPristine();
    };	
    self.cancelUpdate = function(id){
    	self.event = new Event();
	    self.flag= '';	
	    self.fetchAllEvents();
    };   
}]);     

