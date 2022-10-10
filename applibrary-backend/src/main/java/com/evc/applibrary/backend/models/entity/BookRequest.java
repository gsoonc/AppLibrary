package com.evc.applibrary.backend.models.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * The persistent class for the bookrequest database table.
 * 
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "requestId")
@Table(name = "bookrequest")
public class BookRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer requestId;

	private long requestTime;

	private long responseTime;

	private int status;

	// bi-directional many-to-one association to Book

	@ManyToOne(optional = false)
	@JoinColumn(name = "BookId")
	// @JsonBackReference
	private Book book;

	// bi-directional many-to-one association to AppUser

	@ManyToOne(optional = false)
	@JoinColumn(name = "UserId")
	// @JsonBackReference
	private User user;

	public BookRequest() {
	}

	public BookRequest(Integer id) {
		this.requestId = id;
	}

	public BookRequest(Integer id, long requestTime, long responseTime, int status) {
		this.requestId = id;
		this.requestTime = requestTime;
		this.responseTime = responseTime;
		this.status = status;
	}

	public Integer getRequestId() {
		return this.requestId;
	}

	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}

	public long getRequestTime() {
		return this.requestTime;
	}

	public void setRequestTime(long requestTime) {
		this.requestTime = requestTime;
	}

	public long getResponseTime() {
		return this.responseTime;
	}

	public void setResponseTime(long responseTime) {
		this.responseTime = responseTime;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User appuser) {
		this.user = appuser;
	}

}