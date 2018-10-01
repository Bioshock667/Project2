    function plot(data) {
      let canvas = document.getElementById("pieCanvas");
      let ctx = canvas.getContext("2d");
      let colors = ["gray", "blue", "red", "green"];
      let total = 0;
      for(let i = 0; i < data.length; i++) {
        total += data[i].value;
      }
      let percentages = new Array(data.length);
      for(let i = 0; i < data.length; i++) {
        percentages[i] = data[i].value / total;
      }
      let start_angle = 0;
      let radius = 50;
      let origin_x = 100;
      let origin_y = 75;
      let totalCircum = 2 * Math.PI;
      let legend_x = 170;
      let legend_y = 50;
      for(let i = 0; i < percentages.length; i++) {
        let new_x = radius * Math.cos(start_angle);
        let new_y = radius * Math.sin(start_angle);
        let new_arc_length = totalCircum * percentages[i];
        ctx.fillStyle = colors[i];
        ctx.beginPath();
        ctx.moveTo(origin_x, origin_y);
        ctx.lineTo(origin_x + new_x, origin_y + new_y);
        ctx.arc(origin_x, origin_y, radius, start_angle, start_angle + new_arc_length);
        ctx.rect(legend_x, legend_y, 10, 10);
        ctx.strokeText(data[i].label,legend_x + 15, legend_y + 10);
        //ctx.stroke();
         ctx.fill();
         start_angle += new_arc_length;
         legend_y += 20;
      }
    }

var app = angular.module("MainApp", ["ngRoute", 'ngCookies', 'ngSanitize']);

app.config(function($routeProvider){
	$routeProvider.when("/login", {
		templateUrl:"html/login.html",
		controller:"loginHandler"
	}).when("/employee", {
		templateUrl:"html/employeeDashBoard.html",
		controller:"employeeHandler"
	}).when("/manager", {
		templateUrl:"html/managerDashBoard.html",
		controller:"managerHandler"
	}).when("/requests", {
		templateUrl:"html/request.html",
		controller:"requestHandler"
	}).when("/submitRequest", {
		templateUrl:"html/subRequest.html",
		controller:"submitRequest"
	}).when("/manage", {
		templateUrl:"html/manage.html",
		controller:"manageRequests"
	}).when("/account", {
		templateUrl:"html/account.html",
		controller:"accountHandler"
	});
	
});

