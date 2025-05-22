package group1.tut.entities.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import group1.tut.entities.models.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {
  
    
}
