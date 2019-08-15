package com.gpw.bootjpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gpw.bootjpa.model.User;

public interface UserDao extends JpaRepository<User, Long>{

}
