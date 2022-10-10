package com.evc.applibrary.backend.models.services;

import java.util.List;

import com.evc.applibrary.backend.models.entity.BookRequest;
import com.evc.applibrary.backend.models.services.exception.BookRequestAlreadyExists;
import com.evc.applibrary.backend.models.services.exception.BookRequestNotFound;

public interface IBookRequestManagerService {

	public BookRequest sendBookRequest(Integer bookId, Integer userId) throws BookRequestAlreadyExists;

	public void approveBookRequest(Integer bookRequestId) throws BookRequestNotFound;

	public void rejectBookRequest(Integer bookRequestId) throws BookRequestNotFound;

	public List<BookRequest> viewRequests();
	
	public List<BookRequest> viewRequestsByUser(Integer userId);

}
