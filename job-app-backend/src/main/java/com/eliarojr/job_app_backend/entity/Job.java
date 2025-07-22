package com.eliarojr.job_app_backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

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

    @NotBlank(message = "Please enter job title.")
    private String jobName;

    @Length(min = 5, max = 50, message = "Enter job description between 5-50 characters")
    private String jobDescription;
    private String jobCode;

    @ElementCollection
    private List<String> techStack;

}
