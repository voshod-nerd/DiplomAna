'use strict';
app.controller('reservationController', ['$scope', 'reservationService', function($scope, reservationService)  {
  	
var self = this;

$scope.broned='none';
$scope.brongroup='none';
$scope.block1='none';
$scope.block2='none';
$scope.block3='none';
$scope.block4='none';
$scope.blockreser='none';
$scope.depart={id:null,DEPT_NAME:'',DEPT_NO:'',location:''};
$scope.departments=[];
$scope.message='Here i am';


self.count=0;
$scope.data = {
		 singleSelect: null,
		 selectVidBron:null,
		 dateIn:null,
		 dateOut:null,
		 singleValue: 4
 }
   
$scope.myFunc = function() {
	$scope.block1='none';$scope.block2='none';
	$scope.block3='none';$scope.block4='none';
   
	if ($scope.data.singleSelect==1)$scope.block1='inline-block';
	if ($scope.data.singleSelect==2) $scope.block2='inline-block';
	if ($scope.data.singleSelect==4) $scope.block3='inline-block';
	if ($scope.data.singleSelect==5) $scope.block4='inline-block';
	

};	

$scope.SelectBron = function() {
	$scope.broned='none';
	$scope.brongroup='none';
   
	if ($scope.data.selectVidBron==1)$scope.broned='inline-block';
	if ($scope.data.selectVidBron==2) $scope.brongroup='inline-block';
}
   
$scope.checkfreenomer = function(){
    
	var proj =
	{ mas: [
	 $scope.data.dateIn,
     $scope.data.dateOut,
     $scope.data.singleSelect
	]	
	}
	
	
	alert(JSON.stringify(proj));
	reservationService.checkFreePlace(JSON.stringify(proj))
    .then(
    		function(d) {
            alert(d);
            },
            function(errResponse){
	         console.error('Error while deleting User.');
            }	
);
};



	
	
$scope.checkReservation = function() { 
	$scope.blockreser='inline-block';
	$scope.fetchDepartment();
    }
    
    
$scope.fetchDepartment = function(){
	   
	reservationService.fetchDepartment()
            .then(
                         function(d) {
                        	 
                        	 $scope.departments = d;
                        	 
                         },
                          function(errResponse){
                        	
                              console.error('Error while fetching Currencies');
                          }
                 );
    };   
    
    
    
  
}]);