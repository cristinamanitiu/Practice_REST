var test=angular.module('MyFirstApp',[]);

test.factory('Book', function () {
    var book = {}
});

test.controller('addBook', function($http,$scope,$rootScope){
    $scope.link = 'http://localhost:8080/books';
    $scope.addOneBook= function() {
        var data = {
            "id":0,
            "title":$scope.name,
            "author":$scope.author
        };
        $rootScope.name=$scope.name;
        $rootScope.author=$scope.author;
      // var parameter = JSON.parse(dataObj);
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
});