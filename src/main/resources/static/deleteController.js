var delVar=angular.module('MyFirstApp');

delVar.controller('delete', function($http,$scope){
    $scope.link = 'http://localhost:8080/books';
    $scope.deleteBook= function(id) {
        var fullLink = $scope.link + "/" +id;
        var result = $http.delete(fullLink);
        result.success(function(data, status, headers, config){
            $scope.message = data;
        });
        result.error(function(data, status, headers, config){
            alert( "failure message: " + JSON.stringify({data: data}));
        });
    }
});
