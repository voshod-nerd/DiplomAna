'use strict';

App.factory('ServicsStoimostNomer', ['$http', '$q', function ($http, $q) {

        self.headers = {};
        self.headers["Content-Type"] = 'application/json';

        return { 
            fetchAllU: function () {
                return $http.get('/vc/reststoimostnomera')
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while fetching units');
                                    return $q.reject(errResponse);
                                }
                        );
            },
            createU: function (unit) {
                return $http.post('/vc/reststoimostnomera/item',
                        JSON.stringify(unit))
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while creating unit');
                                    return $q.reject(errResponse);
                                }
                        );
            },
            updateU: function (unit) {
                return $http.put('/vc/reststoimostnomera/item',
                        JSON.stringify(unit))
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while updating unit');
                                    return $q.reject(errResponse);
                                }
                        );
            },
            deleteU: function (unit) {
                return $http({method: 'DELETE',
                    url: '/vc/reststoimostnomera/item/',
                    data: JSON.stringify(unit),
                    headers: self.headers})
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while deleting unit');
                                    return $q.reject(errResponse);
                                }
                        );
            }
        };
    }]);


