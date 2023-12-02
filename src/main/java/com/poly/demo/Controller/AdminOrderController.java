package com.poly.demo.Controller;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.poly.demo.Dao.FoodDao;
import com.poly.demo.Dao.OrderDao;
import com.poly.demo.Dao.OrderDetailDao;
import com.poly.demo.Dao.OrderRequestDto;
import com.poly.demo.Dao.UsersDao;
import com.poly.demo.Entity.Food;
import com.poly.demo.Entity.Order;
import com.poly.demo.Entity.OrderDetail;
import com.poly.demo.Entity.Users;

@RestController
@RequestMapping("/api")
public class AdminOrderController {
	@Autowired
	OrderDao orderdao;
	@Autowired
	UsersDao usersDao;
	@Autowired
	FoodDao foodDao;
	@Autowired
	OrderDetailDao orderDetailDao;
	
	@GetMapping("/order")
    public ResponseEntity<List<Order>> getListFood(){
        List<Order> order = orderdao.findAll();
        return ResponseEntity.ok(order);
	}
	@PostMapping("/create/order")
	public ResponseEntity<String> addOrder(@RequestBody OrderRequestDto orderRequest) {
	    try {
	        // Extract data from the DTO
	        Long userId = orderRequest.getUser();
	        String address = orderRequest.getAddress();
	        Double price = orderRequest.getPrice();
	        String status = orderRequest.getStatus();
	        Date date = new SimpleDateFormat("dd/MM/yyyy HH mm ss").parse(orderRequest.getDate());
	        int quantity = orderRequest.getQuantity();
	        String payment = orderRequest.getPayment();
	        String note = orderRequest.getNote();
	        List<Food> FoodID = orderRequest.getFoodId();
	        
	        
	        
	        OrderDetail orderDetail = new OrderDetail();
            orderDetail.setNote(note);
            orderDetail.setPayment(payment);
            orderDetail.setPrice(price);
            orderDetail.setStatus(status);
            orderDetailDao.save(orderDetail);
	                    
         
            
            System.out.println(FoodID);
            for (Food food : FoodID) {           
            	Users user = usersDao.findById(userId)
    	                .orElseThrow(() -> new RuntimeException("User not found"));
    	        Order order = new Order();
    	        order.setUser(user);
    	        order.setAddress(address);
    	        order.setDate(date);
    	        order.setQuantity(quantity);
    	        order.setOrderDetail(orderDetail);
    	        order.setFood(food);
    	        orderdao.save(order);
			}
	        	        
	        return ResponseEntity.ok("Order created successfully");
	    } catch (ParseException e) {
	        e.printStackTrace();
	        return ResponseEntity.badRequest().body("Invalid date format");
	    }
	}

	
//	@GetMapping("/order/{id}")
//	public ResponseEntity<Order> getOne(@PathVariable("id") Long id){
//		if (!orderdao.existsById(id)) {
//			return ResponseEntity.notFound().build();
//		}
//		return ResponseEntity.ok(orderdao.findById(id).get());
//	}
//	@PutMapping("update/order/{id}")
//	public Order update(@PathVariable("id")Integer id,@RequestBody Order order){
//		return orderdao.save(order);
//	}
	
//	
//	@PostMapping("/filter")
//	public ResponseEntity<List<Order>> filterByDate(
//	    @RequestParam("ngayBatDau") String ngaybatdau,
//	    @RequestParam("ngayKetThuc") String ngayketthuc
//	) throws ParseException {
//	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//	    Date startDate = sdf.parse(ngaybatdau);
//	    Date endDate = sdf.parse(ngayketthuc);
//
//	    List<Order> order = orderdao.findByDateBetween(startDate, endDate);
//	    return ResponseEntity.ok(order);
//	}

	
//	@PostMapping("/orders/search")
//	public ResponseEntity<List<Order>> searchOrdersByUserName(@RequestBody Map<String, String> requestData) {
//	    String username = requestData.get("username");
//	    List<Order> orders = orderdao.findByUserUsernameContainingIgnoreCase(username);
//	    return ResponseEntity.ok(orders);
//	}
//	@PostMapping("/orders/search/status")
//	public ResponseEntity<List<Order>> searchOrdersByStatus(@RequestBody Map<String, List<String>> requestData) {
//	    List<String> statusList = requestData.get("status");
//	    List<Order> orders = orderdao.findByStatusIn(statusList);
//	    return ResponseEntity.ok(orders);
//	}
//	@DeleteMapping("/delete/order/{id}")
//	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
//		orderdao.deleteById(id);
//	    return ResponseEntity.noContent().build();
//	}
//	@PostMapping("/order/search/bySale")
//    public ResponseEntity<List<Order>> searchOrders(@RequestBody Map<String, String> requestData) {
//        String orderBy = requestData.get("orderBy");
//        List<Order> orders;
//
//        if ("bestSelling".equals(orderBy)) {
//            orders = orderdao.findBestSellingFood();
//        } else if ("worstSelling".equals(orderBy)) {
//        	orders = orderdao.findLowestSellingFood();
//        } else {
//            orders = orderdao.findAll();
//        }
//        return ResponseEntity.ok(orders);
//    }


}
