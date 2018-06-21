"use strict";

(function () {


    function bookService (bookDal) {

        this.getbooks = function()
        {
        	return bookDal.getbooks();
        };

        this.deletebook = function(book)
        {
          return bookDal.deletebook(book);
        };

        this.savebook = function(book)
        {
          console.log("save book called in service");
          return bookDal.savebook(book);
        };

        this.updatebook = function(book)
        {
           console.log("updatebook called in service");
          return bookDal.updatebook(book);
        };



    }

    angular.module("bookApp").service("bookService", ['bookDal', bookService]);

}());
