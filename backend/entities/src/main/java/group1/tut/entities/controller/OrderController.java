package group1.tut.entities.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import group1.tut.entities.models.Orders;
import group1.tut.entities.repository.OrderRepository;

@RestController
public class OrderController {
    @Autowired
    private OrderRepository or;   

    @CrossOrigin(origins = "*")
    @PostMapping("/addOrder")
    public ResponseEntity<Orders> addOrder(@RequestBody Orders orders) {
        Orders newOrders = new Orders(
            orders.getOrderNo(),
            orders.getIsPaid(),
            orders.getIsPicked(),
            orders.getIsDelivered(),
            orders.getTrackOrder()
        );

        or.save(newOrders);
        return ResponseEntity.ok(newOrders);
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/updateOrder")
    public ResponseEntity<Orders> payOrder(@RequestBody Orders orders) {
        Orders existingOrder = or.findById(orders.getId()).orElse(null);
        if (existingOrder != null) {
            existingOrder.setIsPaid(true);
            or.save(existingOrder);
            return ResponseEntity.ok(existingOrder);
        } else {
            return ResponseEntity.notFound().build();
        }  
        
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getAllOrders")
    public ResponseEntity<List<Orders>> getAllOrders() {
        return ResponseEntity.ok(or.findAll());
    }


    @CrossOrigin(origins = "*")
    @PostMapping("/pickOrder")
    public ResponseEntity<Orders> pickOrder(@RequestBody Orders order) {
        Orders existingOrder = or.findByOrderNo(order.getOrderNo()).orElse(null);
        if (existingOrder != null) {
            existingOrder.setIsPicked(true);
            or.save(existingOrder);
            return ResponseEntity.ok(existingOrder);
        } else {
            return ResponseEntity.notFound().build();
        }  
        
    }

    


    @CrossOrigin(origins = "*")
    @PostMapping("/deliverOrder")
    public ResponseEntity<Orders> deliverOrder(@RequestBody Orders order) {
        Orders existingOrder = or.findByOrderNo(order.getOrderNo()).orElse(null);
        if (existingOrder != null) {
            existingOrder.setIsDelivered(true);
            or.save(existingOrder);
            return ResponseEntity.ok(existingOrder);
        } else {
            return ResponseEntity.notFound().build();
        }  
        
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/trackOrders")
    public ResponseEntity<Orders> trackOrder(@RequestBody Orders order) {
        Orders existingOrder = or.findByOrderNo(order.getOrderNo()).orElse(null);
        if (existingOrder != null) {
            existingOrder.setTrackOrder(order.getTrackOrder());
            or.save(existingOrder);
            return ResponseEntity.ok(existingOrder);
        } else {
            return ResponseEntity.notFound().build();
        }  
        
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/updateTrackOrder")
    public ResponseEntity<Orders> updateTrackOrder(@RequestBody Orders order) {
        Orders existingOrder = or.findById(order.getId()).orElse(null);
        if (existingOrder != null) {
            existingOrder.setTrackOrder(order.getTrackOrder());
            or.save(existingOrder);
            return ResponseEntity.ok(existingOrder);
        } else {
            return ResponseEntity.notFound().build();
        }  
        
    }
    
}
