'use strict';

App.controller('ControllerProg', ['$scope', 'ServiceProg',
    function ($scope, ServiceProg) {
        var self = this;
        self.dbElem = {id: null, datein: null, dateout: null, dopusl: '',totalsum:'',idclient:null,idstoimostnomer:null,idstoimostpit:null};
        
        self.dbElems = [];

        self.w1 = false;
        self.w2 = false;

        self.text1 = '[показать]';
        self.text2 = '[показать]';

        self.show1 = function () {
            self.w1 = !self.w1;
            self.text1 = self.w1 ? '[скрыть]' : '[показать]';
        };

        self.show2 = function () {
            self.w2 = !self.w2;
            self.text2 = self.w2 ? '[скрыть]' : '[показать]';
        };

        self.getChilds = function (d) {
            var childs = [];
            for (var i = 0; i < self.dbElems.length; i++) {
                if (self.dbElems[i].rootDbElem !== null && self.dbElems[i].rootDbElem.id === d.id) {
                    childs.push(self.dbElems[i]);
                }
            }
            return childs;
        };

        self.getRoots = function () {
            var roots = [];
            for (var i = 0; i < self.dbElems.length; i++) {
                if (self.dbElems[i].rootDbElem === null) {
                    roots.push(self.dbElems[i]);
                }
            }
            return roots;
        };

        self.excludeHouses = function () {
            var result = [];
            for (var i = 0; i < self.dbElems.length; i++) {
                if (self.dbElems[i].doma === null) {
                    result.push(self.dbElems[i]);
                }
            }
            return result;
        };

        self.fetchAllDbElems = function () {
            ServiceProg.fetchAllDbElems()
                    .then(
                            function (d) {
                                self.dbElems = d;
                                for (var i = 0; i < self.dbElems.length; i++) {
                                    self.dbElems[i].show = false;
                                }
                            },
                            function (errResponse) {
                                console.error('Error while fetching DbElems');
                            }
                    );
        };

        self.fetchAllDbElems();

        self.createDbElem = function (dbElem) {
            ServiceProg.createDbElem(dbElem)
                    .then(
                            self.fetchAllDbElems,
                            function (errResponse) {
                                console.error('Error while creating DbElem.');
                            }
                    );
        };

        self.updateDbElem = function (dbElem) {
            ServiceProg.updateDbElem(dbElem)
                    .then(
                            self.fetchAllDbElems,
                            function (errResponse) {
                                console.error('Error while updating DbElem.');
                            }
                    );
        };

        self.deleteDbElem = function (dbElem) {
            ServiceProg.deleteDbElem(dbElem)
                    .then(
                            self.fetchAllDbElems,
                            function (errResponse) {
                                console.error('Error while deleting DbElem.');
                            }
                    );
        };

        self.submit = function () {
            var root = self.dbElem.rootDbElem !== null ?
                    JSON.parse(self.dbElem.rootDbElem) : null;
            self.dbElem.rootDbElem = root;
            if (self.dbElem.id === null) {
                console.log('Saving New DbElem', self.dbElem);
                self.createDbElem(self.dbElem);
            } else {
                self.updateDbElem(self.dbElem);
                console.log('DbElem updated with id ', self.dbElem.id);
                console.log('DbElem updated to name ', self.dbElem.name);
            }
            self.reset();
        };

        self.edit = function (dbElem) {
            self.w1 = true;
            self.text1 = self.w1 ? '[скрыть]' : '[показать]';
            var root = (dbElem.rootDbElem !== null) ?
                    JSON.stringify(dbElem.rootDbElem) : null;
            self.dbElem = dbElem;
            self.dbElem.rootDbElem = root;
            console.log('DbElem name to be edited', dbElem.name);
            self.dbElem.id = dbElem.id;
            self.dbElem.name = dbElem.name;
            self.dbElem.socr = dbElem.socr;
            $scope.myForm.$setDirty();
        };

        self.showDbElem = function (dbElem) {
            window.open('/FiasManager/db_elem_show_page?id=' + dbElem.id);
        };

        self.reset = function () {
            self.dbElem = {id: null, name: '', socr: '', rootDbElem: ''};
            $scope.myForm.$setPristine(); //reset Form
        };

       

    }]);
