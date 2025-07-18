package com.eliarojr.springboot_practice_app.service;


import com.eliarojr.springboot_practice_app.entity.Institution;
import com.eliarojr.springboot_practice_app.error.InstitutionNotFoundException;
import com.eliarojr.springboot_practice_app.repository.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class InstitutionServiceImpl implements InstitutionService{

    @Autowired
    private InstitutionRepository institutionRepository;

    @Override
    public Institution saveInstitution(Institution institution) {
        return institutionRepository.save(institution);
    }

    @Override
    public List<Institution> fetchInstitutionList() {
        return institutionRepository.findAll();
    }

    @Override
    public Institution fetchInstitutionById(Long institutionId) throws InstitutionNotFoundException {
        Optional<Institution> institution =institutionRepository.findById(institutionId);

        if(!institution.isPresent()){
            throw new InstitutionNotFoundException("Department not available");
        }

        return  institution.get();
    }

    @Override
    public Institution fetchInstitutionByName(String institutionName) {
        return institutionRepository.findByInstitutionNameIgnoreCase(institutionName);
    }

    @Override
    public void deleteInstitutionById(Long institutionId) {
        institutionRepository.deleteById(institutionId);
    }

    @Override
    public Institution updateInstitution(Institution institution, Long institutionId) {
        Institution instDB = institutionRepository.findById(institutionId).get();

        if(Objects.nonNull(institution.getInstitutionName()) &&
                !"".equalsIgnoreCase(institution.getInstitutionName())){
            instDB.setInstitutionName(institution.getInstitutionName());
        }

        if(Objects.nonNull(institution.getInstitutionAddress()) &&
                !"".equalsIgnoreCase(institution.getInstitutionAddress())){
            instDB.setInstitutionAddress(institution.getInstitutionAddress());
        }

        if(Objects.nonNull(institution.getInstitutionCode()) &&
                !"".equalsIgnoreCase(institution.getInstitutionCode())){
            instDB.setInstitutionCode(institution.getInstitutionCode());
        }

        return institutionRepository.save(instDB);
    }


}
