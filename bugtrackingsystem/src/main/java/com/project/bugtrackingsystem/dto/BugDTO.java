package com.project.bugtrackingsystem.dto;

import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.project.bugtrackingsystem.util.BugStatus;
import com.project.bugtrackingsystem.util.Severity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// Data Transfer Object (DTO) for Bug entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BugDTO {

    // Unique identifier for the bug
    private Integer bugId;

    // Title of the bug (not blank validation)
    @NotBlank(message = "title cannot be blank")
    private String bugTitle;

    // Description of the bug (not blank validation)
    @NotBlank(message = "description cannot be blank")
    private String bugDescription;

    // Severity of the bug (not blank validation)
    @NotBlank(message = "Severity cannot be blank")
    private Severity severity;

    // Test Engineer who created the bug (not blank validation)
    @NotBlank(message = "created by cannot be blank")
    private TestEngineerDTO createdBy;

    // Developer to whom the bug is assigned (not blank validation)
    @NotBlank(message = "Assign to cannot be blank")
    private DeveloperDTO assignTo;

    // Status of the bug (not blank validation)
    @NotBlank(message = "status cannot be blank")
    private BugStatus status;

    // Start date of the bug (not null validation)
    @NotNull
    private LocalDate startDate;

    // Last updated date of the bug (not null validation)
    @NotNull
    private LocalDate lastUpdatedDate;

    // Project to which the bug belongs
    private ProjectDTO project;
}
