
angular.module('Home')
 
.controller('HomeController',
    
    function ($scope,$http,$location,$rootScope) {
		$http.get('resource').success(function(data) {
			$scope.greeting = data;
		})
    
		
		$scope.logout = function() {
			$http.post('logout', {}).success(function() {
				$rootScope.authenticated = false;
				$location.path("/");
			}).error(function(data) {
				console.log("Logout failed")
				$rootScope.authenticated = false;
			});
		}
});