package com.eliarojr.simple_api.service;

import com.eliarojr.simple_api.entity.Department;
import org.springframework.beans.MutablePropertyValues;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long departmentId);

    public Department fetchDepartmentByName(String departmentName);

    public void deleteDepartmentById(Long departmentId);

    public Department updateDepartment(Department department, Long departmentId);
}
