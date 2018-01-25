var dir=angular.module('MyFirstApp',['NewServiceModule']);

dir.directive('testDirective', function(){
    var val="directive";
    console.log(val);
    return{
        restrict:'E',
        replace: true,
        //template: '<p>Asa merge</p>',
        templateUrl: 'testare.html',
        controller: 'newController'
    }
});
