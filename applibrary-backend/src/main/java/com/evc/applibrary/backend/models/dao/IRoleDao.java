package com.evc.applibrary.backend.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evc.applibrary.backend.models.entity.Role;

public interface IRoleDao extends JpaRepository<Role, Integer>{

}
