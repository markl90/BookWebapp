"use strict";

(function() {

    var bookController =  function(bookService, $log) {

    	var vm = this;

        vm.isHidden = false;
        vm.showUpdate = false;

        vm.hideTable = function()
        {
        	vm.isHidden = !vm.isHidden
        };

        function init() {
        	bookService.getbooks().then(function (results) {
           	vm.books = results;
           	$log.log("In the book controller the value of the result promise is ");
        	$log.log(JSON.stringify(vm.books));
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
       }

       vm.delete = function(book){
         bookService.deletebook(book);
         console.log("delete called in controller");
         location.reload();
       }

       vm.addBook = function(book){
         bookService.savebook(vm.tempData);
         console.log("save book called in controller");
         location.reload();

       }

       vm.updateBook = function(id){
         vm.update.id = id;
         bookService.updatebook(vm.update);
         console.log("updatebook called in controller");
         location.reload();
       }

       vm.tempData =  {'title': 'newbook', 'genre': 'fiction', 'yearPublished': '1990'};

       vm.update = {'id': 1, 'title': '', 'genre': '', 'yearPublished': ''};

       init();

    };

    angular.module('bookApp').controller('bookController', ['bookService','$log', bookController]);
}());
