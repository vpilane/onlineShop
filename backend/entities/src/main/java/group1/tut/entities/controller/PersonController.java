package group1.tut.entities.controller;

import org.springframework.web.bind.annotation.RestController;

import group1.tut.entities.models.Person;
import group1.tut.entities.repository.PersonRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
public class PersonController {
    @Autowired
private final PersonRepository pr;

    public PersonController(PersonRepository pr) {
        this.pr = pr;
    }

    // Add a new person

@CrossOrigin(origins = "*")
    @PostMapping("/person")
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        pr.save(person);
        return ResponseEntity.ok(person);
    }



    @GetMapping("/getAll")
    public List<Person> getAllPersons() {

        return pr.findAll();
    }
    

    
}
