package com.prasanna.Job_Portal_System.controller;

import com.prasanna.Job_Portal_System.entity.Application;
import com.prasanna.Job_Portal_System.entity.JobPost;
import com.prasanna.Job_Portal_System.entity.User;
import com.prasanna.Job_Portal_System.repository.JobPostRepository;
import com.prasanna.Job_Portal_System.repository.UserRepository;
import com.prasanna.Job_Portal_System.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JobPostRepository jobPostRepository;

    @PostMapping("/apply")
    public ResponseEntity<?> applyForJob(@RequestParam("candidateId") Long candidateId,
                                         @RequestParam("jobId") Long jobId,
                                         @RequestParam("resume") MultipartFile resume){


        User candidate = userRepository.findById(candidateId)
                .orElseThrow(() -> new RuntimeException("Candidate not found with ID: " + candidateId));

        JobPost jobPost = jobPostRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found with ID: " + jobId));

        Application application = new Application();
        application.setCandidate(candidate);
        application.setJobPost(jobPost);
        application.setAppliedDate(LocalDate.now());
        application.setStatus("Pending");

        applicationService.applyForJob(application, resume);

        return new ResponseEntity<>("Application Submitted Successfully!", HttpStatus.CREATED);

    }

    @GetMapping("/jobs/{jobId}")
    public ResponseEntity<List<Application>> getApplicationsForJob(@PathVariable Long jobId){
        return ResponseEntity.ok(applicationService.getApplicationsForJob(jobId));
    }

    @GetMapping("/candidate/{candidateId}")
    public ResponseEntity<List<Application>> getMyApplication(@PathVariable Long candidateId){
        return ResponseEntity.ok(applicationService.getMyApplications(candidateId));
    }

}
