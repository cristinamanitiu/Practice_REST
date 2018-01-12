var getVar=angular.module('app',[]);

getVar.controller('getBook', function($http,$scope){
    $scope.link = 'localhost:8080/books'
    $http.get($scope.link).then(function(response){
        $scope.bookList = response;
    },function (error){
        console.log('Error: '+error);
    }
    )
});
