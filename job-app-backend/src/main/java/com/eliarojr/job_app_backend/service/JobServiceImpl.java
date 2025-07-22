package com.eliarojr.job_app_backend.service;

import com.eliarojr.job_app_backend.entity.Job;
import com.eliarojr.job_app_backend.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService{

    @Autowired
    private JobRepository jobRepository;
    @Override
    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public List<Job> fetchJobList() {
        return jobRepository.findAll();
    }
}
