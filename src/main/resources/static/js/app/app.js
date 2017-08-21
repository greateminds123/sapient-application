var app= angular.module('sapientApp',['ui.router','ngStorage']);

app.constant('urls',{BASE: 'http://localhost:8080/SpringBootSapientApp',
    PRODUCT_SERVICE_API : 'http://localhost:8080/SpringBootSapientApp/api/product/'});

app.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
	 $stateProvider
     .state('home', {
         url: '/',
         templateUrl: 'partials/list',
         controller:'ProductController',
         controllerAs:'ctrl',
         resolve: {
             products: function ($q, ProductService){
            	 console.log('Load all products');
                 var deferred = $q.defer();
                 ProductService.loadAllProducts().then(deferred.resolve, deferred.resolve);
                 return deferred.promise;
            	 
             }
             }
     });
	 $urlRouterProvider.otherwise('/');
}]);