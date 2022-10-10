package com.evc.applibrary.backend.models.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.List;


/**
 * The persistent class for the book database table.
 * 
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "bookId")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional = false)
	private Integer bookId;

	@Basic(optional = false)
    @NotNull
    @Size(min = 3, max = 128, message = "Book author must be between 3 and 128 characters")
	private String author;

	@Basic(optional = false)
	@NotNull
	@URL
	private String pdfBook; //registra la uri del libro en formato pdf

    @Basic(optional = false)
    @NotNull
    @Size(min = 10, max = 20, message = "ISBN must be between 10 and 20 characters")
	private String isbn;

    @Basic(optional = false)
    @NotNull
    @Size(min = 3, max = 64, message = "Book language must be between 3 and 64 characters")
	private String language;

    @Basic(optional = false)
    @NotNull
    @Size(min = 3, max = 64, message = "Book published must be between 3 and 64 characters")
	private String publisher;

    @Basic(optional = false)
    @NotNull
    @Size(min = 5, max = 128, message = "Book title must be between 5 and 128 characters")
    private String title;

	//bi-directional many-to-one association to BookRequest
	@OneToMany(cascade = CascadeType.ALL, mappedBy="book")
	//@JsonManagedReference
	private List<BookRequest> bookrequests;

	public Book() {
	}

	public Book(Integer id) {
        this.bookId = id;
    }

	public Book(Integer id, String isbn, String title, String author, String publisher, String lang, String pdfBook) {
        this.bookId = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.language = lang;
        this.pdfBook = pdfBook;
    }

	public int getBookId() {
		return this.bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPdfBook() {
		return this.pdfBook;
	}

	public void setPdfBook(String pdfBook) {
		this.pdfBook = pdfBook;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getLanguage() {
		return this.language;
	}
    
	public void setLanguage(String language) {
		this.language = language;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<BookRequest> getBookrequests() {
		return this.bookrequests;
	}

	public void setBookrequests(List<BookRequest> bookrequests) {
		this.bookrequests = bookrequests;
	}

	public BookRequest addBookrequest(BookRequest bookrequest) {
		getBookrequests().add(bookrequest);
		bookrequest.setBook(this);

		return bookrequest;
	}

	public BookRequest removeBookrequest(BookRequest bookrequest) {
		getBookrequests().remove(bookrequest);
		bookrequest.setBook(null);

		return bookrequest;
	}

}