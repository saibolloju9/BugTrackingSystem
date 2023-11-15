package com.project.bugtrackingsystem.repository;

import com.project.bugtrackingsystem.entity.Bug;
import com.project.bugtrackingsystem.util.BugStatus;
import com.project.bugtrackingsystem.util.Severity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

// Repository interface for Bug entity, extends JpaRepository for basic CRUD operations
@Repository
public interface BugRepository extends JpaRepository<Bug, Integer> {

    // Custom query to find bugs by project ID
    @Query("select b from Bug b where b.project.projId = ?1")
    List<Bug> findByProject(Integer projId);

    // Method to find bugs by status
    List<Bug> findByStatus(BugStatus status);

    // Method to find bugs by severity
    List<Bug> findBySeverity(Severity severity);
}