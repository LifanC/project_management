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
		day: "",
		daytime: "",
	};
	_refreshPageData();
	$scope.edit = function(x) {
		$scope.form.number = x.number;
		$scope.form.name = x.name;
		$scope.form.count = x.count;
		$scope.form.price = x.price;
		$scope.form.day = x.day;
		$scope.form.daytime = x.daytime;
	};
	$scope.del = function(x) {
		$scope.form.number = x.number;
		$scope.form.name = x.name;
		$scope.form.count = x.count;
		$scope.form.price = x.price;
		$scope.form.day = x.day;
		$scope.form.daytime = x.daytime;
		let number = x.number;
		let name = x.name;
		let count = x.count;
		let price = x.price;
		let day = x.day;
		if (number != "" && name != "" && count != "" && price != "" && day != "") {
			$.post("delete", { number: number, name: name, count: count, price: price, day: day  });
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
		let day = $("#day").val();
		if (number != "" && name != "" && count != "" && price != "" && day != "") {
			$.post("projectadd", { number: number, name: name, count: count, price: price, day: day, daytime: $scope.thedaytime });
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
		}
		setTimeout(() => {
			document.location.reload();
		}, 500);
		
	}
	
	$scope.myClickenter = () => {
		let enterid = $("#enterid").val();
		let entercount = $("#entercount").val();
		if (enterid != "" && entercount != "") {
			$.post("enter", { count: entercount, id: enterid });
		}
		setTimeout(() => {
			document.location.reload();
		}, 500);
		
	}
	
	
});

$(document).ready(function () {
var time = new Date();
var day = ("0" + time.getDate()).slice(-2);
var month = ("0" + (time.getMonth() + 1)).slice(-2);
var today = time.getFullYear() + "-" + (month) + "-" + (day);
$('#day').val(today);
})




