app.directive('demoFileModel', function ($parse) {
    return {
        restrict: 'A', //the directive can be used as an attribute only

        /*
         link is a function that defines functionality of directive
         scope: scope associated with the element
         element: element on which this directive used
         attrs: key value pair of element attributes
         */
        link: function (scope, element, attrs) {
            var model = $parse(attrs.demoFileModel),
                modelSetter = model.assign; //define a setter for demoFileModel

            //Bind change event on the element
            element.bind('change', function () {
                //Call apply on scope, it checks for value changes and reflect them on UI
                scope.$apply(function () {
                    //set the model value
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
});

app.controller("MainCtrl", function($rootScope, $scope, $http, $location, $cookies, $sanitize) {
	$rootScope.showMessage = false;
	$rootScope.type = $cookies.get("type");
	$scope.logout = function() {
		$http.get("MainServlet/logout");
		$location.path("/login");
	}
	$rootScope.navItems = ["", "", "", ""];
	$rootScope.toggleNav = function(index) {
		for(let i = 0; i < $rootScope.navItems.length; i++) {
			if (i == index) 
				$rootScope.navItems[i] = "active";
			 else 
				$rootScope.navItems[i] = "";
		}
	}
	$rootScope.closeUp = function(id) {
		let image = document.getElementById("modalImage");
		image.src = "MainServlet/getImage?id=" + id;
		$("#exampleModal").modal("show");
	}
	$rootScope.handleFailure = function(response) {
		if(response == null) {
			return;
		}
		if (response.status == 500) {
        	$rootScope.displayError("Server exception thrown",response.data);
        }
		else if (response.status == 403) {
	    	$rootScope.displayError("403 Forbidden", response.data);
	    }
		else if (response.status == 401) {
			$location.path("/login");
		}
	}
	
	$rootScope.displayError = function(error_type, error_message) {
		$rootScope.error = error_type;
		$rootScope.error_message = $sanitize(error_message);
		$rootScope.showMessage = true;
	}
	$rootScope.hideMessage = function() {$rootScope.showMessage = false};
	$http.get("MainServlet/isloggedin").then(function success(response){
		if(response.data == "true") {
			$location.path("/"+$rootScope.type);
		}
		else {
			$cookies.remove("type");
			$rootScope.type = "login";
			$location.path("/login");
		}
	}, function error(response) {
		$rootScope.handleFailure(response);
	});
});

app.controller("loginHandler", function($rootScope, $cookies, $scope, $http, $location) {
	$http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";
	$rootScope.type = "login"
    $scope.validate = function() {
    	var data1 = {username: $scope.username, password: $scope.password}
        $http.post('MainServlet/login', data1).then(function success(response) {
			if(response.data == "success") {
				$rootScope.type = $cookies.get("type");
				$location.path("/"+$rootScope.type);
			} else {
				$rootScope.displayError("login failed", "bad username or password");
			}
		}, function failure(response) {
        	$rootScope.handleFailure(response);
        })
    }
});
app.controller("employeeHandler", function($rootScope, $scope, $http) {
	$rootScope.toggleNav(0);
	$scope.res_requests = [];
	$http.get("MainServlet/getRequests?field=status&value=APPROVED").then(function success(response) {
		if(response.data != null)
			$scope.res_requests = $scope.res_requests.concat(response.data);
			$scope.res_requests.sort(function(a, b){
				return a.id - b.id;
			})
	}, function failure(response){
		$rootScope.handleFailure(response);
	});
	$http.get("MainServlet/getRequests?field=status&value=REJECTED").then(function success(response) {
		if(response.data != null)
			$scope.res_requests = $scope.res_requests.concat(response.data);
			$scope.res_requests.sort(function(a, b){
				return a.id - b.id;
			})
	}, function failure(response){
		$rootScope.handleFailure(response);
	});
	if($scope.res_requests != null && $scope.res_requests != undefined)
	$scope.res_requests.sort(function(a, b){
		return a.id - b.id;
	})
});

app.controller("managerHandler", function($rootScope, $scope, $http) {
	$rootScope.toggleNav(0);
	$http.get("MainServlet/getReqStats").then(function success(response) {
		if(response.data != null)
			plot(response.data);
	}, function failure(response){
		$rootScope.handleFailure(response);
	});
	$http.get("MainServlet/getManagerStats").then(function success(response) {
		$scope.managers = response.data;
	}, function failure(response){
		$rootScope.handleFailure(response);
	});
});

app.controller("requestHandler", function($rootScope, $scope, $http){
	$rootScope.toggleNav(1);
	$http.get("MainServlet/getRequests").then(function success(response) {
		$scope.Requests = response.data;
	}, function failure(response){
		$rootScope.handleFailure(response);
	})
})

app.controller("submitRequest", function($rootScope, $scope, $location, $http){
		$scope.submitRequest = function() {
		$http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";
		let fileData = new FormData();
		fileData.append('amount', $scope.amount);
		fileData.append('reason', $scope.reason);
		if($scope.myFile != undefined)
			fileData.append('file', $scope.myFile);
		let data = {amount:$scope.amount, reason:$scope.reason, picture:$scope.myFile};
		$http.post("MainServlet/submitRequest", fileData, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        }).then(function success(response){
			$location.path("/requests");
		}, function failure(response){
        	$rootScope.handleFailure(response);
		});
	}
});

app.controller("manageRequests", function($rootScope, $scope, $http) {
	$rootScope.toggleNav(2);
	$scope.searchField = "";
	$scope.searchValue = "";
	$scope.getReqs = function() {
		let uri = "MainServlet/getAllRequests";
		if($scope.searchField != "" && $scope.searchValue != "") {
			uri = uri + "?field=" + $scope.searchField + "&value=" + $scope.searchValue;// + "&limit=10";
		}
//			else
//			uri = uri + "?limit=10";
		$http.get(uri).then(function success(response) {
			$scope.requests = response.data;
		}, function failure(response){
	    	$rootScope.handleFailure(response);
		})
	}
	$scope.getReqs();
	$scope.approve = function(id) {
		if(confirm("Do you wish to approve this request?")) {
		$http.get("MainServlet/approveRequest?id=" + id).then(function success(response){
			$scope.getReqs();
		}, function failure(response){
        	$rootScope.handleFailure(response);
		})
		}
	}
	
	$scope.deny = function(id) {
		let reason = prompt("Enter a reason if there is any.");
		$http.get("MainServlet/denyRequest?id=" + id + "&reason="+reason).then(function success(response){
			$scope.getReqs();
		}, function failure(response){
        	$rootScope.handleFailure(response);
		})
	}
	$scope.search = function() {
		$scope.searchField = $scope.field;
		$scope.searchValue = $scope.value;
		$scope.getReqs();
	}
	$scope.clear  = function() {
		$scope.searchField = "";
		$scope.searchValue = "";
		$scope.getReqs();
	}
	
	$http.get("MainServlet/getAllEmployees").then(function success(response){
		$scope.employees = response.data;
	}, function failure(response){
		$rootScope.handleFailure(response);
	});
});
app.controller("accountHandler", function($rootScope, $scope, $http) {
	$scope.password1 = "";
	$scope.password2 = "";
	$rootScope.toggleNav(3);
	$scope.refresh = function() {
		$http.get("MainServlet/getMyAccount").then(function success(response) {
			$scope.user = response.data;
		}, function failure(response) {
			$rootScope.handleFailure(response);
		})
	}
	$scope.updateUser = function() {
		
		if($scope.password1 != "" || $scope.password2 != "") {
			if($scope.password1 == $scope.password2) {
				$scope.user.password = $scope.password1;
			} else {
				return;
			}
		} else {
			$scope.user.password = null;
		}
		$http.post("MainServlet/updateUser", $scope.user).then(function success(response) {
		}, function failure(response) {
			$rootScope.handleFailure(response);
		})
	}
	$scope.refresh();
});