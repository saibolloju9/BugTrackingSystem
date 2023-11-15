package com.project.bugtrackingsystem.service;

import com.project.bugtrackingsystem.dto.DeveloperDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

// Service interface for Developer-related operations
public interface DeveloperService {

    // Method to add a new developer
    DeveloperDTO addDeveloper(DeveloperDTO developer);

    // Method to delete a developer by ID
    void deleteDeveloper(Integer devId);

    // Method to get a developer by ID
    DeveloperDTO getDeveloperById(Integer devId);

    // Method to retrieve all developers with pagination
    Page<DeveloperDTO> getAllDevelopers(Pageable pageable);
}
