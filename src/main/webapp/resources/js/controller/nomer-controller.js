'use strict';
App.controller('ControllerNomer', ['$scope', 'ServiceNomer',
    function ($scope, ServiceNomer) {
        var self = this;

        self.block="none";
        
        self.select = 0;
        self.block1 = 'none';
        self.block2 = 'none';
        self.block3 = 'none';
        self.block4 = 'none';
       
      
        self.unit = {
            id: null,
            number: '',
            ready: '',
            idgostin: null,
            typenomer: null
        };
        self.data = {
            dateb: null,
            datee: null,
            typenomerhotel: '',
            idhotel: ''
        };
        
        self.units = [];
        
       
        
        
         self.myFunc = function () {
            self.block1 = 'none';
            self.block2 = 'none';
            self.block3 = 'none';
            self.block4 = 'none';
           
           
            if (self.data.typenomerhotel === '1') {
                 
                self.block1 = 'inline-block';
            }
            if (self.data.typenomerhotel === '2') {
                self.block2 = 'inline-block';
            }
            if  (self.data.typenomerhotel === '3') {
                self.block3 = 'inline-block';
            }
            if (self.data.typenomerhotel === '4') {
                self.block4 = 'inline-block';
            }
        };
         
         
        self.datas=[]; 
        
        
            self.route = function(id) {
                
                var db=new Date(self.data.dateb);
                var de=new Date(self.data.datee);
                
                
                //var str = 'pay';
                var str = 'pay?id='+id+'&dateb='+db.toUTCString()+'&datee='+de.toUTCString();
                
                window.location.href = str;
                
               // location.href(str);   
            };

            self.nomers=[];
           
            self.fetchFreeU = function () {  
                
            self.block="inline-block";    
            self.data.dateb = new Date( self.data.dateb);
            self.data.datee = new Date( self.data.datee);
            self.data.typenomerhotel= self.data.typenomerhotel;
            self.data.idhotel=self.data.idhotel;
            ServiceNomer.fetchFreeU(self.data)
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
        
        
        
        self.fetchAllU = function () {
            ServiceNomer.fetchAllU()
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

        self.createU = function (unit) {
            ServiceNomer.createU(unit)
                    .then(
                            self.fetchAllU,
                            function (errResponse) {
                                console.error('Error while creating U(controller)');
                            }
                    );
        };

        self.updateU = function (unit) {
            ServiceNomer.updateU(unit)
                    .then(
                            self.fetchAllU,
                            function (errResponse) {
                                console.error('Error while updating U(controller)');
                            }
                    );
        };

        self.deleteU = function (unit) {
            ServiceNomer.deleteU(unit)
                    .then(
                            self.fetchAllU,
                            function (errResponse) {
                                console.error('Error while deleting U(controller)');
                            }
                    );
        };

        self.edit = function (unit) {
            console.log('Unit name to be edited', unit);
            var tar = (unit.idgostin !== null) ?
                    JSON.stringify(unit.idgostin) : null;
            var pit = (unit.typenomer !== null) ?
                    JSON.stringify(unit.typenomer) : null;


            self.unit = unit;
            self.unit.idgostin = tar;
            self.unit.typenomer = pit;
            $scope.myForm.$setDirty();
        };


        self.reset = function () {
            self.unit = {
                id: null,
            number: '',
            ready: '',
            idgostin: null,
            typenomer: null
            };
            $scope.myForm.$setPristine(); //reset Form
        };

        self.submit = function () {

            var tar = self.unit.idgostin !== null ?
                    JSON.parse(self.unit.idgostin) : null;
            var pit = self.unit.typenomer !== null ?
                    JSON.parse(self.unit.typenomer) : null;
           
            self.unit.idgostin = tar;
            self.unit.typenomer = pit;
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