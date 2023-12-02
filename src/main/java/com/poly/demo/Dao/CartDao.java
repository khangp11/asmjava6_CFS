package com.poly.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.demo.Entity.Cart;


public interface CartDao extends JpaRepository<Cart,Long> {

}
