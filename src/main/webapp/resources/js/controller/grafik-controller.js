'use strict';

App.controller('ControllerGrafik', ['$scope', 'ServicsGrafik',
    function ($scope, ServicsGrafik) {
        var self = this;

        self.month='';
        self.god='';
        self.unit = {
            id:null,
            idsotrudnik:null,
            idhotel:null,
            dayd:null
          
        };
        self.hotels = [];
        self.hotel =null;
        self.units = [];
       
        $scope.sortType = 'location'; // set the default sort type
        $scope.sortReverse = false;  // set the default sort order
        $scope.searchFish = '';     // set the default search/filter term
       
       self.fetchAllHotel = function () {
            ServicsGrafik.fetchAllUHotel()
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
        self.fetchAllHotel();
        
        
       
       
       
       self.grafiksmen =function () 
       {
          
         
           window.open('report/6/' +  self.god+'-'+self.month);
         
       };
       

        self.fetchAllU = function () {
            ServicsGrafik.fetchAllU()
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
           ServicsGrafik.createU(unit)
                    .then(
                            self.fetchAllU,
                            function (errResponse) {
                                console.error('Error while creating U(controller)');
                            }
                    );
        };

        self.updateU = function (unit) {
           ServicsGrafik.updateU(unit)
                    .then(
                            self.fetchAllU,
                            function (errResponse) {
                                console.error('Error while updating U(controller)');
                            }
                    );
        };

        self.deleteU = function (unit) {
            console.info('delete user');
          ServicsGrafik.deleteU(unit)
                    .then(
                            self.fetchAllU,
                            function (errResponse) {
                                console.error('Error while deleting U(controller)');
                            }
                    );
        };


        

        self.edit = function (unit) {
            console.log('Unit name to be edited', unit);
            var sotrudnik = unit.idsotrudnik !== null ?
            JSON.stringify(unit.idsotrudnik) : null;
            var hotel = unit.idhotel !== null ?
            JSON.stringify(unit.idhotel) : null;
            
            
            self.unit=unit;
            self.unit.idhotel = hotel;
            self.unit.idsotrudnik =sotrudnik;
            self.unit.dayd= new Date(unit.dayd);
            $scope.myForm.$setDirty();
        };


        self.reset = function () {
            self.unit = {
            id:null,
            idsotrudnik:null,
            idhotel:null,
            dayd:null
        };
            $scope.myForm.$setPristine(); //reset Form
        };

        self.submit = function () {
            
          
            
            var sotrudnik = self.unit.idsotrudnik !== null ?
            JSON.parse(self.unit.idsotrudnik) : null;
            var hotel = self.unit.idhotel !== null ?
            JSON.parse(self.unit.idhotel) : null;
            
            
            self.unit.idsotrudnik = sotrudnik;
            self.unit.idhotel = hotel; 
            self.unit.dayd=new Date(self.unit.dayd);
            
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