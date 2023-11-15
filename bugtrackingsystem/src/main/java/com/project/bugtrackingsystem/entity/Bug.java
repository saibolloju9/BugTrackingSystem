package com.project.bugtrackingsystem.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.bugtrackingsystem.util.BugStatus;
import com.project.bugtrackingsystem.util.Severity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "bugs")
public class Bug implements Serializable {

    // Primary key for the Bug entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bug_id")
    private Integer bugId;

    // Title of the bug
    @Column(name = "bug_title")
    private String bugTitle;

    // Description of the bug
    @Column(name = "bug_description")
    private String bugDescription;

    // Severity of the bug (e.g., LOW, MEDIUM, HIGH)
    @Enumerated(EnumType.STRING)
    @Column(name = "severity")
    private Severity severity;

    // Test Engineer who created the bug
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "created_by_id", referencedColumnName = "user_id")
    private TestEngineer createdBy;

    // Developer to whom the bug is assigned
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "assign_to_id", referencedColumnName = "user_id")
    private Developer assignTo;

    // Status of the bug
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private BugStatus status;

    // Date when the bug was reported
    @Column(name = "start_date")
    private LocalDate startDate;

    // Date when the bug was last updated
    @Column(name = "last_updated_date")
    private LocalDate lastUpdatedDate;

    // Project to which the bug belongs
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "proj_id")
    private Project project;
}
