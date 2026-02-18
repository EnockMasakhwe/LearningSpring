package com.eliarojr.demo.service;

import com.eliarojr.demo.entity.Department;
import com.eliarojr.demo.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department fetchDepartmentById(Integer departmentId) throws DepartmentNotFoundException;

    Department fetchDepartmentByName(String departmentName);

    void deleteDepartmentById(Integer departmentId);

    Department updateDepartmentById(Integer departmentId, Department department);
}
