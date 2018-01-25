var ns=angular.module('NewServiceModule',[]);

ns.factory('newService', function($q,$http){
    console.log('new service');
     return{
         getFunction : getFunction,
         deleteFunction: deleteFunction
     }

    function getFunction(){
        var deferred = $q.defer();
        $http.get('http://localhost:8080/books').then(function(response){
                if(response.status == 200){
                    deferred.resolve(response.data);
                }else{
                    deferred.reject("Error =" + response.data);
                }
        })
        return deferred.promise;
    }

    function deleteFunction(){
        var deferred = $q.defer();
        $http.delete('http://localhost:8080/books/1').then(function(response){
            if(response.status == 200){
                deferred.resolve(response.data);
            }else{
                deferred.reject('Error = ' + response.data);
            }
        })
        return deferred.promise;
    }
})


