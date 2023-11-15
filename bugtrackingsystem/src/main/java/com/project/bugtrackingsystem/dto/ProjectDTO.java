package com.project.bugtrackingsystem.dto;

import java.util.List;
import javax.validation.constraints.NotBlank;
import com.project.bugtrackingsystem.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// Data Transfer Object (DTO) for Project entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProjectDTO {

    // Unique identifier for the project
    private Integer projId;

    // Name of the project (not blank validation)
    @NotBlank(message = "name cannot be blank")
    private String projName;

    // Description of the project (not blank validation)
    @NotBlank(message = "description cannot be blank")
    private String projectDescription;

    // Status of the project (not blank validation)
    @NotBlank(message = "status cannot be blank")
    private String projStatus;

    // List of users associated with the project
    private List<User> users;
}