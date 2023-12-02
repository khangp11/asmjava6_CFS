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

import com.poly.demo.Dao.CartDao;
import com.poly.demo.Entity.Cart;


@RestController
@RequestMapping("/api")
public class AdminCartController {
	@Autowired
	CartDao dao;
	
	@GetMapping("/cart")
    public ResponseEntity<List<Cart>> getListFood(){
        List<Cart> cart = dao.findAll();
        return ResponseEntity.ok(cart);
	}
	@PostMapping("/create/cart")
	public Cart createBook(@RequestBody Cart cart) {
	   return dao.save(cart);
	}
	@GetMapping("/cart/{id}")
	public ResponseEntity<Cart> getOne(@PathVariable("id") Long id){
		if (!dao.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(dao.findById(id).get());
	}
	@PutMapping("/update/cart/{id}")
	public Cart update(@PathVariable("id")Integer id,@RequestBody Cart cart){
		return dao.save(cart);
	}
	@DeleteMapping("/delete/cart/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
	    dao.deleteById(id);
	    return ResponseEntity.noContent().build();
	}
}
