app = angular.module("admin-app",["ngRoute"]);

app.config(function ($routeProvider){
    $routeProvider
        .when("/product",{
            templateUrl:"/assets/adminn/product/index.html",
            controller:"product-ctrl"
        })
        .when("/authorize",{
            templateUrl:"/assets/adminn/authority/index.html",
            controller:"authority-ctrl"
        })
        .when("/unauthorized",{
            templateUrl:"/assets/adminn/authority/unauthorized.html",
            controller:"authority-ctrl"
        })
        .otherwise({
            template: "<h1 class='text-center'>FPT Polytechnic Administration</h1>> "
        })
})