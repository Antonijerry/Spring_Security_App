package com.Antoine.Jerry.Spring.Security.App.repository;

import com.Antoine.Jerry.Spring.Security.App.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
