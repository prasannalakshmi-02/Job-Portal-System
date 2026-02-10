package com.prasanna.Job_Portal_System.controller;

import com.prasanna.Job_Portal_System.entity.JobPost;
import com.prasanna.Job_Portal_System.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobPostController {

    @Autowired
    private JobService jobService;

    @PostMapping("/employer/{employerId}")
    public ResponseEntity<JobPost> postJob(@RequestBody JobPost job, @PathVariable Long employerId){
         JobPost savedJob = jobService.postJob(job, employerId);
         return new ResponseEntity<>(savedJob, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<JobPost>> getAllJobs(){
        return ResponseEntity.ok(jobService.getAllJobs());
    }

    @GetMapping("/employer/{id}")
    public ResponseEntity<List<JobPost>> getJobsByEmployer(@PathVariable Long id){
        return ResponseEntity.ok(jobService.getJobsByEmployer(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobPost> getJobById(@PathVariable Long id){
        return ResponseEntity.ok(jobService.getJobById(id));
    }
}
