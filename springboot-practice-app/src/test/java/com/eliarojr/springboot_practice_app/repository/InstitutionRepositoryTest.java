package com.eliarojr.springboot_practice_app.repository;

import com.eliarojr.springboot_practice_app.entity.Institution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class InstitutionRepositoryTest {

    @Autowired
    private InstitutionRepository institutionRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp(){
        Institution institution = Institution.builder()
                .institutionName("Ruiru")
                .institutionCode("TR-20")
                .institutionAddress("Bypass")
                .build();

        entityManager.persist(institution);
    }

    @Test
    public void whenFindById_thenReturnInstitution(){
        Institution institution = institutionRepository.findById(1L).get();
        assertEquals(institution.getInstitutionName(), "Ruiru");

    }

}