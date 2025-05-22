package group1.tut.entities.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import group1.tut.entities.models.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {
    Optional<Orders> findByOrderNo(String orderNo);
    // Custom query methods can be defined here if needed
    // For example, you can add methods to find orders by customer ID, status, etc.
    
}
