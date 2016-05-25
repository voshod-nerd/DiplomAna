'use strict';

App.controller('ControllerPitan', ['$scope', 'ServicsPitan',
    function ($scope, ServicsPitan) {
        var self = this;

       

        self.unit = {
            id: null,
            
            name:''
          
        };




        self.units = [];
        self.showBlock = function () {
            self.vis = 'inline-block';
        };


        self.fetchAllU = function () {
            ServicsPitan.fetchAllU()
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
           ServicsPitan.createU(unit)
                    .then(
                            self.fetchAllU,
                            function (errResponse) {
                                console.error('Error while creating U(controller)');
                            }
                    );
        };

        self.updateU = function (unit) {
            ServicsPitan.updateU(unit)
                    .then(
                            self.fetchAllU,
                            function (errResponse) {
                                console.error('Error while updating U(controller)');
                            }
                    );
        };

        self.deleteU = function (unit) {
           ServicsPitan.deleteU(unit)
                    .then(
                            self.fetchAllU,
                            function (errResponse) {
                                console.error('Error while deleting U(controller)');
                            }
                    );
        };


        

        self.edit = function (unit) {
            console.log('Unit name to be edited', unit);
            /*var department = (employee.department !== null) ?
             JSON.stringify(employee.department) : null;
             var post = (employee.post !== null) ?
             JSON.stringify(employee.post) : null;
             self.employee = employee;
             */
            self.unit=unit;
            //self.unit.location = unit.location;
            //;
            //self.unit.name = unit.name;
            $scope.myForm.$setDirty();
        };


        self.reset = function () {
            self.unit = {
            id: null,
            name:''
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
            if (self.unit.id === null) {
                console.log('Saving New Unit', self.unit);
                self.createU(self.unit);
            } else {
                self.updateU(self.U);
                console.log('Unit updated to  ', self.unit);
            }
            self.reset();
        };


    }]);