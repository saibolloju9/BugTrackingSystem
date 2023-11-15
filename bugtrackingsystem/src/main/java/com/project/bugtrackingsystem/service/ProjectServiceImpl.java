package com.project.bugtrackingsystem.service;

import com.project.bugtrackingsystem.dto.ProjectDTO;
import com.project.bugtrackingsystem.entity.Project;
import com.project.bugtrackingsystem.exception.ProjectException;
import com.project.bugtrackingsystem.repository.ProjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

// Service implementation for Project-related operations
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Method to create a new project
    @Override
    public ProjectDTO createProject(ProjectDTO projDTO) {
        Project project = modelMapper.map(projDTO, Project.class);
        project = projectRepository.save(project);
        return modelMapper.map(project, ProjectDTO.class);
    }

    // Method to get a project by ID
    @Override
    public ProjectDTO getProjectById(Integer projId) {
        Project projectEntity = projectRepository.findById(projId).orElse(null);
        if (projectEntity != null) {
            return modelMapper.map(projectEntity, ProjectDTO.class);
        } else {
            // If the project is not found, throw a ProjectException or handle it accordingly
            throw new ProjectException("Project not found with id " + projId);
        }
    }

    // Method to retrieve all projects with pagination
    @Override
    public Page<ProjectDTO> getAllProjects(Pageable pageable) {
        Page<Project> projectEntities = projectRepository.findAll(pageable);
        Page<ProjectDTO> projectDtoPage = projectEntities.map(pj -> modelMapper.map(pj, ProjectDTO.class));
        return projectDtoPage;
    }
}
