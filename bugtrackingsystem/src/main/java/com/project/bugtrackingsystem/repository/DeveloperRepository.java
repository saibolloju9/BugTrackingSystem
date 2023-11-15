package com.project.bugtrackingsystem.repository;

import com.project.bugtrackingsystem.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repository interface for Developer entity, extends JpaRepository for basic CRUD operations
@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Integer> {
}
