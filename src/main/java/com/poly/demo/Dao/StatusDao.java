package com.poly.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.demo.Entity.Status;

public interface StatusDao extends JpaRepository<Status, Long> {

}
