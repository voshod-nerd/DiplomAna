'use strict';

App.controller('ControllerOrder', ['$scope', 'OrderService',
    function ($scope, OrderService) {
        var self = this;
 
        self.vis='';
        
        self.unit = {
            id: null,
            datez: '',
            datezav: '',
            status: '',
            idnomer: null,
            idsotr: null,
            typez:null
        };
        
            self.report = function () {                   
            window.open('report/3/2');
            self.fetchAllU();
        };
        
       
        
        $scope.sortType = 'location'; // set the default sort type
        $scope.sortReverse = false;  // set the default sort order
        $scope.searchFish = '';     // set the default search/filter term
        
        self.units = [];
        self.hotels=[];
        self.hotel=null;
        self.nomers=[];
        
        
        
        self.fetchNumbers = function () {  
       
        OrderService.fetchAllNumber()
                    .then(
                            function (d) { 
                                console.info(JSON.stringify(d));
                                self.nomers = d;   
                            },
                            function (errResponse) {
                                console.error('Error while fetching U(controller)');
                            }
                    );
        };
        
        
        
        self.fetchOrdersByHotel = function () {  
       
        OrderService.fetchAllHotel()
                    .then(
                            function (d) { 
                                console.info(JSON.stringify(d));
                                self.hotels = d;   
                            },
                            function (errResponse) {
                                console.error('Error while fetching U(controller)');
                            }
                    );
        };
        
        
        
        self.fetchAllU = function () {
            OrderService.fetchAllU()
                    .then(
                            function (d) {
                                self.units = d;
                                console.info(JSON.stringify(d));
                            },
                            function (errResponse) {
                                console.error('Error while fetching U(controller)');
                            }
                    );
        };

        self.fetchAllU();
        self.fetchOrdersByHotel(); 
        self.fetchNumbers();
       

        self.createU = function (unit) {
           OrderService.createU(unit)
                    .then(
                            self.fetchAllU,
                            function (errResponse) {
                                console.error('Error while creating U(controller)');
                            }
                    );
        };

        self.updateU = function (unit) {
            OrderService.updateU(unit)
                    .then(
                            self.fetchAllU,
                            function (errResponse) {
                                console.error('Error while updating U(controller)');
                            }
                    );
        };

        self.deleteU = function (unit) {
            OrderService.deleteU(unit)
                    .then(
                            self.fetchAllU,
                            function (errResponse) {
                                console.error('Error while deleting U(controller)');
                            }
                    );
        };


        

        self.edit = function (unit) {
             console.log('Unit name to be edited', unit);
             var nomer = (unit.idnomer !== null) ?
             JSON.stringify(unit.idnomer) : null;
             
             var sotr = (unit.idsotr !== null) ?
             JSON.stringify(unit.idsotr) : null;
             
             var typez = (unit.typez !== null) ?
             JSON.stringify(unit.typez) : null;
             
            self.unit = unit;
            self.unit.idnomer = nomer;
            self.unit.idsotr = sotr;
            self.unit.typez = typez;
            self.unit.datez= new Date(unit.datez);
            self.unit.datezav=new Date(unit.datezav);
            
            $scope.myForm.$setDirty();
        };


        self.reset = function () {
            self.unit = {
            id: null,
            datez: '',
            datezav: '',
            status: '',
            idnomer: null,
            idsotr: null,
            typez:null
        };
            $scope.myForm.$setPristine(); //reset Form
        };

        self.submit = function () {
            // console.log('department - ' + self.employee.department);
             var nomer = self.unit.idnomer !== null ?
             JSON.parse(self.unit.idnomer) : null;
             var sotr = self.unit.idsotr !== null ?
             JSON.parse(self.unit.idsotr) : null;
             var tz = self.unit.typez !== null ?
             JSON.parse(self.unit.typez) : null;
           
            self.unit.idnomer = nomer;
            self.unit.idsotr =sotr;
            self.unit.typez =tz;
            if (self.unit.id === null) {
                console.log('Saving New Unit', self.unit);
                self.createU(self.unit);
            } else {
                self.updateU(self.unit);
                console.log('Unit updated to  ', self.unit);
            }
            self.reset();
        };
        
        
       

    }]);