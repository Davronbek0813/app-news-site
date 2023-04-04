package com.example.appnewssite.repository;

import com.example.appnewssite.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);
}
