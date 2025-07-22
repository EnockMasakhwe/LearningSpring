package com.eliarojr.job_app_backend.service;

import com.eliarojr.job_app_backend.entity.Job;
import com.eliarojr.job_app_backend.error.JobNotFoundException;
import com.eliarojr.job_app_backend.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    @Override
    public Job fetchJobById(Long jobId) throws JobNotFoundException {
        Optional<Job> job = jobRepository.findById(jobId);

        if (!job.isPresent()){
            throw new JobNotFoundException("Job not found!");
        }

        return job.get();
    }

    @Override
    public Job fetchJobByName(String jobName) {
        return jobRepository.findByJobNameIgnoreCase(jobName);
    }

    @Override
    public void deleteJob(Long jobId) {
        jobRepository.deleteById(jobId);
    }

    @Override
    public Job updateJob(Job job, Long jobId) {

        Job jobDB = jobRepository.findById(jobId).get();

        if(Objects.nonNull(job.getJobName()) &&
                !"".equalsIgnoreCase(job.getJobName())){
            jobDB.setJobName(job.getJobName());
        }
        if (Objects.nonNull(job.getJobCode()) &&
                !"".equalsIgnoreCase(job.getJobCode())){
            jobDB.setJobCode(job.getJobCode());
        }
        if (Objects.nonNull(job.getJobDescription()) &&
                !"".equalsIgnoreCase(job.getJobDescription())) {
            jobDB.setJobDescription(job.getJobDescription());
        }
        if (Objects.nonNull(job.getTechStack()) &&
                !"".equalsIgnoreCase(String.valueOf(job.getTechStack()))){
            jobDB.setTechStack(job.getTechStack());
        }

        return jobRepository.save(jobDB);
    }


}
