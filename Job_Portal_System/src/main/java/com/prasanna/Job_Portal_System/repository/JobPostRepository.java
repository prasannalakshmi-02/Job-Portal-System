package com.prasanna.Job_Portal_System.repository;

import com.prasanna.Job_Portal_System.entity.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobPostRepository extends JpaRepository<JobPost, Long> {

    List<JobPost> findByEmployerId(Long id);

    List<JobPost> findByLocation(String location);

    List<JobPost> findByTitleContaining(String keyword);
}
