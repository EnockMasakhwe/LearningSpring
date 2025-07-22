package com.eliarojr.job_app_backend.service;

import com.eliarojr.job_app_backend.entity.Job;

import java.util.List;

public interface JobService {
    public Job saveJob(Job job);


    public List<Job> fetchJobList();
}
