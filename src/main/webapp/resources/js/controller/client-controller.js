'use strict';

App.controller('ControllerClient', ['$scope', 'ServiceClient',
    function ($scope, ServiceClient) {
        var self = this;

        self.vis='';
        self.vis2='';
        self.vizaShow='';
        self.vizaAdd='';
        

        self.unit = {
            id: null,
            adres: '',
            dataokon: null,
            datavid: null,
            dr: null,
            fioeng: '',
            kemvidan: '',
            number: '',
            pol: '',
            progclient: null,
            serdoc: '',
            strana: '',
            viddock: '',
            idorg: null

        };
        
        
        
        self.viza = {
            id:null,
            beg:null,
            end:null,
            idclient:null,
            number:''   
        };
        self.vizas=[];
        
        self.show = function() {
          self.vis=true;  
        };
        
        self.showTable = function(e) {
            self.vis2=true;
            self.selectedunit=e;
            self.fetchAllProgivUnits();
   
        };
        self.showViza = function(e) {
            self.vizaShow=true;
            self.selectedunit=e;
            self.fetchAllUViza();
   
        };
        self.showAddViza = function(e) {
            self.vizaAdd=true;
           
   
        };
        
        
        
        
        self.selectedunit=null;
        self.progivunits=[];
        self.fetchAllProgivUnits = function () {
            ServiceClient.fetchAllProgivUnits()
                    .then(
                            function (d) {
                                self.progivunits = d;
                                console.info(JSON.stringify(d));
                            },
                            function (errResponse) {
                                console.error('Error while fetching U(controller)');
                            }
                    );
        };
        
        

        self.searchFish = '';
        self.progiv='';


        self.units = [];
        self.showBlock = function () {
            self.vis = 'inline-block';
        };


        self.fetchAllU = function () {
            ServiceClient.fetchAllU()
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
            ServiceClient.createU(unit)
                    .then(
                            self.fetchAllU,
                            function (errResponse) {
                                console.error('Error while creating U(controller)');
                            }
                    );
        };

        self.updateU = function (unit) {
            ServiceClient.updateU(unit)
                    .then(
                            self.fetchAllU,
                            function (errResponse) {
                                console.error('Error while updating U(controller)');
                            }
                    );
        };

        self.deleteU = function (unit) {
            ServiceClient.deleteU(unit)
                    .then(
                            self.fetchAllU,
                            function (errResponse) {
                                console.error('Error while deleting U(controller)');
                            }
                    );
        };
        
        
        self.fetchAllUViza = function () {
            ServiceClient.fetchAllUViza()
                    .then(
                            function (d) {
                                self.vizas = d;
                                console.info(JSON.stringify(d));
                            },
                            function (errResponse) {
                                console.error('Error while fetching U(controller)');
                            }
                    );
        };

        //self.fetchAllUViza();

        self.createUViza = function (unit) {
            unit.idclient=self.selectedunit;
            ServiceClient.createUViza(unit)
                    .then(
                            self.fetchAllUViza,
                            function (errResponse) {
                                console.error('Error while creating U(controller)');
                            }
                    );
        };

        self.updateUViza = function (unit) {
            ServiceClient.updateUViza(unit)
                    .then(
                            self.fetchAllUViza,
                            function (errResponse) {
                                console.error('Error while updating U(controller)');
                            }
                    );
        };

        self.deleteUViza = function (unit) {
            ServiceClient.deleteUViza(unit)
                    .then(
                            self.fetchAllUViza,
                            function (errResponse) {
                                console.error('Error while deleting U(controller)');
                            }
                    );
        };
        




        self.edit = function (unit) {
            self.vis=true;
            console.log('Unit name to be edited', unit);
            var idprog = (unit.progclient !== null) ?
                    JSON.stringify(unit.progclient) : null;
            var idorg = (unit.idorg !== null) ?
                    JSON.stringify(unit.idorg) : null;

             


            self.unit = unit;
            self.unit.progclient = idprog;
            self.unit.idorg = idorg;
            self.unit.dr = new Date(unit.dr);
            self.unit.dataokon = new Date(unit.dataokon);
            self.unit.datavid = new Date(unit.datavid);
            

            $scope.myForm.$setDirty();
        };


        self.reset = function () {
             self.vis=false;
            self.unit = {
                id: null,
                adres: '',
                dataokon: null,
                datavid: null,
                dr: null,
                fioeng: '',
                kemvidan: '',
                number: '',
                pol: '',
                progclient: null,
                serdoc: '',
                strana: '',
                viddock: '',
                idorg: null
            };
            $scope.myForm.$setPristine(); //reset Form
        };

        self.submit = function () {
             self.vis=false;
            
            var idp = self.unit.progclient !== null ?
                    JSON.parse(self.unit.progclient) : null;
            var idorg = self.unit.idorg !== null ?
                    JSON.parse(self.unit.idorg) : null;
               
            self.unit.progclient = idp;
            self.unit.idorg = idorg;
            self.unit.dr=new Date(self.unit.dr);
            self.unit.dataokon=new Date(self.unit.dataokon);
           self.unit.datavid=new Date(self.unit.datavid);
            if (self.unit.id === null) {
                console.log('Saving New Unit', self.unit);
                self.createU(self.unit);
            } else {
                self.updateU(self.unit);
                console.log('Unit updated to  ', self.unit);
            }
            self.reset();
        };
        
        
        
        
        
        
         self.editViza = function (unit) {
            self.vizaAdd=true;
            console.log('Viza name to be edited', unit);
            var idclient = (unit.idclient !== null) ?
                    JSON.stringify(unit.idclient) : null;
            self.viza = unit;
            self.viza.idclient = idclient;
            
            self.viza.beg = new Date(unit.beg);
            self.viza.end = new Date(unit.end);
            $scope.myForm.$setDirty();
        };


        self.resetViza = function () {
             self.vizaAdd=false;
            self.viza = {
                  id:null,
            beg:null,
            end:null,
            idclient:null,
            number:''   
            };
            $scope.myForm.$setPristine(); //reset Form
        };

        self.submitViza = function () {
             console.log('Viza - ' + self.viza);
            var idclient = self.viza.idclient !== null ?
                    JSON.parse(self.viza.idclient) : null;
            self.viza.idclient = idclient;
            self.viza.beg=new Date(self.viza.beg);
            self.viza.end=new Date(self.viza.end);
            
            if (self.viza.id === null) {
                console.log('Saving New Unit', self.viza);
                self.createUViza(self.viza);
            } else {
                self.updateUViza(self.viza);
                console.log('Unit updated to  ', self.viza);
            }
            self.resetViza();
        };
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        


    }]);