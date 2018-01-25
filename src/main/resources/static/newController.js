var newVar=angular.module('MyFirstApp');

newVar.controller('newController', ['newService', '$scope', function(newService, $scope){
        console.log('new controller');
       //var ctrl = this;
        var newObj = {
            "id" : 4,
            "title" : "Book4",
            "author" : "Auth4"
        }
        var secondPromise = newService.getFunction().then(function(data){
            console.log('first promise');
           //return newService.deleteFunction();
            return data;
           // $scope.items = data;
        }).catch(function(){
            alert('Error in the first promise');
        })

        secondPromise.then(function(dataNew){
                var newData = dataNew.concat(newObj);
                console.log('New obj = ' + newData);
                $scope.items=newData;
        }).catch(function(){
            alert('Error at get');
        })

        // var thirdPromise = secondPromise.then(function(){
        //     console.log('second promise');
        //     return newService.getFunction();
        // }).catch(function(){
        //     alert('Error in the second promise');
        // })
        //
        // thirdPromise.then(function(data){
        //     console.log('third promise' + data);
        //     $scope.items=data;
        // }).catch(function(data){
        //     alert('Error in the third promise' + data);
        // })
}]);
