var updVar=angular.module('MyFirstApp');

//updVar.controller('update', ['firstBookService', '$scope', '$http' ,function(firstBookService,$scope,$http){
updVar.controller('update', function($scope,$http){
    console.log('Controller update');
    $scope.link = 'http://localhost:8080/books';
    
    $scope.updateBook= function(id) {
       // var bookObject = firstBookService.getParams();
        var theTitle = $scope.name;
        var theAuthor = $scope.author;
        var fullLink = $scope.link + "/" + id + "?title=" + theTitle + "&author=" + theAuthor;
        var result = $http.put(fullLink);
        result.success(function(data, status, headers, config){
            $scope.message = data;
        });
        result.error(function(data, status, headers, config){
            alert( "failure message: " + JSON.stringify({data: data}));
        });
    }

    // $scope.updateWithService= function(id) {
    //     var bookObject = firstBookService.getParams();
    //     var theTitle = bookObject.title;
    //     var theAuthor = bookObject.author;
    //     var fullLink = $scope.link + "/" + id + "?title=" + theTitle + "&author=" + theAuthor;
    //     var result = $http.put(fullLink);
    //     result.success(function(data, status, headers, config){
    //         $scope.message = data;
    //     });
    //     result.error(function(data, status, headers, config){
    //         alert( "failure message: " + JSON.stringify({data: data}));
    //     });
    // }
});
