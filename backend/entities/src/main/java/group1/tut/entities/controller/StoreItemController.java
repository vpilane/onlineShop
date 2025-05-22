package group1.tut.entities.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import group1.tut.entities.models.StoreItem;
import group1.tut.entities.repository.StoreItemRepository;

@RestController
public class StoreItemController {
     @Autowired
    private final StoreItemRepository sr;

    public StoreItemController(StoreItemRepository sr) {
        this.sr = sr;
    }   

    @CrossOrigin(origins = "*")
     @PostMapping("/addStoreItem")
     public ResponseEntity<StoreItem> addStoreItem(@RequestBody StoreItem storeItem) {
        sr.save(storeItem);
        return ResponseEntity.ok(storeItem);    
     }
     
    @CrossOrigin(origins = "*")
     @PostMapping("/getAllStoreItems")
     public ResponseEntity<List<StoreItem>> getAllStoreItems() {
        return ResponseEntity.ok(sr.findAll());
     }
     @CrossOrigin(origins = "*")
     @PostMapping("/subtractStoreItem")
     public ResponseEntity<StoreItem> subtractStoreItem(@RequestBody StoreItem storeItem) {
        List<StoreItem> lists = sr.findAll();
        for (StoreItem item : lists) {
            if (item.getName().equals(storeItem.getName())) {
                item.setQuantity(item.getQuantity() - storeItem.getQuantity());
                sr.save(item);
                return ResponseEntity.ok(item);
            }
        }
        return ResponseEntity.notFound().build();
     }
    @CrossOrigin(origins = "*")
    @PostMapping("/updateStoreItem")
        public ResponseEntity<StoreItem> updateStoreItem(@RequestBody StoreItem storeItem) {
            List<StoreItem> lists = sr.findAll();
            for (StoreItem item : lists) {
                if (item.getName().equals(storeItem.getName())) {
                    item.setPrice(storeItem.getPrice());
                    item.setQuantity(storeItem.getQuantity());
                    sr.save(item);
                    return ResponseEntity.ok(item);
                }
            }
            return ResponseEntity.notFound().build();
        }
    // Duplicate addStoreItem method removed to resolve compilation error.
}
