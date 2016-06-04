'use strict';

App.controller('Controller', ['$scope', 'Servics',
    function ($scope, Servics) {
        var self = this;
        self.bookType = {id: null, name: ''};
        self.currentBookType = {id: null, name: ''};
        self.bookTypes = [];
        
        self.vis='none';
        
        self.zayv = {
            id: null,
            datez: '',
            datezav: '',
            status: '',
            idnomer: null,
            idsotr: null,
            typez:null
        };
        
        
        self.zayvs = [];
        self.showBlock = function() {
           self.vis='inline-block'; 
        };
        
        
        self.fetchAllZayv = function () {
            Servics.fetchAllU()
                    .then(
                            function (d) {
                                self.zayvs = d;
                                alert(JSON.stringify(d));
                            },
                            function (errResponse) {
                                console.error('Error while fetching Zav(controller)');
                            }
                    );
        };

        self.fetchAllZayv();

        self.createZayv = function (zayv) {
            Servics.createZayv(zayv)
                    .then(
                            self.fetchAllZayv,
                            function (errResponse) {
                                console.error('Error while creating Zayv(controller)');
                            }
                    );
        };

        self.updateZayv = function (zayv) {
           Services.updateU(zayv)
                    .then(
                            self.fetchAllU,
                            function (errResponse) {
                                console.error('Error while updating Zayv(controller)');
                            }
                    );
        };

        self.deleteZayv = function (zayv) {
           Servics.deleteU(zayv)
                    .then(
                            self.fetchAllU,
                            function (errResponse) {
                                console.error('Error while deleting Zayv(controller)');
                            }
                    );
        };
        
        
       

    }]);