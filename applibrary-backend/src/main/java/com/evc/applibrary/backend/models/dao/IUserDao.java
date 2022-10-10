package com.evc.applibrary.backend.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evc.applibrary.backend.models.entity.User;

public interface IUserDao extends JpaRepository<User, Integer>{

}
