package com.prasanna.Job_Portal_System.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    private String password;

    private String name;

    private String role;

    // --- Employer Specific Fields ---
    private String companyWebsite;
    private String companyAddress;
    private boolean isVerified = false;

    // --- Candidate Specific Fields ---
    private String skills;
    private String resumePath;

    // --- Relationships ---

    // One Employer -> Many Jobs
    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<JobPost> jobPosts;

    // One Candidate -> Many Applications
    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Application> applications;
}
