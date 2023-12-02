package com.poly.demo.Controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.fasterxml.jackson.databind.JsonNode;
import com.poly.demo.Dao.UsersDao;
import com.poly.demo.Entity.Users;


@RestController
@RequestMapping("/api")
public class AdminUsersController {
	@Autowired
	UsersDao dao;
	
	@GetMapping("/user")
    public ResponseEntity<List<Users>> getListFood(){
        List<Users> users = dao.findAll();
        return ResponseEntity.ok(users);
	}
	@PostMapping("/create/user")
	public Users createBook(@RequestBody Users users) {
		System.out.println(users);
	   return dao.save(users);
	}
	@GetMapping("/user/{id}")
	public ResponseEntity<Users> getOne(@PathVariable("id") Long id){
		if (!dao.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(dao.findById(id).get());
	}
	@PutMapping("update/user/{id}")
	public Users update(@PathVariable("id")Integer id,@RequestBody Users users){
		return dao.save(users);
	}
	@DeleteMapping("/delete/user/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
	    dao.deleteById(id);
	    return ResponseEntity.noContent().build();
	}
	@PostMapping("/userlogin")
	public String login(@RequestBody JsonNode user) {
	    List<Users> users = dao.findAll();
//	    Users u = users.stream().filter(us->us.getUsername()==username ? true : false).findAny().get();
//	    if(u!=null) {
//	    	return "right";
//	    }else return "no";
//	    return u;
//		String userNameFromClient = username.get("username").asText();
//		Users u = users.stream().filter(us->us.getUsername().equals(userNameFromClient)).findAny().get();
//		System.out.println(username.get("username").asText());
//		System.err.println(u.getUsername());
	    for(int i = 0; i < users.size(); i++) {
	    	if(users.get(i).getUsername().equalsIgnoreCase(user.get("name").asText())) {
	    		return "dang nhap thanh cong";
	    	}
	    }
	    return "dang nhap that bai";
	}
}
