package com.poly.demo.Dao;

import java.util.List;

import com.poly.demo.Entity.Food;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDto {
	private Long user;
    private String address;
    private Double price;
    private String status;
    private List<Food> foodId;
    private String date;
    private int quantity;
    private String payment;
    private String note;
}
