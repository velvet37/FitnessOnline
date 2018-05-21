angular.module('demo', []).controller(
    'statCtrl',
    function($scope, $http) {
        $scope.statistics = [
            {
                id: 99999,
                methodName: "error in connecting",
                openTime: 1234,
            }];
        $http({
            method: 'GET',
            url: 'http://localhost:8090/reservation/statistics',
            headers: {'Content-Type': 'application/json;charset=UTF-8'}
        }).then(function successCallback(response) {
            $scope.statistics = response.data;
            console.log("x",response.status);
        }, function errorCallback(response) {
            console.error('Error occurred:', response.status, response.data);
        });
    });