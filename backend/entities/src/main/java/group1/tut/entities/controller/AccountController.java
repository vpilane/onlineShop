package group1.tut.entities.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import group1.tut.entities.models.Account;
import group1.tut.entities.repository.AccountRepository;



@RestController
public class AccountController {
    @Autowired
    private AccountRepository ar;

    // add account
    @CrossOrigin(origins = "*")
    @PostMapping("/addAccount")
    public ResponseEntity<Account> addAccount(@RequestBody Account account) {
        Account a = new Account();
        a.setName(account.getName());
        a.setSurname(account.getSurname());
        a.setGender(account.getGender());
        a.setContact(account.getContact());
        a.setAddress(account.getAddress());
        a.setUsername(account.getUsername());
        a.setPassword(account.getPassword());
        a.setRole(account.getRole());

      
        ar.save(a);
       
        return ResponseEntity.ok(a);
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/deleteAccount")
    public ResponseEntity<String> deleteAccount(@RequestBody Account account) {
        Account existingAccount = ar.findById(account.getId()).orElse(null);
        if (existingAccount != null) {
            ar.delete(existingAccount);
            return ResponseEntity.ok("Account deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/trackOrder")
    public ResponseEntity<String> trackOrder(@RequestBody Account account) {
       Account existingAccount = ar.findByUsername(account.getUsername()).orElse(null);
        if (existingAccount != null) {
            return ResponseEntity.ok(existingAccount.getTrackOrder());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/getAllAccounts")
    public ResponseEntity<List<Account>> getAllAccounts() {
        return ResponseEntity.ok(ar.findAll());
    }
   

    @CrossOrigin(origins = "*")
    @PostMapping("/updateAccount")
    public ResponseEntity<Account> updateAccount(@RequestBody Account account) {
        Account existingAccount = ar.findByUsername(account.getUsername()).orElse(null);
        if (existingAccount != null) {
            existingAccount.setOrderNo(account.getOrderNo());
            existingAccount.setTrackOrder(account.getTrackOrder());
            ar.save(existingAccount);
            return ResponseEntity.ok(existingAccount);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @CrossOrigin(origins = "*")
    @PostMapping("/login")  
    public ResponseEntity<Account> login(@RequestBody Account account) {
        List<Account> accounts = ar.findAll();
        for (Account acc : accounts) {
            if (acc.getUsername().equals(account.getUsername()) && acc.getPassword().equals(account.getPassword())) {
                return ResponseEntity.ok(acc);
            }
        }
        return ResponseEntity.notFound().build();
    }
    
    @CrossOrigin(origins = "*")
    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        // Implement logout logic here
        return ResponseEntity.ok("Logged out successfully");
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/getId")
    public ResponseEntity<Account> getId(@RequestBody Account account) {
        Account existingAccount = ar.findById(account.getId()).orElse(null);
        if (existingAccount != null) {
            return ResponseEntity.ok(existingAccount);
        } else {
            return ResponseEntity.notFound().build();
        }   
    }
}
