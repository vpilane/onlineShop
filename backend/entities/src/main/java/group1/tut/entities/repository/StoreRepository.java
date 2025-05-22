package group1.tut.entities.repository;

import group1.tut.entities.models.Store;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface  StoreRepository extends JpaRepository<Store, Long> {
    // Custom query methods can be defined here if needed       

    Optional<Store> findByStoreName(String storeName);
}
