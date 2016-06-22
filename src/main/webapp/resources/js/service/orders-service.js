'use strict';
App.factory('OrderService', ['$http', '$q', function ($http, $q) {

        self.headers = {};
        self.headers["Content-Type"] = 'application/json';

        return {
            fetchAllHotel: function () {
                return $http.get('/vc/resthotel')
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while fetching zav');
                                    return $q.reject(errResponse);
                                }
                        );
            },
             fetchAllNumber: function () {
                return $http.get('/vc/restnomerhotel')
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while fetching zav');
                                    return $q.reject(errResponse);
                                }
                        );
            },
            
            fetchAllU: function () {
                return $http.get('/vc/zav')
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while fetching zav');
                                    return $q.reject(errResponse);
                                }
                        );
            },
             fetchFreeU: function (unit) {
                return $http.post('/vc/zav/items',JSON.stringify(unit))
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
                return $http.post('/vc/zav/item',
                        JSON.stringify(unit))
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while creating employee');
                                    return $q.reject(errResponse);
                                }
                        );
            },
            updateU: function (employee) {
                return $http.put('/vc/zav/item',
                        JSON.stringify(employee))
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while updating employee');
                                    return $q.reject(errResponse);
                                }
                        );
            },
            deleteU: function (employee) {
                return $http({method: 'DELETE',
                    url: '/vc/zav/item/',
                    data: JSON.stringify(employee),
                    headers: self.headers})
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while deleting employee');
                                    return $q.reject(errResponse);
                                }
                        );
            }

       
           

        };
    }]);