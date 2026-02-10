package com.prasanna.Job_Portal_System.service;

import com.prasanna.Job_Portal_System.entity.Application;
import com.prasanna.Job_Portal_System.entity.User;
import com.prasanna.Job_Portal_System.repository.ApplicationRepository;
import com.prasanna.Job_Portal_System.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService{


    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void applyForJob(Application application, MultipartFile resume) {


        try {
            String projectDir = System.getProperty("user.dir");
            String uploadDir = projectDir + File.separator + "uploads";
            File directory = new File(uploadDir);
            if (!directory.exists()) {
                boolean created = directory.mkdirs();
                if (!created) {
                    throw new RuntimeException("Could not create upload directory: " + uploadDir);
                }
            }

            String fileName = System.currentTimeMillis() + "_" + resume.getOriginalFilename();
            String filePath = uploadDir + File.separator + fileName;
            resume.transferTo(new File(filePath));
            User candidate = application.getCandidate();
            if (candidate != null) {
                candidate.setResumePath(filePath);
                userRepository.save(candidate);
            }
            applicationRepository.save(application);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to upload resume: " + e.getMessage());
        }
    }

    @Override
    public List<Application> getApplicationsForJob(Long jobId) {
        return applicationRepository.findByJobPostId(jobId);
    }

    @Override
    public List<Application> getMyApplications(Long candidateId) {
        return applicationRepository.findByCandidateId(candidateId);
    }
}
