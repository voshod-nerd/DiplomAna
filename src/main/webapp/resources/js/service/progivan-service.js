'use strict';

App.factory('ServiceProg', ['$http', '$q', function ($http, $q) {

        self.headers = {};
        self.headers["Content-Type"] = 'application/json';

        return {
            fetchAllDbElems: function () {
                return $http.get('/vc/restprogivanie')
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while fetching dbElems');
                                    return $q.reject(errResponse);
                                }
                        );
            },
            createDbElem: function (dbElem) {
                return $http.post('/vc/restprogivanie/item',
                        JSON.stringify(dbElem))
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while creating dbElem');
                                    return $q.reject(errResponse);
                                }
                        );
            },
            updateDbElem: function (dbElem) {
                return $http.put('/vc/restprogivanie/item',
                        JSON.stringify(dbElem))
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while updating dbElem');
                                    return $q.reject(errResponse);
                                }
                        );
            },
            deleteDbElem: function (dbElem) {
                return $http({method: 'DELETE',
                    url: '/vc/restprogivanie/item',
                    data: JSON.stringify(dbElem),
                    headers: self.headers})
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while deleting dbElem');
                                    return $q.reject(errResponse);
                                }
                        );
            }

        };
    }]);


