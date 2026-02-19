package com.eliarojr.demo.controller;

import com.eliarojr.demo.entity.Department;
import com.eliarojr.demo.error.DepartmentNotFoundException;
import com.eliarojr.demo.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department){
        return  departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/id/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Integer departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(departmentId);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }

    @DeleteMapping("/departments/id/{id}")
    public String deleteDepartmentById(@PathVariable("id")Integer departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully!";
    }

    @PutMapping("/departments/id/{id}")
    public Department updateDepartmentById(@PathVariable("id") Integer departmentId, @RequestBody Department department){
        return departmentService.updateDepartmentById(departmentId,department);
    }
}
