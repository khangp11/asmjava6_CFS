package com.poly.demo.Dao;

import java.util.Date;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.demo.Entity.Order;


public interface OrderDao extends JpaRepository<Order, Long> {
//	List<Order> findByDateBetween(Date startDate, Date endDate);
//	List<Order> findByUserUsernameContainingIgnoreCase(String username);
//	List<Order> findByStatusIn(List<String> statusList);
	
	
//	@Query(value = "SELECT o.user.id AS userId, SUM(o.quantity) AS totalQuantityPurchased " +
//	        "FROM Order o " +
//	        "GROUP BY o.user.id " +
//	        "ORDER BY totalQuantityPurchased DESC")
//		List<Order> findBestSellingFood();
//
//	@Query(value = "SELECT TOP 5 food_id AS foodId, SUM(o.quantity) AS totalQuantitySold " +
//            "FROM [order] o " +
//            "JOIN food ON o.food_id = food.id " +
//            "GROUP BY food_id " +
//            "ORDER BY totalQuantitySold ASC", nativeQuery = true)
//		List<Order> findLowestSellingFood();

	
}	
