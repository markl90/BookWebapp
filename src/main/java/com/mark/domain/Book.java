package com.mark.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Book {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;
	@Size(min = 2, max = 80)
	private String title;
	@Size(min = 2, max = 80)
	private String genre;
	@Size(min = 2, max = 80)
	private String yearPublished;
	
	public Book() {}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getYearPublished() {
		return yearPublished;
	}
	public void setYearPublished(String yearPublished) {
		this.yearPublished = yearPublished;
	}
	
	
	
	
	

}
