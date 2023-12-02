package com.poly.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.demo.Entity.OrderDetail;

public interface OrderDetailDao extends JpaRepository<OrderDetail, Long> {

}
