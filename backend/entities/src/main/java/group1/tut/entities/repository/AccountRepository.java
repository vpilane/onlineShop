package group1.tut.entities.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import group1.tut.entities.models.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUsername(String username);
}

