var test=angular.module('MyFirstApp',['MyFirstService']);

test.controller('addBook', ['firstBookService', '$scope', '$http', function(firstBookService,$scope,$http){
    
    $scope.link = 'http://localhost:8080/books';
    firstBookService.setParams($scope.name,$scope.author);

    $scope.addOneBook= function() {
        var data = {
            "id":0,
            "title":$scope.name,
            "author":$scope.author
        };
        var result = $http.post($scope.link,data);
        result.success(function(data, status, headers, config){
            $scope.message = data;
        });
        result.error(function(data, status, headers, config){
            alert( "failure message: " + JSON.stringify({data: data}));
        });
    }
    $scope.name="";
    $scope.author="";
}]);