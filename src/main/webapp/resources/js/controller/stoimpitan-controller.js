'use strict';

App.controller('ControllerStoimPitan', ['$scope', 'ServicsStoimostPitan',
    function ($scope, ServicsStoimostPitan) {
        var self = this;

       

        self.unit = {
            id: null,
            idtarif:null,
            idpitanie:null,
            sum:'' 
        };




        self.units = [];
       

        self.fetchAllU = function () {
            ServicsStoimostPitan.fetchAllU()
                    .then(
                            function (d) {
                                self.units = d;
                                alert(JSON.stringify(d));
                            },
                            function (errResponse) {
                                console.error('Error while fetching U(controller)');
                            }
                    );
        };

        self.fetchAllU();

        self.createU = function (unit) {
           ServicsStoimostPitan.createU(unit)
                    .then(
                            self.fetchAllU,
                            function (errResponse) {
                                console.error('Error while creating U(controller)');
                            }
                    );
        };

        self.updateU = function (unit) {
            ServicsStoimostPitan.updateU(unit)
                    .then(
                            self.fetchAllU,
                            function (errResponse) {
                                console.error('Error while updating U(controller)');
                            }
                    );
        };

        self.deleteU = function (unit) {
           ServicsStoimostPitan.deleteU(unit)
                    .then(
                            self.fetchAllU,
                            function (errResponse) {
                                console.error('Error while deleting U(controller)');
                            }
                    );
        };


        

        self.edit = function (unit) {
            console.log('Unit name to be edited', unit);
             var tar = (unit.idtarif !== null) ?
             JSON.stringify(unit.idtarif) : null;
             var pit = (unit.idpitanie !== null) ?
             JSON.stringify(unit.idpitanie) : null;
            
            
            self.unit=unit;
            self.unit.idtarif = tar;
            self.unit.idpitanie = pit;
            $scope.myForm.$setDirty();
        };


        self.reset = function () {
            self.unit = {
            id: null,
            idtarif:null,
            idpitanie:null,
            sum:''
        };
            $scope.myForm.$setPristine(); //reset Form
        };

        self.submit = function () {
           
            var tar = self.unit.idtarif !== null ?
            JSON.parse(self.unit.idtarif) : null;
            var pit = self.unit.idpitanie !== null ?
            JSON.parse(self.unit.idpitanie) : null;
            alert(tar);
            self.unit.idtarif = tar;
            self.unit.idpitanie = pit; 
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