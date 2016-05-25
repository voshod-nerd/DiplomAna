'use strict';

App.factory('OrderService', ['$http', '$q', function ($http, $q) {

        self.headers = {};
        self.headers["Content-Type"] = 'application/json';

        return { 
            fetchAllZayv: function () {
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
            createZayv: function (employee) {
                return $http.post('/vc/zav/item',
                        JSON.stringify(employee))
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
            updateZayv: function (employee) {
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
            deleteZayv: function (employee) {
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