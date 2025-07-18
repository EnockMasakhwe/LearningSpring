package com.eliarojr.springboot_practice_app.service;

import com.eliarojr.springboot_practice_app.entity.Institution;

import java.util.List;

public interface InstitutionService {
    public Institution saveInstitution(Institution institution);

    public List<Institution> fetchInstitutionList();

    public Institution fetchInstitutionById(Long institutionId);

    public Institution fetchInstitutionByName(String institutionName);

    public void deleteInstitutionById(Long institutionId);

    public Institution updateInstitution(Institution institution, Long institutionId);
}
