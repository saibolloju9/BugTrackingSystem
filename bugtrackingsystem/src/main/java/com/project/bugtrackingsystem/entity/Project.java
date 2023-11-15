package com.project.bugtrackingsystem.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.Serializable;
import java.util.List;

// Represents a Project entity in the bug tracking system
@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "projects")
public class Project implements Serializable {

    // Primary key for the Project entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "proj_id")
    private Integer projId;

    // Name of the project
    @Column(name = "proj_name")
    private String projName;

    // Description of the project
    @Column(name = "project_description")
    private String projectDescription;

    // Status of the project
    @Column(name = "proj_status")
    private String projStatus;

    // Many-to-Many relationship with users, representing users associated with the project
    @ManyToMany(mappedBy = "projects")
    @JsonIgnore
    private List<User> users;
}