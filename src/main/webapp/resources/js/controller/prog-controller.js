'use strict';

App.controller('ControllerProg', ['$scope', 'ServicsProg',
    function ($scope, ServicsProg) {
        var self = this;

        self.unit = {
            id: null,
            dateb: null,
            dateend:null,
            name: '',
            idtarif: null,
            idorganization: null
           

        };




        self.units = [];



        self.fetchAllU = function () {
            ServicsProg.fetchAllU()
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
            ServicsProg.createU(unit)
                    .then(
                            self.fetchAllU,
                            function (errResponse) {
                                console.error('Error while creating U(controller)');
                            }
                    );
        };

        self.updateU = function (unit) {
            ServicsProg.updateU(unit)
                    .then(
                            self.fetchAllU,
                            function (errResponse) {
                                console.error('Error while updating U(controller)');
                            }
                    );
        };

        self.deleteU = function (unit) {
            ServicsProg.deleteU(unit)
                    .then(
                            self.fetchAllU,
                            function (errResponse) {
                                console.error('Error while deleting U(controller)');
                            }
                    );
        };


        self.edit = function (unit) {
            console.log('Unit name to be edited', unit);
            var org = (unit.idorganization !== null) ?
                    JSON.stringify(unit.idorganization) : null;
            var tar = (unit.idtarif !== null) ?
                    JSON.stringify(unit.idtarif) : null;

            self.unit = unit;
            
            self.unit.dateb=new Date(unit.dateb);
            self.unit.dateend=new Date(unit.dateend);
            
            self.unit.idorganization = org;
            self.unit.idtarif = tar;


            $scope.myForm.$setDirty();
        };


        self.reset = function () {
            self.unit = {
            id: null,
            dateb: null,
            dateend:null,
            name: '',
            idtarif: null,
            idorganization: null


            };
            $scope.myForm.$setPristine(); //reset Form
        };

        self.submit = function () {
            // console.log('department - ' + self.employee.department);
            /* var department = self.employee.department !== null ?
             JSON.parse(self.employee.department) : null;
             var post = self.employee.post !== null ?
             JSON.parse(self.employee.post) : null;
             */
            //self.unit.location = department;
            //self.unit.name = post;

            var org = (self.unit.idorganization !== null) ?
                    JSON.parse(self.unit.idorganization) : null;
             var tar = self.unit.idtarif !== null ?
            JSON.parse(self.unit.idtarif) : null;
            
           
            
            self.unit.idorganization = org;
            self.unit.idtarif = tar;
            
            
            self.unit.dateb=new Date((self.unit.dateb));
            self.unit.dateend=new Date((self.unit.dateend));        
           //alert(JSON.stringify(self.unit));
           
           



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