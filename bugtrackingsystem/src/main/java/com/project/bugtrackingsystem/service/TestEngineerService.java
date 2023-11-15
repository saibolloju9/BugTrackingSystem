package com.project.bugtrackingsystem.service;

import com.project.bugtrackingsystem.dto.TestEngineerDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

// Service interface for Test Engineer-related operations
public interface TestEngineerService {

    // Method to add a new test engineer
    TestEngineerDTO addTestEngineer(TestEngineerDTO testEngineer);

    // Method to update an existing test engineer
    TestEngineerDTO updateTestEngineer(TestEngineerDTO testEngineer);

    // Method to get a test engineer by ID
    TestEngineerDTO getTestEngById(Integer testerId);

    // Method to retrieve all test engineers with pagination
    Page<TestEngineerDTO> getAllTesters(Pageable pageable);

    // Method to delete a test engineer by ID
    void deleteTestEngineer(Integer testerId);
}
