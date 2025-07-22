package com.eliarojr.job_app_backend.controller;

import com.eliarojr.job_app_backend.entity.Job;
import com.eliarojr.job_app_backend.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping("/jobs")
    public Job saveJob(@RequestBody Job job){
        return jobService.saveJob(job);
    }

    @GetMapping("/jobs")
    public List<Job> fetchJobList(){
        return jobService.fetchJobList();
    }
}
