package com.eliarojr.job_app_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long jobId;

    private String jobName;
    private String jobDescription;
    private String jobCode;

    @ElementCollection
    private List<String> techStack;

}
