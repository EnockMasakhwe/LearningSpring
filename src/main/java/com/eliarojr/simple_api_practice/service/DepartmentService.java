package com.eliarojr.simple_api_practice.service;


import com.eliarojr.simple_api_practice.entity.Department;
import com.eliarojr.simple_api_practice.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {

    public Department saveDepartment(Department department);

    public List<Department> fetchDepartment();

    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public Department fetchDepartmentByName(String departmentName);

    public void deleteDepartmentById(Long departmentId);

    public Department updateDepartment(Department department, Long departmentId);
}
