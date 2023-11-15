package com.project.bugtrackingsystem.service;

import com.project.bugtrackingsystem.dto.BugDTO;
import com.project.bugtrackingsystem.util.BugStatus;
import com.project.bugtrackingsystem.util.Severity;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

// Service interface for Bug-related operations
public interface BugService {

    // Method to create a new bug
    public BugDTO createBug(BugDTO bugDTO);

    // Method to update an existing bug
    public BugDTO updateBug(BugDTO bugDTO);

    // Method to find a bug by its ID
    public BugDTO findBugById(Integer bugId);

    // Method to retrieve all bugs with pagination
    public Page<BugDTO> findAllBugs(Pageable pageable);

    // Method to find all bugs associated with a specific project
    public List<BugDTO> findAllBugsByProjectId(Integer projId);

    // Method to find bugs by status
    public List<BugDTO> findBugsByStatus(BugStatus status);

    // Method to find bugs by severity
    public List<BugDTO> findBugsBySeverity(Severity severity);
}
