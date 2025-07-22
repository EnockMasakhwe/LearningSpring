package com.eliarojr.job_app_backend.controller;

import com.eliarojr.job_app_backend.entity.Job;
import com.eliarojr.job_app_backend.error.JobNotFoundException;
import com.eliarojr.job_app_backend.service.JobService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class JobController {

    @Autowired
    private JobService jobService;

    private final Logger LOGGER = LoggerFactory.getLogger(JobController.class);

    @PostMapping("/jobs")
    public Job saveJob(@Valid @RequestBody Job job){
        LOGGER.info("Inside saveJob of JobController");
        return jobService.saveJob(job);
    }

    @GetMapping("/jobs")
    public List<Job> fetchJobList(){
        LOGGER.info("Inside fetchJobList of JobController");
        return jobService.fetchJobList();
    }

    @GetMapping("/jobs/{id}")
    public Job fetchJobById(@PathVariable("id") Long jobId) throws JobNotFoundException {
        LOGGER.info("Inside fetchJobById of JobController");
        return jobService.fetchJobById(jobId);
    }

    @GetMapping("/jobs/name/{name}")
    public Job fetchJobByName(@PathVariable("name") String jobName){
        LOGGER.info("Inside fetchJobByName of JobController");
        return jobService.fetchJobByName(jobName);
    }

    @DeleteMapping("/jobs/{id}")
    public String deleteJob(@PathVariable("id") Long jobId){
        jobService.deleteJob(jobId);
        LOGGER.info("Inside deleteJob of JobController");
        return "Job deleted successfully!";
    }

    @PutMapping("/jobs/{id}")
    public Job updateJob(@RequestBody Job job, @PathVariable("id") Long jobId){
        LOGGER.info("Inside updateJob of JobController");
        return jobService.updateJob(job, jobId);
    }
}
