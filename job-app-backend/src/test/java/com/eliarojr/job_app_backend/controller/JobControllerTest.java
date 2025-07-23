package com.eliarojr.job_app_backend.controller;

import com.eliarojr.job_app_backend.entity.Job;
import com.eliarojr.job_app_backend.service.JobService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(JobController.class)
class JobControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private JobService jobService;

    private Job job;

    @BeforeEach
    void setUp() {
        Job job = Job.builder()
                .jobName("Data Analyst")
                .jobCode("JB-08")
                .jobDescription("Analyze and interpret data")
                .jobId(1L)
                .techStack(Arrays.asList("Python","Matlab","Data Science"))
                .build();
    }

    @Test
    void saveJob() throws Exception {
        Job inputJob = Job.builder()
                .jobName("Data Analyst")
                .jobCode("JB-08")
                .jobDescription("Analyze and interpret data")
                .techStack(Arrays.asList("Python","Database","Data Science"))
                .build();

        Mockito.when(jobService.saveJob(inputJob)).thenReturn(job);

        mockMvc.perform(post("/jobs")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"jobName\":\"Data Analyst\",\n" +
                        "    \"jobDescription\":\"Analyze and interpret data\",\n" +
                        "    \"jobCode\":\"JB-08\",\n" +
                        "    \"techStack\":[\"Python\",\"Database\",\"Data Science\"]\n" +
                        "}"))
                .andExpect(status().isOk());
    }

    @Test
    void fetchJobById() throws Exception {
        Mockito.when(jobService.fetchJobById(1L)).thenReturn(job);

        mockMvc.perform(get("/jobs/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.jobName").value(job.getJobName()));
    }
}