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

import com.poly.demo.Dao.CategoryDao;
import com.poly.demo.Entity.Category;

@RestController
@RequestMapping("/api")
public class AdminCategoryController {
	@Autowired
	CategoryDao dao;
	
	@GetMapping("/category")
    public ResponseEntity<List<Category>> getListFood(){
        List<Category> category = dao.findAll();
        return ResponseEntity.ok(category);
	}
	@PostMapping("/create/category")
	public Category createBook(@RequestBody Category category) {
		System.out.println(category);
	   return dao.save(category);
	}
	@GetMapping("/category/{id}")
	public ResponseEntity<Category> getOne(@PathVariable("id") Integer id){
		if (!dao.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(dao.findById(id).get());
	}
	@PutMapping("/update/category/{id}")
	public Category update(@PathVariable("id")Integer id,@RequestBody Category category){
		return dao.save(category);
	}
	@DeleteMapping("/delete/category/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
	    dao.deleteById(id);
	    return ResponseEntity.noContent().build();
	}
}
