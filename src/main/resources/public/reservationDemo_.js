angular.module('demo', []).controller(
		'reservationsCtrl',
		function($scope, $http) {
			$http.get('http://localhost:8090/reservation').then(
					function(response) {
						$scope.reservations = response.data;
					});
			$scope.edit = true;
			$scope.error = false;
			$scope.incomplete = false;
			$scope.hideform = true;
			$scope.editReservation = function(id) {
				$scope.hideform = false;
				if (id == 'new') {
					$scope.edit = true;
					$scope.incomplete = true;
					$scope.id = '';
					$scope.courseId = '';
					$scope.status = '';
				} else {
					$scope.edit = true;
					$scope.id = $scope.reservations[id].id;
					$scope.courseId = $scope.reservations[id].courseId;
					$scope.status = $scope.reservations[id].status;
				}
			};

			$scope.saveReservation = function() {
				var obj = {
					id : $scope.id,
					courseId : $scope.courseId,
					status : $scope.status
				};
				$scope.hideform = true;
				
				
				if($scope.id=='')
				$http.post('http://localhost:8090/reservation', obj, {
					headers : {
						'Content-Type' : 'application/json; charset=UTF-8'
					},
					'Accept' : 'application/json'
				}).then(function onSuccess(data) {
					window.alert(JSON.stringify(data.data));
					$http.get('http://localhost:8090/reservation').then(
							function(response) {
								$scope.reservations = response.data;
							});
					$route.reload();
				}, function onError(err) {
					// do something on error
				});
				else
				$http.put('http://localhost:8090/reservation', obj, {
					headers : {
						'Content-Type' : 'application/json; charset=UTF-8'
					},
					'Accept' : 'application/json'
				}).then(function onSuccess(data) {
					window.alert(JSON.stringify(data.data));
					$http.get('http://localhost:8090/reservation').then(
							function(response) {
								$scope.reservations = response.data;
							});
					$route.reload();
				}, function onError(err) {
					// do something on error
				});
				$scope.id=''
			};

			$scope.$watch('id', function() {
				$scope.test();
			});
			$scope.$watch('courseId', function() {
				$scope.test();
			});
			$scope.$watch('status', function() {
				$scope.test();
			});

			$scope.test = function() {
				$scope.incomplete = false;
				if ($scope.edit
						&& (!$scope.courseId.length || !$scope.status.length)) {
					$scope.incomplete = true;
				}
			};
		});