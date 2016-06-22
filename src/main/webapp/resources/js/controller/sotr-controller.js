'use strict';

App.controller('ControllerS', ['$scope', 'ServicsS',
    function ($scope, ServicsS) {
        var self = this;

        self.unit = {
            id: null,
            dr: null,
            fio: '',
            grag: '',
            num: '',
            ser: '',
            iddolgnost: null,
            iduser: null,
            mr: '',
            doclich: '',
            kemvidan: '',
            adres: '',
            phone: '',
            education: '',
            koldet: '',
            kogdavidan: null
        };

        $scope.searchFish = '';     // set the default search/filter term

        self.units = [];

        self.rep = function ()
        {
            window.open('report/8/2');
        };
        


        self.fetchAllU = function () {
            ServicsS.fetchAllU()
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
            ServicsS.createU(unit)
                    .then(
                            self.fetchAllU,
                            function (errResponse) {
                                console.error('Error while creating U(controller)');
                            }
                    );
        };

        self.updateU = function (unit) {
            ServicsS.updateU(unit)
                    .then(
                            self.fetchAllU,
                            function (errResponse) {
                                console.error('Error while updating U(controller)');
                            }
                    );
        };

        self.deleteU = function (unit) {
            ServicsS.deleteU(unit)
                    .then(
                            self.fetchAllU,
                            function (errResponse) {
                                console.error('Error while deleting U(controller)');
                            }
                    );
        };




        self.edit = function (unit) {
            console.log('Employee name to be edited', unit);
            var dolg = (unit.iddolgnost !== null) ?
                    JSON.stringify(unit.iddolgnost) : null;

            var user = (unit.iduser !== null) ?
                    JSON.stringify(unit.iduser) : null;

            self.unit = unit;
            self.unit.dr = new Date(unit.dr);
            self.unit.kogdavidan = new Date(unit.kemvidan);

            self.unit.iddolgnost = dolg;
            self.unit.iduser = user;

            $scope.myForm.$setDirty();
        };


        self.reset = function () {
            self.unit = {
                id: null,
                dr: '',
                fio: '',
                grag: '',
                num: '',
                ser: '',
                iddolgnost: null,
                iduser: null,
                mr: '',
                doclich: '',
                kemvidan: '',
                adres: '',
                phone: '',
                education: '',
                koldet: '',
                kogdavidan: ''

            };
            $scope.myForm.$setPristine(); //reset Form
        };

        self.report = function (e) {
            window.open('report/1/' + e.id);
        };
        
        self.bolnic = function (e) {
            window.open('report/bolnic/' + e.id);
        };
        self.uvol = function (e) {
            window.open('report/uvol/' + e.id);
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

            var user = self.unit.iduser !== null ?
                    JSON.parse(self.unit.iduser) : null;

            var iddolg = self.unit.iddolgnost !== null ?
                    JSON.parse(self.unit.iddolgnost) : null;
            self.unit.iddolgnost = iddolg;
            self.iduser = user;

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