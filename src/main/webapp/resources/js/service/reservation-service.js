'use strict';
App.factory('ControllerReserv', ['$http', '$q', function($http, $q){
	return {
		
			fetchDepartment: function() {
					return $http.get('http://localhost:8085/course-project/getdepartment/')
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while fetching users');
										return $q.reject(errResponse);
									}
							);
			},
	
	
	checkFreePlace: function(id){
		
		return $http.put('http://localhost:8085/course-project/isfree/',id)
				.then(
						function(response){
							return response.data;
						}, 
						function(errResponse){
							console.error('Error');
							return $q.reject(errResponse);
						}
				);
}
		    
		    
		    
		    
		
	};

}]);