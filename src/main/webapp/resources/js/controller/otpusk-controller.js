'use strict';

App.controller('ControllerOtpusk', ['$scope', 'ServicsOtpusk',
    function ($scope, ServicsOtpusk) {
        var self = this;



        self.unit = {
            id: null,
            idsotr: null,
            dateb: null,
            dateend: null
        };




        self.units = [];


        self.fetchAllU = function () {
            ServicsOtpusk.fetchAllU()
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
            v.createU(unit)
                    .then(
                            self.fetchAllU,
                            function (errResponse) {
                                console.error('Error while creating U(controller)');
                            }
                    );
        };

        self.updateU = function (unit) {
            ServicsOtpusk.updateU(unit)
                    .then(
                            self.fetchAllU,
                            function (errResponse) {
                                console.error('Error while updating U(controller)');
                            }
                    );
        };

        self.deleteU = function (unit) {
            ServicsOtpusk.deleteU(unit)
                    .then(
                            self.fetchAllU,
                            function (errResponse) {
                                console.error('Error while deleting U(controller)');
                            }
                    );
        };




        self.edit = function (unit) {
            console.log('Unit name to be edited', unit);
            var sotr = (unit.idsotr !== null) ?
                    JSON.stringify(unit.idsotr) : null;



            self.unit = unit;
            self.unit.idsotr = sotr;
            self.unit.dateb = new Date(unit.dateb);
            self.unit.dateend = new Date(unit.dateend);
            $scope.myForm.$setDirty();
        };


        self.reset = function () {
            self.unit = {
                id: null,
                idsotr: null,
                dateb: null,
                dateend: null
            };
            $scope.myForm.$setPristine(); //reset Form
        };

        self.submit = function () {


            var sotr = self.unit.idsotr !== null ?
                    JSON.parse(self.unit.idsotr) : null;

            self.unit.idsotr = sotr;
            self.unit.dateb = new Date((self.unit.dateb));
            self.unit.dateend = new Date((self.unit.dateend));


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