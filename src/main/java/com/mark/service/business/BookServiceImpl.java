package com.mark.service.business;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.mark.service.repository.BookRepository;


public class BookServiceImpl implements BookService{
	
	private static final Logger LOGGER = Logger.getLogger(BookService.class);

	
	@Inject
	private BookRepository repo;


	public String findAllBooks() {
		LOGGER.info("In BookServiceImpl findAllBooks ");
		return repo.findAllBooks();
	}

	public String findBook(Long id) {
		LOGGER.info("In BookServiceImpl findBook ");
		return repo.findBook(id);
	}

	public String createBook(String book) {
		LOGGER.info("In BookServiceImpl createBook ");
		return repo.createBook(book);
	}

	public String deleteBook(Long id) {
		LOGGER.info("In BookServiceImpl deleteBook ");
		return repo.deleteBook(id);

	}

}
