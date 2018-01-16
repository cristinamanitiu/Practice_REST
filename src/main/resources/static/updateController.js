var updVar=angular.module('MyFirstApp');

updVar.controller('update', function($http,$scope,$rootScope){
    $scope.link = 'http://localhost:8080/books';
    $scope.updateBook= function(id) {
        var theTitle = $rootScope.name;
        var theAuthor = $rootScope.author;
        var fullLink = $scope.link + "/" + id + "?title=" + theTitle + "&author=" + theAuthor;
        var result = $http.put(fullLink);
        result.success(function(data, status, headers, config){
            $scope.message = data;
        });
        result.error(function(data, status, headers, config){
            alert( "failure message: " + JSON.stringify({data: data}));
        });
    }
});
