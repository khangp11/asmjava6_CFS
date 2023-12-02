package com.poly.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.demo.Entity.Users;

public interface UsersDao extends JpaRepository<Users, Long> {

}
