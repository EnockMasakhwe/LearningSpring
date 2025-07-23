package com.eliarojr.job_app_backend.repository;

import com.eliarojr.job_app_backend.entity.Job;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class JobRepositoryTest {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Job job = Job.builder()
                .jobName("Quality Assurance")
                .jobDescription("Monitor product quality")
                .jobCode("JB-07")
                .techStack(Arrays.asList("QA", "Product Management"))
                .build();

        entityManager.persist(job);
    }

    @Test
    public void whenFindById_thenReturnDepartment(){
        Job job = jobRepository.findById(1L).get();
        assertEquals(job.getJobName(), "Quality Assurance");
    }
}