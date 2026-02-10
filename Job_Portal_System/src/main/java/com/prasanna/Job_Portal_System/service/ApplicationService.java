package com.prasanna.Job_Portal_System.service;

import com.prasanna.Job_Portal_System.entity.Application;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ApplicationService {

    void applyForJob(Application application, MultipartFile resume);

    List<Application> getApplicationsForJob(Long jobId);

    List<Application> getMyApplications(Long candidateId);
}
