var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $interval, $http) {
	$scope.thedaytime = new Date().toLocaleString();
	$interval(function() {
		$scope.thedaytime = new Date().toLocaleString();
	}, 1000);
	$scope.names = [];
	$scope.form = {
		number: "",
		name: "",
		count: "",
		price: "",
		daytime: "",
	};
	_refreshPageData();
	$scope.edit = function(x) {
		$scope.form.number = x.number;
		$scope.form.name = x.name;
		$scope.form.count = x.count;
		$scope.form.price = x.price;
		$scope.form.daytime = x.daytime;
	};
	$scope.del = function(x) {
		$scope.form.number = x.number;
		$scope.form.name = x.name;
		$scope.form.count = x.count;
		$scope.form.price = x.price;
		$scope.form.daytime = x.daytime;
		let number = x.number;
		let name = x.name;
		let count = x.count;
		let price = x.price;
		if (number != "" && name != "" && count != "" && price != "") {
			$.post("delete", { number: number, name: name, count: count, price: price });
		}
		setTimeout(() => {
			document.location.reload();
		}, 500);
	};
	function _refreshPageData() {
		$http({
			method: 'GET',
			url: 'projectall'
		}).then(function successCallback(response) {
			$scope.names = response.data.projects;
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
	}

	$scope.btn = () => {
		let number = $("#number").val();
		let name = $("#name").val();
		let count = $("#count").val();
		let price = $("#price").val();
		if (number != "" && name != "" && count != "" && price != "") {
			$.post("projectadd", { number: number, name: name, count: count, price: price, daytime: $scope.thedaytime });
		}
		setTimeout(() => {
			document.location.reload();
		}, 500);
	}

	$scope.myClickset = () => {
		let setid = $("#setid").val();
		let setcount = $("#setcount").val();
		if (setid != "" && setcount != "") {
			$.post("set", { count: setcount, id: setid });
			$.get("projectgetonly",{id: setid});
		}
		setTimeout(() => {
			document.location.reload();
		}, 500);
		
	}
	
	
});





















