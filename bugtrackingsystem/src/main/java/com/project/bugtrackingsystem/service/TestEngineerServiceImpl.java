package com.project.bugtrackingsystem.service;

import com.project.bugtrackingsystem.dto.TestEngineerDTO;
import com.project.bugtrackingsystem.entity.TestEngineer;
import com.project.bugtrackingsystem.repository.TestEngineerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TestEngineerServiceImpl implements TestEngineerService {

    @Autowired
    private TestEngineerRepository testEngineerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    // Method to add a new test engineer
    public TestEngineerDTO addTestEngineer(TestEngineerDTO testEngineerDTO) {
        // Map the DTO to the entity, save to the repository, and return the saved entity as a DTO
        TestEngineer testEngineer = modelMapper.map(testEngineerDTO, TestEngineer.class);
        testEngineer = testEngineerRepository.save(testEngineer);
        return modelMapper.map(testEngineer, TestEngineerDTO.class);
    }

    @Override
    // Method to update an existing test engineer
    public TestEngineerDTO updateTestEngineer(TestEngineerDTO testEngineerDTO) {
        // Retrieve the existing test engineer entity by ID
        TestEngineer existingTestEngineerEntity = testEngineerRepository.findById(testEngineerDTO.getUserId()).orElse(null);

        if (existingTestEngineerEntity != null) {
            // Update the fields as needed
            existingTestEngineerEntity.setTesterName(testEngineerDTO.getTesterName());
            existingTestEngineerEntity.setUserEmail(testEngineerDTO.getUserEmail());

            // Save the updated entity to the repository and return it as a DTO
            existingTestEngineerEntity = testEngineerRepository.save(existingTestEngineerEntity);
            return modelMapper.map(existingTestEngineerEntity, TestEngineerDTO.class);
        } else {
            // Handle the case where the test engineer is not found
            return null;
        }
    }

    @Override
    // Method to retrieve a test engineer by ID
    public TestEngineerDTO getTestEngById(Integer testerId) {
        // Retrieve the test engineer entity by ID
        TestEngineer testEngineerEntity = testEngineerRepository.findById(testerId).orElse(null);

        if (testEngineerEntity != null) {
            // Map the entity to a DTO and return it
            return modelMapper.map(testEngineerEntity, TestEngineerDTO.class);
        } else {
            // Handle the case where the test engineer is not found
            return null;
        }
    }

    @Override
    // Method to retrieve all test engineers with pagination
    public Page<TestEngineerDTO> getAllTesters(Pageable pageable) {
        // Retrieve all test engineer entities with pagination
        Page<TestEngineer> testEngineerEntities = testEngineerRepository.findAll(pageable);

        // Map the entities to DTOs and return a page of DTOs
        Page<TestEngineerDTO> testEngineerDtoPage = testEngineerEntities.map(te -> modelMapper.map(te, TestEngineerDTO.class));
        return testEngineerDtoPage;
    }

    @Override
    // Method to delete a test engineer by ID
    public void deleteTestEngineer(Integer testerId) {
        // Delete the test engineer from the repository by ID
        testEngineerRepository.deleteById(testerId);
    }
}
