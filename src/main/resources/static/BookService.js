var tst=angular.module('MyFirstService',[]);

tst.service('firstBookService', function(){
    var bookObj ={id:null, title: "", author:""};

    function setParams(title,author){
        bookObj.title=title;
        bookObj.author=author;
    }

    function getParams (){
        return bookObj;
    }

    return {
        setParams: setParams,
        getParams: getParams
    };
});
