package com.prasanna.Job_Portal_System.service;

import com.prasanna.Job_Portal_System.entity.JobPost;
import com.prasanna.Job_Portal_System.entity.User;
import com.prasanna.Job_Portal_System.repository.JobPostRepository;
import com.prasanna.Job_Portal_System.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobServiceImpl implements JobService{

    @Autowired
    private JobPostRepository jobPostRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public JobPost postJob(JobPost job, Long employerId) {

        User employer = userRepository.findById(employerId)
                        .orElseThrow(()->new RuntimeException("Employer not found with id" + employerId));

        job.setEmployer(employer);
        job.setPostedDate(LocalDate.now());
        return jobPostRepository.save(job);
    }

    @Override
    public List<JobPost> getAllJobs() {
        return jobPostRepository.findAll();
    }

    @Override
    public List<JobPost> getJobsByEmployer(Long employerId) {
        return jobPostRepository.findByEmployerId(employerId);
    }

    @Override
    public JobPost getJobById(Long id) {
        return jobPostRepository.findById(id)
                .orElseThrow(()->new RuntimeException("JobPost is not found with id"+ id));
    }
}
