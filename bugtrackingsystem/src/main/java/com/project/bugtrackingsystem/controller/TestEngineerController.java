package com.project.bugtrackingsystem.controller;

import com.project.bugtrackingsystem.dto.TestEngineerDTO;
import com.project.bugtrackingsystem.service.TestEngineerServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/testengineers")
public class TestEngineerController {

    // Autowired service for TestEngineer operations
    @Autowired
    private TestEngineerServiceImpl testEngineerService;

    // Endpoint to add a new TestEngineer
    @PostMapping("/add")
    public TestEngineerDTO addTestEngineer(@RequestBody TestEngineerDTO testEngineerDTO) {
        testEngineerDTO.setUserRole("TestEngineer"); // Set the user role to "TestEngineer"
        return testEngineerService.addTestEngineer(testEngineerDTO);
    }

    // Endpoint to get a TestEngineer by their ID
    @GetMapping("/{id}")
    public TestEngineerDTO getTestEngineerById(@PathVariable Integer id) {
        return testEngineerService.getTestEngById(id);
    }

    // Endpoint to retrieve all TestEngineers using pagination
    @GetMapping("/all")
    public Page<TestEngineerDTO> getAllTestEngineers() {
        Pageable pageable = PageRequest.of(0, 10); // Example: Retrieve first 10 test engineers
        Page<TestEngineerDTO> page = testEngineerService.getAllTesters(pageable);
        return page;
    }

    // Endpoint to delete a TestEngineer by their ID
    @DeleteMapping("/delete/{testerId}")
    public void deleteTestEngineer(@PathVariable Integer testerId) {
        // Implement logic to delete the test engineer by id
        testEngineerService.deleteTestEngineer(testerId);
        System.out.println("Test engineer with ID " + testerId + " deleted successfully");
    }
}