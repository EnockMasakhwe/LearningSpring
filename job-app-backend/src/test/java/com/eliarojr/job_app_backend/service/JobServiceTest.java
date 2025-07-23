package com.eliarojr.job_app_backend.service;

import com.eliarojr.job_app_backend.entity.Job;
import com.eliarojr.job_app_backend.error.JobNotFoundException;
import com.eliarojr.job_app_backend.repository.JobRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JobServiceTest {

    @Autowired
    private JobService jobService;

    @MockitoBean
    private JobRepository jobRepository;

    @BeforeEach
    void setUp() {
        Job job = Job.builder()
                .jobName("QA")
                .jobCode("JB-06")
                .jobDescription("Evaluate quality of products")
                .techStack(Arrays.asList("QA", "Product Management"))
                .jobId(1L)
                .build();

        Mockito.when(jobRepository.findByJobNameIgnoreCase("QA")).thenReturn(job);
    }

    @Test
    @DisplayName("Get data based on valid job name")
    public void whenValidJobName_thenJobShouldFound(){
        String jobName = "QA";
        Job found = jobService.fetchJobByName(jobName);

        assertEquals(jobName, found.getJobName());
    }

    @DisplayName("Get data based on valid job id")
    @Test
    public void whenValidJobId_thenJobShouldFound() throws JobNotFoundException {
        Long jobId = 1L;
        Job found = jobService.fetchJobById(jobId);

        assertEquals(jobId, found.getJobId());

    }


}