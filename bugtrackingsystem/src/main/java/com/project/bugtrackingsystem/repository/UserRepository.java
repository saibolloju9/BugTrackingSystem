package com.project.bugtrackingsystem.repository;

import com.project.bugtrackingsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository interface for User entity, extends JpaRepository for basic CRUD operations
public interface UserRepository extends JpaRepository<User, Integer> {

    // Custom query method to find a user by username and password
    User findByUserNameAndUserPassword(String userName, String userPassword);
}
