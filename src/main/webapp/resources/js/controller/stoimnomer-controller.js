'use strict';

App.controller('ControllerStoimNomer', ['$scope', 'ServicsStoimostNomer',
    function ($scope, ServicsStoimostNomer) {
        var self = this;

       

        self.unit = {
            id: null,
            idtarif:null,
            idtypenomer:null,
            summa:''
          
        };




        self.units = [];
       

        self.fetchAllU = function () {
            ServicsStoimostNomer.fetchAllU()
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
           ServicsStoimostNomer.createU(unit)
                    .then(
                            self.fetchAllU,
                            function (errResponse) {
                                console.error('Error while creating U(controller)');
                            }
                    );
        };

        self.updateU = function (unit) {
            ServicsStoimostNomer.updateU(unit)
                    .then(
                            self.fetchAllU,
                            function (errResponse) {
                                console.error('Error while updating U(controller)');
                            }
                    );
        };

        self.deleteU = function (unit) {
           ServicsStoimostNomer.deleteU(unit)
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
             var pit = (unit.idtypenomer !== null) ?
             JSON.stringify(unit.idtypenomer) : null;
            
            
            self.unit=unit;
            self.unit.idtarif = tar;
            self.unit.idtypenomer = pit;
            $scope.myForm.$setDirty();
        };


        self.reset = function () {
            self.unit = {
             id: null,
            idtarif:null,
            idtypenomer:null,
            summa:''
        };
            $scope.myForm.$setPristine(); //reset Form
        };

        self.submit = function () {
           
            var tar = self.unit.idtarif !== null ?
            JSON.parse(self.unit.idtarif) : null;
            var pit = self.unit.idtypenomer !== null ?
            JSON.parse(self.unit.idtypenomer) : null;
            alert(tar);
            self.unit.idtarif = tar;
            self.unit.idtypenomer = pit; 
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