package com.project.bugtrackingsystem.repository;

import com.project.bugtrackingsystem.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository interface for Project entity, extends JpaRepository for basic CRUD operations
public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
