package com.eliarojr.firstapp.service;

import com.eliarojr.firstapp.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface DepartmentService {

    public List<Department> fetchDepartmentList();

    public Department saveDepartment(Department department);

    public Department fetchDepartmentById(Long departmentId);


    public Department fetchDepartmentByName(String departmentName);


    public void deleteDepartmentById(Long departmentId);

    public Department updateDepartment(Department department, Long departmentId);
}
