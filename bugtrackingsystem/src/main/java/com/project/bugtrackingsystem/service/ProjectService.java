package com.project.bugtrackingsystem.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.project.bugtrackingsystem.dto.ProjectDTO;

// Service interface for Project-related operations
public interface ProjectService {

    // Method to create a new project
    ProjectDTO createProject(ProjectDTO projDTO);

    // Method to get a project by ID
    ProjectDTO getProjectById(Integer projId);

    // Method to retrieve all projects with pagination
    Page<ProjectDTO> getAllProjects(Pageable pageable);
}
