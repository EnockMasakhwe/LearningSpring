package com.eliarojr.job_app_backend.service;

import com.eliarojr.job_app_backend.entity.Job;
import com.eliarojr.job_app_backend.error.JobNotFoundException;

import java.util.List;

public interface JobService {
    public Job saveJob(Job job);

    public List<Job> fetchJobList();

    public Job fetchJobById(Long jobId) throws JobNotFoundException;

    public Job fetchJobByName(String jobName);

    public void deleteJob(Long jobId);

    public Job updateJob(Job job, Long jobId);
}
