"use strict";

(function () {

    function bookDal (dal) {

        this.getbooks = function () {
            return dal.http.GET("/bookapp/rest/book/json");
        };

        this.savebook = function (bookToSave) {
          //  var input = JSON.stringify(bookToSave);
          //  console.log(input);
            console.log("save book called in bookdal");
            return dal.http.POST("/bookapp/rest/book/json", bookToSave);
        };

        this.updatebook = function (bookToUpdate) {
            return dal.http.PUT("/bookapp/rest/book/json", bookToUpdate);
        };

        this.deletebook = function (bookToDelete) {
            return dal.http.DELETE("/bookapp/rest/book/json/", bookToDelete);
        };
    }

    angular.module("bookApp").service("bookDal", ["dal", bookDal]);
}());
