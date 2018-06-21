package com.mark.integration;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import com.mark.service.business.BookService;

@Path("/book")
public class BookEndpoint {
	
	private static final Logger LOGGER = Logger.getLogger(BookEndpoint.class);

	@Inject
	private BookService service;
	
	
	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String findAllBooks() {
		LOGGER.info("BookEndpoint + findAllBooks");
		return service.findAllBooks();
	}

	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String createBook(String book) {
		LOGGER.info("BookEndpoint + createBook");
		return service.createBook(book);
	}

	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteBook(@PathParam("id") Long id) {
		LOGGER.info("BookEndpoint + deleteBook");
		return service.deleteBook(id);

	}

	public void setService(BookService service) {
		LOGGER.info("BookEndpoint + setService");
		this.service = service;
	}
	
	@Path("/json")
	@PUT
	@Produces({ "application/json" })
	public String updateBook(String bookToUpdate) {
		return service.updateBook(bookToUpdate);
	}
	
	

}
