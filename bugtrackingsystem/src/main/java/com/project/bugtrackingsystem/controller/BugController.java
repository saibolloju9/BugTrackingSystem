package com.project.bugtrackingsystem.controller;

import com.project.bugtrackingsystem.dto.BugDTO;
import com.project.bugtrackingsystem.service.BugServiceImpl;
import com.project.bugtrackingsystem.util.BugStatus;
import com.project.bugtrackingsystem.util.Severity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import java.util.List;

@RestController
@RequestMapping("/bugs")
public class BugController {

    // Autowired service for Bug operations
    @Autowired
    private BugServiceImpl bugService;

    // Endpoint to create a new Bug
    @PostMapping("/create")
    public BugDTO createBug(@RequestBody BugDTO bugDTO) {
        return bugService.createBug(bugDTO);
    }

    // Endpoint to find a Bug by its ID
    @GetMapping("/{id}")
    public BugDTO findBugById(@PathVariable Integer id) {
        return bugService.findBugById(id);
    }

    // Endpoint to retrieve all Bugs using pagination
    @GetMapping("/all")
    public Page<BugDTO> findAllBugs() {
        Pageable pageable = PageRequest.of(0, 10); // Example: Retrieve first 10 bugs
        Page<BugDTO> page = bugService.findAllBugs(pageable);
        return page;
    }

    // Endpoint to find Bugs by Project ID
    @GetMapping("/byProject/{projectId}")
    public List<BugDTO> findBugsByProjectId(@PathVariable Integer projectId) {
        return bugService.findAllBugsByProjectId(projectId);
    }

    // Endpoint to find Bugs by BugStatus
    @GetMapping("/byStatus/{status}")
    public List<BugDTO> findBugsByStatus(@PathVariable BugStatus status) {
        return bugService.findBugsByStatus(status);
    }

    // Endpoint to find Bugs by Severity
    @GetMapping("/bySeverity/{severity}")
    public List<BugDTO> findBugsBySeverity(@PathVariable Severity severity) {
        return bugService.findBugsBySeverity(severity);
    }

    // Endpoint to update an existing Bug
    @PutMapping("/update")
    public BugDTO updateBug(@RequestBody BugDTO bugDTO) {
        return bugService.updateBug(bugDTO);
    }
}
