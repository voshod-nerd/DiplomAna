'use strict';
App.controller('ControllerReestUslug', ['$scope', 'ServiceReestUslug',
    function ($scope, ServiceReestUslug) {
        var self = this;

        
       
      
        self.unit = {
            id: null,
            idclient:null,
            iduslug:null
        };
       
        
        self.units = [];
        
       
        
        
         
         
         
        
           
         
        
        
        
        self.fetchAllU = function () {
            ServiceReestUslug.fetchAllU()
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
            ServiceReestUslug.createU(unit)
                    .then(
                            self.fetchAllU,
                            function (errResponse) {
                                console.error('Error while creating U(controller)');
                            }
                    );
        };

        self.updateU = function (unit) {
            ServiceReestUslug.updateU(unit)
                    .then(
                            self.fetchAllU,
                            function (errResponse) {
                                console.error('Error while updating U(controller)');
                            }
                    );
        };

        self.deleteU = function (unit) {
           ServiceReestUslug.deleteU(unit)
                    .then(
                            self.fetchAllU,
                            function (errResponse) {
                                console.error('Error while deleting U(controller)');
                            }
                    );
        };

        self.edit = function (unit) {
            console.log('Unit name to be edited', unit);
            var tar = (unit.idclient !== null) ?
                    JSON.stringify(unit.idclient) : null;
            var pit = (unit.uslug !== null) ?
                    JSON.stringify(unit.iduslug) : null;


            self.unit = unit;
            self.unit.idclient = tar;
            self.unit.iduslug = pit;
            $scope.myForm.$setDirty();
        };


        self.reset = function () {
            self.unit = {
              id: null,
            idclient:null,
            iduslug:null
            };
            $scope.myForm.$setPristine(); //reset Form
        };

        self.submit = function () {

            var tar = self.unit.idclient !== null ?
                    JSON.parse(self.unit.idclient) : null;
            var pit = self.unit.iduslug !== null ?
                    JSON.parse(self.unit.iduslug) : null;
            
            self.unit.idclient = tar;
            self.unit.iduslug = pit;
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