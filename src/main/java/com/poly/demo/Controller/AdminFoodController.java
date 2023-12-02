package com.poly.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.demo.Dao.FoodDao;
import com.poly.demo.Entity.Food;


//@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class AdminFoodController {
	@Autowired
	FoodDao dao;
	
	@GetMapping("/food")
    public ResponseEntity<List<Food>> getListFood(){
        List<Food> foods = dao.findAll();
        return ResponseEntity.ok(foods);
	}
	@PostMapping("/create/food")
	public Food createFood(@RequestBody Food food) {
	   return dao.save(food);
	}
	@GetMapping("/food/{id}")
	public ResponseEntity<Food> getOne(@PathVariable("id") Long id){
		if (!dao.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(dao.findById(id).get());
	}
	@PutMapping("/update/food/{id}")
	public Food update(@PathVariable("id")Integer id,@RequestBody Food food){
		return dao.save(food);
	}
	@DeleteMapping("/delete/food/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
	    dao.deleteById(id);
	    return ResponseEntity.noContent().build();
	}
	 
}
