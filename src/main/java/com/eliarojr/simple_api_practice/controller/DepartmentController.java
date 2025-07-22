package com.eliarojr.simple_api_practice.controller;

import com.eliarojr.simple_api_practice.entity.Department;
import com.eliarojr.simple_api_practice.error.DepartmentNotFoundException;
import com.eliarojr.simple_api_practice.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER =
            LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment of DepartmentController.");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartment(){
        LOGGER.info("Inside fetchDepartment of DepartmentController.");
        return departmentService.fetchDepartment();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        LOGGER.info("Inside fetchDepartmentById of DepartmentController.");
        return departmentService.fetchDepartmentById(departmentId);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        LOGGER.info("Inside fetchDepartmentByName of DepartmentController.");
        return departmentService.fetchDepartmentByName(departmentName);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        LOGGER.info("Inside deleteDepartmentById of DepartmentController.");
        return "Department deleted successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@RequestBody Department department,
                                       @PathVariable("id") Long departmentId){
        LOGGER.info("Inside updateDepartment of DepartmentController.");
        return departmentService.updateDepartment(department,departmentId);

    }




}
