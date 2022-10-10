package com.evc.applibrary.backend.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evc.applibrary.backend.models.dao.IBookDao;
import com.evc.applibrary.backend.models.entity.Book;

import com.evc.applibrary.backend.models.services.exception.BookAlreadyExists;
import com.evc.applibrary.backend.models.services.exception.BookNotFound;

@Service
public class BookManagerServiceImp implements IBookManagerService{
	@Autowired
	private IBookDao bookDao;
	
	@Override
	@Transactional(readOnly = true) //utilizar esta anotacion cuando los metodos en el dao no son los por default
	public Book getBookInformation(Integer bookId){
		return bookDao.findById(bookId).orElseThrow(()-> 
			new BookNotFound ("Libro no encontrado"));
	}

	@Override
	@Transactional
	public Book registerBook(Book book){
		Book existBook = bookDao.findById(book.getBookId()).orElse(null);
		if (existBook == null) {
			bookDao.save(book);
			return book;
		}		
		else throw new BookAlreadyExists("Libro ya registrado");		
	}

	@Override
	@Transactional
	public Book updateBook(Book book){
		Book existBook = bookDao.findById(book.getBookId()).orElse(null);
		if (existBook == null) throw new BookNotFound ("Libro no existe");
		else {
			existBook.setAuthor(book.getAuthor());
			existBook.setPdfBook(book.getPdfBook());
			existBook.setIsbn(book.getIsbn());
			existBook.setLanguage(book.getLanguage());
			existBook.setPublisher(book.getPublisher());
			existBook.setTitle(book.getTitle());
			bookDao.save(existBook);
			return existBook;
		}	
	}

	@Override
	@Transactional
	public void removeBook(Integer bookId){
		Book existBook = bookDao.findById(bookId).orElse(null);
		if (existBook ==null) throw new BookNotFound ("Libro no existe");
		else {
			bookDao.delete(existBook);
			bookDao.flush();
		}
	}

	@Override
	@Transactional(readOnly = true)  //esta anotacion se utiliza solo cuando no son parte del dao
	public List<Book> getAllBooks() {
		return (List<Book>) bookDao.findAll();
	}
}
