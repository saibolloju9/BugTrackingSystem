package com.project.bugtrackingsystem.dto;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// Data Transfer Object (DTO) for TestEngineer entity, extends UserDTO
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TestEngineerDTO extends UserDTO {

    // Name of the test engineer (not blank validation)
    @NotBlank(message = "name cannot be blank")
    private String testerName;

    // Skill set of the test engineer (not blank validation)
    @NotBlank(message = "skill cannot be blank")
    private String testerSkill;
}