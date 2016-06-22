'use strict';

App.controller('ControllerBron', ['$scope', 'ServiceBron',
    function ($scope, ServiceBron) {
        var self = this;

        self.unit = {
            id: null,
            dateb:null,
            datee:null,
            idclient:null,
            idnomer:null,
            idorg:null
        };

       self.searchFish='';
       self.block1="none";
       self.block2="none";
       self.idorg='';
       self.filterpogiv = '';

        self.units = [];
        
        self.customFilter = function (e) {
            console.info(e);
            if (self.filterpogiv === '')
                return true;
            if (isNaN(e.closed))
                return true;
            if (self.filterpogiv === true) {

                if (e.closed === 0)
                    return true;
                else
                    return false;
            }

            if (self.filterpogiv === false) {
                if ((e.closed === 0) || (e.closed === 1))
                    return true;
                else
                    false;
            }

        };
        
        
        
      self.change = function () {
      
       console.info(self.idorg);
      };
        
        
        self.getWithParam = function () {
            
            ServiceBron.getWithParam(self.idorg)
                    .then(
                            function (d) {
                                self.units = d;
                                
                               if  (self.units.length>0) self.block2="inline-block";
                               if  (self.units.length===0) self.block1="inline-block";
                                console.info(JSON.stringify(d));
                            },
                            function (errResponse) {
                                if  (self.units.length===0) self.block1="inline-block";
                                console.error('Error while fetching U(controller)');
                            }
                    );
        };
        
       

        self.fetchAllU = function () {
            ServiceBron.fetchAllU()
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
           ServiceBron.createU(unit)
                    .then(
                            self.fetchAllU,
                            function (errResponse) {
                                console.error('Error while creating U(controller)');
                            }
                    );
        };

        self.updateU = function (unit) {
            ServiceBron.updateU(unit)
                    .then(
                            self.fetchAllU,
                            function (errResponse) {
                                console.error('Error while updating U(controller)');
                            }
                    );
        };

        self.deleteU = function (unit) {
           ServiceBron.deleteU(unit)
                    .then(
                            self.fetchAllU,
                            function (errResponse) {
                                console.error('Error while deleting U(controller)');
                            }
                    );
        };
        
        
         self.denU = function (unit) {
           ServiceBron.deleteU(unit)
                    .then(
                            window.location.href='denaid',
                            function (errResponse) {
                                console.error('Error while deleting U(controller)');
                            }
                    );
        };
        
        
        
         self.vselitU = function (unit) {
             unit.closed=1;
           ServiceBron.updateU(unit)
                    .then(
                            window.location.href = 'progiv',
                            function (errResponse) {
                                console.error('Error while deleting U(controller)');
                            }
                    );
        };
       
         

        

        self.edit = function (unit) {
            console.log('Unit name to be edited', unit);
             var idc = (unit.idclient !== null) ?
             JSON.stringify(unit.idclient) : null;
             var idn = (unit.idnomer !== null) ?
             JSON.stringify(unit.idnomer) : null;
             var idorg = (unit.idorg !== null) ?
             JSON.stringify(unit.idorg) : null;
            
            
            self.unit=unit;
            self.unit.dateb= new Date(unit.dateb);
            self.unit.datee=new Date(unit.datee);
            self.unit.idclient = idc;
            self.unit.idnomer = idn;
            self.unit.idorg=idorg;
           
            $scope.myForm.$setDirty();
        };


        self.reset = function () {
            self.unit = {
          
            id: null,
            dateb:null,
            datee:null,
            idclient:null,
            idnomer:null
        };
            $scope.myForm.$setPristine(); //reset Form
        };

        self.submit = function () {
            var idc = self.unit.idclient !== null ?
            JSON.parse(self.unit.idclient) : null;
            var idn = self.unit.idnomer !== null ?
            JSON.parse(self.unit.idnomer) : null;
            var idorg = self.unit.idorg !== null ?
            JSON.parse(self.unit.idorg) : null; 
            
            
            self.unit.idclient = idc;
            self.unit.idnomer =idn;
            self.unit.idorg=idorg;
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