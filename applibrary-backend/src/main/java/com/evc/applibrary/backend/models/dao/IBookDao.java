package com.evc.applibrary.backend.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evc.applibrary.backend.models.entity.Book;


public interface IBookDao extends JpaRepository<Book, Integer> {

}
