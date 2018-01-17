var test=angular.module('MyFirstApp',['MyFirstService']);

test.controller('addBook', ['firstBookService', '$scope', '$http', function(firstBookService,$scope,$http){
    
    $scope.link = 'http://localhost:8080/books';

    $scope.addOneBook= function() {
        var data = {
            "id":0,
            "title":$scope.$parent.name,
            "author":$scope.$parent.author
        };
        var result = $http.post($scope.link,data);
        result.success(function(data, status, headers, config){
            $scope.message = data;
        });
        result.error(function(data, status, headers, config){
            alert( "failure message: " + JSON.stringify({data: data}));
        });
    }

    $scope.addWithService= function() {
        var data = {
            "id":0,
            "title":$scope.$parent.name,
            "author":$scope.$parent.author
        };
        firstBookService.setParams($scope.$parent.name,$scope.$parent.author);
        var result = $http.post($scope.link,data);
        result.success(function(data, status, headers, config){
            $scope.message = data;
        });
        result.error(function(data, status, headers, config){
            alert( "failure message: " + JSON.stringify({data: data}));
        });
    }
}]);