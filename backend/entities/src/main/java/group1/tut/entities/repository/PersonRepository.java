package group1.tut.entities.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import group1.tut.entities.models.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

    
}