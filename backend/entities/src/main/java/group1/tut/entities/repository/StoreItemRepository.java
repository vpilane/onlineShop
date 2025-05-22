package group1.tut.entities.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import group1.tut.entities.models.StoreItem;

public interface StoreItemRepository extends JpaRepository<StoreItem, Long> {
    
}
