// declare modules
angular.module('Authentication', []);
angular.module('Home', []);

angular.module('BasicHttpAuthExample', [
    'Authentication',
    'Home',
    'ngRoute',
    'ngCookies'
])
 
.config(['$routeProvider', function ($routeProvider) {

    $routeProvider
        .when('/login', {
            controller: 'LoginController',
            templateUrl: 'js/modules/authentication/views/login.html',
          })
 
        .when('/', {
            controller: 'HomeController',
            templateUrl: 'js/modules/home/views/home.html'
        })
 
        .otherwise('/');
}]);
