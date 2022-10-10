package com.evc.applibrary.backend.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evc.applibrary.backend.models.dao.IBookDao;
import com.evc.applibrary.backend.models.dao.IBookRequestDao;
import com.evc.applibrary.backend.models.dao.IUserDao;
import com.evc.applibrary.backend.models.entity.Book;
import com.evc.applibrary.backend.models.entity.BookRequest;
import com.evc.applibrary.backend.models.entity.Constants;
import com.evc.applibrary.backend.models.entity.User;
import com.evc.applibrary.backend.models.services.exception.BookNotFound;
import com.evc.applibrary.backend.models.services.exception.BookRequestAlreadyExists;
import com.evc.applibrary.backend.models.services.exception.BookRequestNotFound;
import com.evc.applibrary.backend.models.services.exception.UserNotFound;

@Service
public class BookRequestManagerServiceImp implements IBookRequestManagerService {
	@Autowired
	private IBookRequestDao bookRequestDao;
	@Autowired
	private IBookDao bookDao;
	@Autowired
	private IUserDao userDao;

	@Override
	public BookRequest sendBookRequest(Integer bookId, Integer userId) throws BookRequestAlreadyExists {
		BookRequest bookRequest = new BookRequest();
		BookRequest validBookRequest = bookRequestDao.getBookRequestByUserIdAndBookId(bookId, userId);

		if (validBookRequest != null)
			throw new BookRequestAlreadyExists("Solicitud de libro ya existe");

		else {
			Book existBook = bookDao.findById(bookId).orElse(null);
			User existUser = userDao.findById(userId).orElse(null);
			if (existBook != null) {
				if (existUser != null) {
					bookRequest.setBook(existBook);
					bookRequest.setUser(existUser);
					bookRequest.setRequestTime(System.currentTimeMillis());
					bookRequest.setStatus(Constants.PENDING_REQUEST); // pending status...
					bookRequestDao.save(bookRequest);

				}
				else throw new UserNotFound("El usuario no existe");
			}
			else throw new BookNotFound("Libro no existe");
			
		}
		return bookRequest;

	}

	@Override
	public void approveBookRequest(Integer bookRequestId) throws BookRequestNotFound {
		BookRequest updateBookRequest = bookRequestDao.findById(bookRequestId).orElse(null);
		if (updateBookRequest == null)
			throw new BookRequestNotFound("Solicitud de libro no existe");
		else {
			updateBookRequest.setStatus(Constants.APPROVED_REQUEST); // approved status
			updateBookRequest.setResponseTime(System.currentTimeMillis());

			bookRequestDao.save(updateBookRequest);
		}

	}

	@Override
	public void rejectBookRequest(Integer bookRequestId) throws BookRequestNotFound {
		BookRequest updateBookRequest = bookRequestDao.findById(bookRequestId).orElse(null);
		if (updateBookRequest == null)
			throw new BookRequestNotFound("Solicitud de libro no existe");
		else {
			updateBookRequest.setStatus(Constants.REJECTED_REQUEST); // rejected status
			updateBookRequest.setResponseTime(System.currentTimeMillis());
			;
			bookRequestDao.save(updateBookRequest);
		}
	}

	@Override
	public List<BookRequest> viewRequests() {

		return bookRequestDao.findAll();
	}

	@Override
	public List<BookRequest> viewRequestsByUser(Integer userId) {

		return bookRequestDao.getBookRequestByUserId(userId);

	}

}
