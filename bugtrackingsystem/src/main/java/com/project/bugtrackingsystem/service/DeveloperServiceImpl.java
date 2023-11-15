package com.project.bugtrackingsystem.service;

import com.project.bugtrackingsystem.dto.DeveloperDTO;
import com.project.bugtrackingsystem.entity.Developer;
import com.project.bugtrackingsystem.repository.DeveloperRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

// Service implementation for Developer-related operations
@Service
public class DeveloperServiceImpl implements DeveloperService {

    @Autowired
    private DeveloperRepository developerRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Method to add a new developer
    @Override
    public DeveloperDTO addDeveloper(DeveloperDTO developerDTO) {
        Developer developer = modelMapper.map(developerDTO, Developer.class);
        developer = developerRepository.save(developer);
        return modelMapper.map(developer, DeveloperDTO.class);
    }

    // Method to get a developer by ID
    @Override
    public DeveloperDTO getDeveloperById(Integer devId) {
        Developer developerEntity = developerRepository.findById(devId).orElse(null);
        if (developerEntity != null) {
            return modelMapper.map(developerEntity, DeveloperDTO.class);
        } else {
            return null; // Handle the case where the developer is not found
        }
    }

    // Method to retrieve all developers with pagination
    @Override
    public Page<DeveloperDTO> getAllDevelopers(Pageable pageable) {
        Page<Developer> developerEntities = developerRepository.findAll(pageable);
        Page<DeveloperDTO> developerDtoPage = developerEntities.map(dv -> modelMapper.map(dv, DeveloperDTO.class));
        return developerDtoPage;
    }

    // Method to delete a developer by ID
    @Override
    public void deleteDeveloper(Integer devId) {
        developerRepository.deleteById(devId);
    }
}
