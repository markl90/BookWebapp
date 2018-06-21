package com.mark.service.business;

public interface BookService {
	
	public String findAllBooks();
	
	public String findBook(Long id);
	
	public String createBook(String book);
	
	public String deleteBook(Long id);
	
	public String updateBook(String bookToUpdate);


}
