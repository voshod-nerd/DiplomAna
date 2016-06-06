'use strict';
App.controller('ControllerReserv', ['$scope', 'ControllerReserv',
    function ($scope, ControllerReserv) {

        var self = this;

        self.select = 0;
        self.block1 = 'none';
        self.block2 = 'none';
        self.block3 = 'none';
        self.block4 = 'none';
        self.block5 = 'none';


        self.myFunc = function () {
            self.block1 = 'none';
            self.block2 = 'none';
            self.block3 = 'none';
            self.block4 = 'none';
           

            if (self.select == 1) {
              
                self.block1 = 'inline-block';
            }
            if (self.select == 2) {
                self.block2 = 'inline-block';
            }
            if  (self.select == 3) {
                self.block3 = 'inline-block';
            }
            if (self.select == 4) {
                self.block4 = 'inline-block';
            }
        };


    }]);