var getVar=angular.module('MyFirstApp');

getVar.controller('getBook', function($http,$scope){
    $scope.link = 'http://localhost:8080/books';
    $scope.getAllBooks= function() {
        $http.get($scope.link).then(function (response) {
                $scope.bookList = response.data;
            }, function (error) {
                console.log('Error: ' + error);
            }
        )
    }
});
