package com.eliarojr.spring_data_jpa_practice.repository;

import com.eliarojr.spring_data_jpa_practice.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository <Course, Long> {

    Page<Course> findByTitleContaining(String title, PageRequest pageRequest);
}
