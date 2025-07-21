package com.eliarojr.springboot_practice_app.controller;

import com.eliarojr.springboot_practice_app.entity.Institution;
import com.eliarojr.springboot_practice_app.service.InstitutionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(InstitutionController.class)
class InstitutionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private InstitutionService institutionService;
    private Institution institution;

    @BeforeEach
    void setUp() {

        institution = Institution.builder()
                .institutionName("TUK")
                .institutionCode("CBD-10")
                .institutionAddress("CBD")
                .institutionId(1L)
                .build();
    }

    @Test
    void saveInstitution() throws Exception {

        Institution inputInstitution = Institution.builder()
                .institutionName("TUK")
                .institutionCode("CBD-10")
                .institutionAddress("CBD")
                .institutionId(1L)
                .build();

        Mockito.when(institutionService.saveInstitution(inputInstitution)).thenReturn(institution);

        mockMvc.perform(post("/institutions")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"institutionName\":\"TUK\",\n" +
                        "\t\"institutionAddress\":\"CBD\",\n" +
                        "\t\"institutionCode\":\"CBD-10\"\n" +
                        "}"))
                .andExpect(status().isOk());
    }

    @Test
    void fetchInstitutionById() throws Exception {

        Mockito.when(institutionService.fetchInstitutionById(1L))
                .thenReturn(institution);
        mockMvc.perform(get("/institutions/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.institutionName").value(institution.getInstitutionName()));
    }
}