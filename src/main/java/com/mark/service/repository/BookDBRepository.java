package com.mark.service.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.mark.domain.Book;
import com.mark.util.JSONUtil;



@Transactional(SUPPORTS)
@Default
public class BookDBRepository implements BookRepository {
	
	private static final Logger LOGGER = Logger.getLogger(BookDBRepository.class);
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;
	

	public String findAllBooks() {
		LOGGER.info("BookDBRepository getAllBooks");
		Query query = manager.createQuery("Select a FROM Book a");
		Collection<Book> books = (Collection<Book>) query.getResultList();
		return util.getJSONForObject(books);
		
	}

	public String findBook(Long id) {
		LOGGER.info("BooktDBRepository findBook");
		Book book = manager.find(Book.class, id);
		return util.getJSONForObject(book);
		
	}

	@Transactional(REQUIRED)
	public String createBook(String book) {
		LOGGER.info("BookDBRepository createBook");
		Book newBook = util.getObjectForJSON(book, Book.class);
		manager.persist(newBook);
		return "{\"message\": \"Book has been sucessfully added\"}";
	}

	
	@Transactional(REQUIRED)
	public String deleteBook(Long id) {
		LOGGER.info("BookDBRepository deleteBook");
		Book bookInDB = findBK(id);
		if (bookInDB != null) {
			manager.remove(bookInDB);
			return "{\"message\": \"book sucessfully deleted\"}";
		}
		return "{\"message\": \"Book not found\"}";
	}
	
	@Transactional(REQUIRED)
	public String updateBook(String bookToUpdate) {
		Book updatedBook = util.getObjectForJSON(bookToUpdate, Book.class); 
		Book bookFromDB = findBK(updatedBook.getId());
		if (updatedBook != null) {
			bookFromDB = updatedBook;
			manager.merge(bookFromDB);
		}
		return "{\"message\": \"book sucessfully updated\"}";
	}
	
	private Book findBK(Long id) {
		LOGGER.info("BookDBRepository findBK");
		return manager.find(Book.class, id);
	}
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

	
	
	
	
	

}
