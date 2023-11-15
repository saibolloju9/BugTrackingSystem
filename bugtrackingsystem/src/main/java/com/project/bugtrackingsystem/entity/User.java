package com.project.bugtrackingsystem.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// Represents a User entity in the bug tracking system
@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
// Single table inheritance strategy, where all subclasses share the same table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// Discriminator column to differentiate between subclasses in the hierarchy
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING, length = 20)
// Discriminator value for the base class User
@DiscriminatorValue("user_id")
@Table(name = "users")
public class User implements Serializable {

    // Primary key for the User entity
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id")
    private Integer userId;

    // Unique username for the user
    @Column(name = "username", unique = true)
    private String userName;

    // Password associated with the user
    @Column(name = "password")
    private String userPassword;

    // Email address of the user
    @Column(name = "email")
    private String userEmail;

    // Contact information for the user
    @Column(name = "user_contact")
    private String userContact;

    // Role of the user in the system
    @Column(name = "user_role")
    private String userRole;

    // Many-to-Many relationship with projects, representing projects associated with the user
    @ManyToMany
    @JoinTable(name = "user_project",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "proj_id"))
    @JsonIgnore
    private List<Project> projects;
}
