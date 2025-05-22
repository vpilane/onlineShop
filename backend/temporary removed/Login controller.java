package group1.tut.entities.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import group1.tut.entities.models.Login;
import group1.tut.entities.models.LoginRequest;
import group1.tut.entities.repository.LoginRepository;

@RestController
public class LoginController {

    @Autowired
    private LoginRepository lr; // Use Spring's dependency injection

    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public ResponseEntity<String> login(LoginRequest r) {
        // Check if the user exists
        List<Login> lists = lr.findAll();

        for (Login login : lists) {
            if (login.getUsername().equals(r.getUsername()) && login.getPassword().equals(r.getPassword())) {

                return ResponseEntity.ok("Login successful");
            }
        }

        // Return error response if no match is found
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
    }

    
    @CrossOrigin(origins = "*")
    @GetMapping("/getAlll")
    public ResponseEntity<List<Login>> getAll() {
        // Check if the user already exists

        return ResponseEntity.ok(lr.findAll());
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/updateLogin")   
    public ResponseEntity<Login> updateLogin(@RequestBody Login login) {
        List<Login> lists = lr.findAll();

        for (Login log : lists) {
            if (log.getUsername().equals(login.getUsername())) {
                log.setPassword(login.getPassword());
                lr.save(log);
                return ResponseEntity.ok(log);
            }
        }

        // Return 404 if no match is found
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/deleteLogin")
    public ResponseEntity<String> deleteLogin(@RequestBody Login login) {
        List<Login> lists = lr.findAll();

        for (Login log : lists) {
            if (log.getUsername().equals(login.getUsername())) {
                lr.delete(log);
                return ResponseEntity.ok("Login deleted successfully");
            }
        }

        // Return 404 if no match is found
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Login not found");
    }
}
