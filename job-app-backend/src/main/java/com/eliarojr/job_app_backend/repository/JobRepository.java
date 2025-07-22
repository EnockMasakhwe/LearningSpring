package com.eliarojr.job_app_backend.repository;

import com.eliarojr.job_app_backend.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository <Job, Long> {

    public Job findByJobNameIgnoreCase(String jobName);

}
