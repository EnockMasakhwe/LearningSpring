package com.eliarojr.springboot_practice_app.service;

import com.eliarojr.springboot_practice_app.entity.Institution;
import com.eliarojr.springboot_practice_app.error.InstitutionNotFoundException;
import com.eliarojr.springboot_practice_app.repository.InstitutionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InstitutionServiceTest {

    @Autowired
    private InstitutionService institutionService;

    @Mock
    private InstitutionRepository institutionRepository;

    @BeforeEach
    void setUp() {

        Institution institution = Institution.builder()
                .institutionName("JKUAT")
                .institutionAddress("Thika Road")
                .institutionCode("TR-01")
                .institutionId(1L)
                .build();
        Mockito.when(institutionRepository.findByInstitutionNameIgnoreCase("JKUAT")).thenReturn(institution);

    }

    @Test
    @DisplayName("Get data based on valid Institution name")
    public void whenValidInstitutionName_thenInstitutionShouldFound(){
        String institutionName = "JKUAT";
        Institution found = institutionService.fetchInstitutionByName(institutionName);

        assertEquals(institutionName, found.getInstitutionName());
    }

    @Test
    @Disabled
    @DisplayName("Get data based on valid Institution Id")
    public void whenValidInstitutionId_thenInstitutionShouldFound() throws InstitutionNotFoundException {
        Long institutionId = 1L;
        Institution found = institutionService.fetchInstitutionById(institutionId);

        assertEquals(institutionId, found.getInstitutionId());

    }
}