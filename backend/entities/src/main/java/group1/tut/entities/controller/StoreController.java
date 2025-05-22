package group1.tut.entities.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import group1.tut.entities.models.Store;
import group1.tut.entities.repository.StoreRepository;

@RestController
public class StoreController {
    @Autowired
    private final StoreRepository sr;

    public StoreController(StoreRepository sr) {
        this.sr = sr;
    }
    // Add a new store
    @CrossOrigin(origins = "*")
    @PostMapping("/addStore")
    public ResponseEntity<Store> addStore(@RequestBody Store store) {
        sr.save(store);
        return ResponseEntity.ok(store);
    }
     @CrossOrigin(origins = "*")
    @PostMapping("/deleteStore")
    public ResponseEntity<String> deleteStore(@RequestBody Store store) {
        Store existingStore = sr.findByStorename(store.getStoreName()).orElse(null);
        if (existingStore != null) {
            sr.delete(existingStore);
            return ResponseEntity.ok("Store deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }  
    @CrossOrigin(origins = "*")
    @PostMapping("/updateStore")
    public ResponseEntity<Store> updateStore(@RequestBody Store store) {
        Store existingStore = sr.findByStorename(store.getStoreName()).orElse(null);
        if (existingStore != null) {
            existingStore.setStoreName(store.getStoreName());
            existingStore.setStoreLocation(store.getStoreLocation());
            existingStore.setStoreContact(store.getStoreContact());
            sr.save(existingStore);
            return ResponseEntity.ok(existingStore);
        } else {
            return ResponseEntity.notFound().build();
        }
    }   
    @CrossOrigin(origins = "*")
    @PostMapping("/getStore")
    public ResponseEntity<Store> getStore(@RequestBody Store store) {
        Store existingStore = sr.findByStoreName(store.getStoreName()).orElse(null);
        if (existingStore != null) {
            return ResponseEntity.ok(existingStore);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/getAllStores")
    public ResponseEntity<List<Store>> getAllStores() {
        return ResponseEntity.ok(sr.findAll());
    } 
    
}
