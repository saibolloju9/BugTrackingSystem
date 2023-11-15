package com.project.bugtrackingsystem.controller;

import com.project.bugtrackingsystem.dto.DeveloperDTO;
import com.project.bugtrackingsystem.service.DeveloperServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/developers")
public class DeveloperController {

    // Autowired service for Developer operations
    @Autowired
    private DeveloperServiceImpl developerService;

    // Endpoint to add a new Developer
    @PostMapping("/add")
    public DeveloperDTO addDeveloper(@RequestBody DeveloperDTO developer) {
        return developerService.addDeveloper(developer);
    }

    // Endpoint to get a Developer by their ID
    @GetMapping("/{devId}")
    public DeveloperDTO getDeveloperById(@PathVariable Integer devId) {
        return developerService.getDeveloperById(devId);
    }

    // Endpoint to retrieve all Developers using pagination
    @GetMapping("/all")
    public Page<DeveloperDTO> getAllDevelopers() {
        Pageable pageable = PageRequest.of(0, 10); // Example: Retrieve first 10 developers
        Page<DeveloperDTO> page = developerService.getAllDevelopers(pageable);
        return page;
    }

    // Endpoint to delete a Developer by their ID
    @DeleteMapping("/delete/{devId}")
    public void deleteDeveloper(@PathVariable Integer devId) {
        developerService.deleteDeveloper(devId);
        System.out.println("Developer with ID " + devId + " deleted successfully");
    }
}
