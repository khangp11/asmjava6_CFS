package com.poly.demo.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poly.demo.Entity.Food;


@Repository
public interface FoodDao extends JpaRepository<Food, Long> {
	
}
