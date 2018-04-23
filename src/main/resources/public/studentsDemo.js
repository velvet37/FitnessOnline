angular.module('demo', []).controller(
		'reservationsCtrl',
		function($scope, $http) {
			$http.get('http://localhost:8080/littleApp/student').then(
					function(response) {
						$scope.students = response.data;
					});
			$scope.edit = true;
			$scope.error = false;
			$scope.incomplete = false;
			$scope.hideform = true;
			$scope.editStudent = function(id) {
				$scope.hideform = false;
				if (id == 'new') {
					$scope.edit = true;
					$scope.incomplete = true;
					$scope.rollNo = '';
					$scope.name = '';
					$scope.surname = '';
				} else {
					$scope.edit = true;
					$scope.name = $scope.students[id].name;
					$scope.surname = $scope.students[id].surname;
					$scope.rollNo = $scope.students[id].rollNo;
				}
			};

			$scope.saveStudent = function() {
				var obj = {
					rollNo : $scope.rollNo,
					name : $scope.name,
					surname : $scope.surname
				};
				$scope.hideform = true;
				
				
				if($scope.rollNo=='')
				$http.post('http://localhost:8080/littleApp/student', obj, {
					headers : {
						'Content-Type' : 'application/json; charset=UTF-8'
					},
					'Accept' : 'application/json'
				}).then(function onSuccess(data) {
					window.alert(JSON.stringify(data.data));
					$http.get('http://localhost:8080/littleApp/student').then(
							function(response) {
								$scope.students = response.data;
							});
					$route.reload();
				}, function onError(err) {
					// do something on error
				});
				else
				$http.put('http://localhost:8080/littleApp/student', obj, {
					headers : {
						'Content-Type' : 'application/json; charset=UTF-8'
					},
					'Accept' : 'application/json'
				}).then(function onSuccess(data) {
					window.alert(JSON.stringify(data.data));
					$http.get('http://localhost:8080/littleApp/student').then(
							function(response) {
								$scope.students = response.data;
							});
					$route.reload();
				}, function onError(err) {
					// do something on error
				});
				$scope.rollNo=''
			};

			$scope.$watch('rollNo', function() {
				$scope.test();
			});
			$scope.$watch('name', function() {
				$scope.test();
			});
			$scope.$watch('surname', function() {
				$scope.test();
			});

			$scope.test = function() {
				$scope.incomplete = false;
				if ($scope.edit
						&& (!$scope.name.length || !$scope.surname.length)) {
					$scope.incomplete = true;
				}
			};
		});