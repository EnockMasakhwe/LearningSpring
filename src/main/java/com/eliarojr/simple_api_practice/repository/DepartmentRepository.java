package com.eliarojr.simple_api_practice.repository;


import com.eliarojr.simple_api_practice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

    public Department findByDepartmentNameIgnoreCase(String departmentName);
}
