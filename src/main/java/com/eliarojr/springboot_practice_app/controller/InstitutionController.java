package com.eliarojr.springboot_practice_app.controller;

import com.eliarojr.springboot_practice_app.entity.Institution;
import com.eliarojr.springboot_practice_app.service.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InstitutionController {

    @Autowired
    private InstitutionService institutionService;

    @PostMapping("/institutions")
    public Institution saveInstitution(@RequestBody Institution institution){
        return institutionService.saveInstitution(institution);
    }

    @GetMapping("/institutions")
    public List <Institution> fetchInstitutionList(){
        return institutionService.fetchInstitutionList();
    }

    @GetMapping("/institutions/{id}")
    public Institution fetchInstitutionById(@PathVariable("id")Long institutionId){
        return institutionService.fetchInstitutionById(institutionId);
    }

    @GetMapping("/institutions/name/{name}")
    public Institution fetchInstitutionByName(@PathVariable("name")String institutionName){
        return institutionService.fetchInstitutionByName(institutionName);
    }

    @DeleteMapping("/institutions/{id}")
    public String deleteInstitutionById(@PathVariable("id")Long institutionId){
        institutionService.deleteInstitutionById(institutionId);
        return "Institution deleted successfully!";
    }

    @PutMapping("/institutions/{id}")
    public Institution updateInstitution(@RequestBody Institution institution,
                                         @PathVariable("id") Long institutionId){
        return institutionService.updateInstitution(institution, institutionId);
    }


}
