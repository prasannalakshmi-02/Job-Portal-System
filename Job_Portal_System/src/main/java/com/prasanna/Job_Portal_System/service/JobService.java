package com.prasanna.Job_Portal_System.service;

import com.prasanna.Job_Portal_System.entity.JobPost;

import java.util.List;

public interface JobService {

    JobPost postJob(JobPost job, Long employerId);

    List<JobPost> getAllJobs();

    List<JobPost> getJobsByEmployer(Long employerId);

    JobPost getJobById(Long id);
}
