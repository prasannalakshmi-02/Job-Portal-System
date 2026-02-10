package com.prasanna.Job_Portal_System.repository;

import com.prasanna.Job_Portal_System.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

       List<Application> findByCandidateId(Long id);
       List<Application> findByJobPostId(Long id);
}
