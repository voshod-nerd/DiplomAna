'use strict';

App.controller('ControllerStoimUslug', ['$scope', 'ServicsStoimostUslug',
    function ($scope, ServicsStoimostUslug) {
        var self = this;

       

        self.unit = {
            id: null,
            idtarif:null,
            idtuslug:null,
            summa:''
        };
        
        self.sortType = 'location'; // set the default sort type
        self.sortReverse = false;  // set the default sort order
        self.searchFish = '';     // set the default search/filter term
        
        
        self.units = [];
       

        self.fetchAllU = function () {
            ServicsStoimostUslug.fetchAllU()
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
           ServicsStoimostUslug.createU(unit)
                    .then(
                            self.fetchAllU,
                            function (errResponse) {
                                console.error('Error while creating U(controller)');
                            }
                    );
        };

        self.updateU = function (unit) {
           ServicsStoimostUslug.updateU(unit)
                    .then(
                            self.fetchAllU,
                            function (errResponse) {
                                console.error('Error while updating U(controller)');
                            }
                    );
        };

        self.deleteU = function (unit) {
           ServicsStoimostUslug.deleteU(unit)
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
             var pit = (unit.iduslug !== null) ?
             JSON.stringify(unit.iduslug) : null;
            
            
            self.unit=unit;
            self.unit.idtarif = tar;
            self.unit.iduslug = pit;
            $scope.myForm.$setDirty();
        };


        self.reset = function () {
            self.unit = {
            id: null,
            idtarif:null,
            idtuslug:null,
            summa:''
        };
            $scope.myForm.$setPristine(); //reset Form
        };

        self.submit = function () {
           
            var tar = self.unit.idtarif !== null ?
            JSON.parse(self.unit.idtarif) : null;
            var pit = self.unit.iduslug !== null ?
            JSON.parse(self.unit.iduslug) : null;
           
            self.unit.idtarif = tar;
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