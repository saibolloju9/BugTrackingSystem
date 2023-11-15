package com.project.bugtrackingsystem.service;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.bugtrackingsystem.dto.DeveloperDTO;
import com.project.bugtrackingsystem.dto.ProjectDTO;
import com.project.bugtrackingsystem.dto.TestEngineerDTO;
import com.project.bugtrackingsystem.entity.Project;
import com.project.bugtrackingsystem.entity.User;
import com.project.bugtrackingsystem.repository.ProjectRepository;
import org.modelmapper.ModelMapper;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {

    @Mock
    private ProjectRepository projectRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private ProjectServiceImpl projectService;

    @Test
    void testCreateProject() {
        // Arrange
        ProjectDTO projectDTO = new ProjectDTO();
        Project projectEntity = new Project();
        when(modelMapper.map(projectDTO, Project.class)).thenReturn(projectEntity);
        when(projectRepository.save(projectEntity)).thenReturn(projectEntity);
        when(modelMapper.map(projectEntity, ProjectDTO.class)).thenReturn(projectDTO);

        // Act
        ProjectDTO result = projectService.createProject(projectDTO);

        // Assert
        assertEquals(projectDTO, result);
        verify(modelMapper).map(projectDTO, Project.class);
        verify(projectRepository).save(projectEntity);
        verify(modelMapper).map(projectEntity, ProjectDTO.class);
    }

    @Test
    void testGetProjectById() {
        // Arrange
        int projId = 1;
        ProjectDTO projectDTO = new ProjectDTO();
        Project projectEntity = new Project();
        when(projectRepository.findById(projId)).thenReturn(Optional.of(projectEntity));
        when(modelMapper.map(projectEntity, ProjectDTO.class)).thenReturn(projectDTO);

        // Act
        ProjectDTO result = projectService.getProjectById(projId);

        // Assert
        assertEquals(projectDTO, result);
        verify(projectRepository).findById(projId);
        verify(modelMapper).map(projectEntity, ProjectDTO.class);
    }
}

