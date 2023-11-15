package com.project.bugtrackingsystem.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.Serializable;

// Represents a Test Engineer entity in the bug tracking system
@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
// Discriminator value for distinguishing TestEngineer type in an inheritance hierarchy
@DiscriminatorValue("TestEngineer")
public class TestEngineer extends User implements Serializable {

    // Name of the test engineer
    private String testerName;

    // Skill set of the test engineer
    private String testerSkill;
}