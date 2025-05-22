package group1.tut.entities.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import group1.tut.entities.models.CartItem;
import group1.tut.entities.repository.CartItemRepositoy;

public class CartItemController  {

    @Autowired
     CartItemRepositoy cr;
    // add cart item
    @CrossOrigin(origins = "*")
    @PostMapping("/addCartItem")
    public ResponseEntity<CartItem> addCartItemm(@RequestBody CartItem cartItem) {
        cr.save(cartItem);
        return ResponseEntity.ok(cartItem);
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/getAllCartItems")
    public ResponseEntity<List<CartItem>> getAllCartItems() {
        return ResponseEntity.ok(cr.findAll());
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/subtractCartItem")
    public ResponseEntity<CartItem> subtractCartItem(@RequestBody CartItem cartItem) {
        List<CartItem> lists = cr.findAll();
        for (CartItem item : lists) {
            if (item.getName().equals(cartItem.getName())) {
                item.setQuantity(item.getQuantity() - cartItem.getQuantity());
                cr.save(item);
                return ResponseEntity.ok(item);
            }
        }
        return ResponseEntity.notFound().build();
    }   

}
