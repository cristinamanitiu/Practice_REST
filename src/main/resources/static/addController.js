var test=angular.module('MyFirstApp',[]);

test.controller('addBook', function($http,$scope){
    $scope.link = 'http://localhost:8080/books';
    $scope.addOneBook= function() {
        var dataObj = {
            title : $scope.name,
            author : $scope.author
        };
        var result = $http.post($scope.link,dataObj);
        result.success(function(data, status, headers, config){
            $scope.message = data;
        });
        result.error(function(data, status, headers, config){
            alert( "failure message: " + JSON.stringify({data: data}));
        });
    }
    $scope.name="";
    $scope.author="";
});