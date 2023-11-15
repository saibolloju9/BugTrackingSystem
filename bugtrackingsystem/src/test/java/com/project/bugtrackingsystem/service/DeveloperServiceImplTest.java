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
import com.project.bugtrackingsystem.entity.Developer;
import com.project.bugtrackingsystem.entity.Project;
import com.project.bugtrackingsystem.repository.DeveloperRepository;
import org.modelmapper.ModelMapper;

@ExtendWith(MockitoExtension.class)
class DeveloperServiceImplTest {

    @Mock
    private DeveloperRepository developerRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private DeveloperServiceImpl developerService;

    @Test
    void testAddDeveloper() {
        // Arrange
        DeveloperDTO developerDTO = new DeveloperDTO();
        Developer developerEntity = new Developer();
        when(modelMapper.map(developerDTO, Developer.class)).thenReturn(developerEntity);
        when(developerRepository.save(developerEntity)).thenReturn(developerEntity);
        when(modelMapper.map(developerEntity, DeveloperDTO.class)).thenReturn(developerDTO);

        // Act
        DeveloperDTO result = developerService.addDeveloper(developerDTO);

        // Assert
        assertEquals(developerDTO, result);
        verify(modelMapper).map(developerDTO, Developer.class);
        verify(developerRepository).save(developerEntity);
        verify(modelMapper).map(developerEntity, DeveloperDTO.class);
    }

    @Test
    void testGetDeveloperById() {
        // Arrange
        int devId = 1;
        DeveloperDTO developerDTO = new DeveloperDTO();
        Developer developerEntity = new Developer();
        when(modelMapper.map(devId, Developer.class)).thenReturn(developerEntity);
        when(developerRepository.findById(devId)).thenReturn(Optional.of(developerEntity));
        when(modelMapper.map(developerEntity, DeveloperDTO.class)).thenReturn(developerDTO);

        // Act
        DeveloperDTO result = developerService.getDeveloperById(devId);

        // Assert
        assertEquals(developerDTO, result);
        verify(modelMapper).map(devId, Developer.class);
        verify(developerRepository).findById(devId);
        verify(modelMapper).map(developerEntity, DeveloperDTO.class);
    }

    
}

