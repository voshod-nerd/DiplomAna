'use strict';

App.controller('ControllerProgiv', ['$scope', 'ServicsProgiv',
    function ($scope, ServicsProgiv) {
        var self = this;
        self.unit = {
            id: null,
            datein: null,
            dateout: null,
            dopusl: '',
            totalsum: '',
            idclient: null,
            idnomer: null,
            idstoimostnomer: null,
            idstoimostpit: null,
            closed: ''
        };
        self.units = [];
        self.nomers = [];
        self.hotels = [];
        self.hotelLife=null;
        self.hotel = null;
        self.filterpogiv = '';
        self.datebegin=null;
        self.dateend=null;

        self.checked = function () {

        };
        
       



        self.customFilter = function (e) {

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

        self.criteriaMatch = function (dt) {

            if (dt.idgostin === undefined || dt.idgostin === null)
                return true;
            ;
            if (self.hotel === undefined || self.hotel === null)
                return true;
            ;
            if (dt.idgostin.name === self.hotel.name)
                return true;
            else
                false;


        };

        self.fetchAllHotel = function () {
            ServicsProgiv.fetchAllUHotel()
                    .then(
                            function (d) {
                                self.hotels = d;
                                console.info(JSON.stringify(d));
                            },
                            function (errResponse) {
                                console.error('Error while fetching U(controller)');
                            }
                    );
        };
        self.fetchAllNomers = function () {
            ServicsProgiv.fetchAllUNomer()
                    .then(
                            function (d) {
                                self.nomers = d;
                                console.info(JSON.stringify(d));
                            },
                            function (errResponse) {
                                console.error('Error while fetching U(controller)');
                            }
                    );
        };
        self.fetchAllHotel();
        self.fetchAllNomers();

        self.fetchAllU = function () {
            ServicsProgiv.fetchAllU()
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
            ServicsProgiv.createU(unit)
                    .then(
                            self.fetchAllU,
                            function (errResponse) {
                                console.error('Error while creating U(controller)');
                            }
                    );
        };
        self.updateU = function (unit) {
            ServicsProgiv.updateU(unit)
                    .then(
                            self.fetchAllU,
                            function (errResponse) {
                                console.error('Error while updating U(controller)');
                            }
                    );
        };
        self.deleteU = function (unit) {
            ServicsProgiv.deleteU(unit)
                    .then(
                            self.fetchAllU,
                            function (errResponse) {
                                console.error('Error while deleting U(controller)');
                            }
                    );
        };
        self.edit = function (unit) {
           

           /* var cl = (self.unit.idclient !== null) ?
                    JSON.stringify(unit.idclient) : null;
            var stnomer = self.unit.idstoimostnomer !== null ?
                    JSON.stringify(unit.idstoimostnomer) : null;
            var stpit = self.unit.idstoimostpit !== null ?
                    JSON.stringify(unit.idstoimostpit) : null;
            var nomer = self.unit.idnomer !== null ?
                    JSON.stringify(unit.idnomer) : null;
     */
            self.unit = unit;

           // self.unit.idclient = cl;
           // self.unit.idstoimostnomer = stnomer;
            //self.unit.idnomer = nomer;
            //self.unit.idstoimostpit = stpit;

            self.unit.datein = new Date(unit.datein);
            self.unit.dateout = new Date(unit.dateout);
            //alert(JSON.stringify(self.unit.idclient.fio));

            $scope.myForm.$setDirty();
        };
        self.reset = function () {
            self.unit = {
                id: null,
                datein: null,
                dateout: null,
                dopusl: '',
                totalsum: '',
                idclient: null,
                idnomer: null,
                idstoimostnomer: null,
                idstoimostpit: null,
                closed: ''


            };
            $scope.myForm.$setPristine(); //reset Form
        };
        self.submit = function () {
            var cl = (self.unit.idclient !== null) ?
                    JSON.parse(self.unit.idclient) : null;
            var stnomer = self.unit.idstoimostnomer !== null ?
                    JSON.parse(self.unit.idstoimostnomer) : null;
            var stpit = self.unit.idstoimostpit !== null ?
                    JSON.parse(self.unit.idstoimostpit) : null;
            var nomer = self.unit.idnomer !== null ?
                    JSON.parse(self.unit.idnomer) : null;

            self.unit.idclient = cl;
            self.unit.idstoimostnomer = stnomer;
            self.unit.idnomer = nomer;
            self.unit.idstoimostpit = stpit;
            self.unit.datein = new Date((self.unit.datein));
            self.unit.dateout = new Date((self.unit.dateout));

            if (self.unit.id === null) {
                console.log('Saving New Unit', self.unit);
                self.createU(self.unit);
            } else {
                self.updateU(self.unit);
                console.log('Unit updated to  ', self.unit);
            }
            self.reset();
        };

        self.report = function (e) {
            window.open('report/2/' + e.id);
            self.fetchAllU();
        };
        
         
         self.reportLifeHotel = function (hotel) {
            if (self.hotelLife===null) return true;
            console.info(self.hotelLife.id);
            window.open('report/4/' + self.hotelLife.id);
            //self.fetchAllU();
        };
        
        self.anketa = function (e) {
            window.open('report/5/' + e.id);
           
        };
        
         self.registr = function () {
            window.open('report/7/2');
          
        };
         self.gurnal = function () {
            window.open('report/9/2');
          
        };
        
        
         self.reestr1 = function () {
            window.open('report/10/2');
          
        };
        
         self.reestr2 = function () {
            window.open('report/11/2');
          
        };
        
         self.izm = function () {
             
             
            var db= new Date();
            db=self.datebegin;
            var de=new Date();
            de=self.dateend;
            
            window.open('report/izm/'+db.toISOString().slice(0,10)+":::"+de.toISOString().slice(0,10));
          
        };


    }]);