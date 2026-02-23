package com.eliarojr.demo.repository;

import com.eliarojr.demo.entity.Department;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("IT").departmentAddress("Kahawa").departmentCode("IT-009")
                .build();

        entityManager.persist(department);
    }

    @Test
    public void returnDepartmentWhenFindById(){
        Department department = departmentRepository.findById(1).get();
        assertEquals(department.getDepartmentName(), "IT");
    }


}