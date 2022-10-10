package com.evc.applibrary.backend.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.evc.applibrary.backend.models.entity.BookRequest;


public interface IBookRequestDao extends JpaRepository<BookRequest, Integer>{
	
	@Query("SELECT b FROM 	BookRequest b WHERE b.book.bookId = :bookId and b.user.userId = :userId")
    public BookRequest getBookRequestByUserIdAndBookId(Integer bookId, Integer userId);
	
	@Query("SELECT b FROM 	BookRequest b WHERE b.user.userId = :userId")
    public List<BookRequest> getBookRequestByUserId(Integer userId);
	

}

