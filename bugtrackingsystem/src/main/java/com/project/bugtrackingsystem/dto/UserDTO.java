package com.project.bugtrackingsystem.dto;

import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// Data Transfer Object (DTO) for User entity
@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO implements Serializable {

    // Unique identifier for the user
    private Integer userId;

    // Name of the user (not blank validation)
    @NotBlank(message = "name cannot be blank")
    private String userName;

    // Password of the user (not blank validation, size between 6 and 10 characters)
    @NotBlank(message = "password cannot be blank")
    @Size(min = 6, max = 10)
    private String userPassword;

    // Email address of the user (not blank validation)
    @NotBlank(message = "email cannot be blank")
    private String userEmail;

    // Contact information of the user (not blank validation, size of 10 characters)
    @NotBlank(message = "contact cannot be blank")
    @Size(min = 10, max = 10)
    private String userContact;

    // Role of the user (not blank validation, must be either "Developer" or "TestEngineer")
    @NotBlank(message = "Role cannot be Blank")
    @Pattern(regexp = "(Developer|TestEngineer)$")
    private String userRole;

    // List of projects associated with the user
    private List<ProjectDTO> projects;
}