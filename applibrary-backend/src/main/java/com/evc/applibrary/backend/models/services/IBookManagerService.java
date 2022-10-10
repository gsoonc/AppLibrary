package com.evc.applibrary.backend.models.services;

import java.util.List;


import com.evc.applibrary.backend.models.entity.Book;

public interface IBookManagerService {
	public Book getBookInformation(Integer bookID);    
	 public Book registerBook(Book book);    
	 public Book updateBook(Book book);    
	 public void removeBook(Integer bookID);    
	 public List<Book> getAllBooks(); 
}
