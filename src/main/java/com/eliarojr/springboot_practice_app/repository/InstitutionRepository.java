package com.eliarojr.springboot_practice_app.repository;

import com.eliarojr.springboot_practice_app.entity.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {


    public Institution findByInstitutionNameIgnoreCase(String institutionName);
}
