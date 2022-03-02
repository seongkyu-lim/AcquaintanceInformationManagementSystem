package com.loopy.AcquaintanceInformationManagementSystem.controller;

import com.loopy.AcquaintanceInformationManagementSystem.domain.Person;
import com.loopy.AcquaintanceInformationManagementSystem.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringBootTest
class PersonControllerTest {

    @Autowired
    private PersonController personController;

    @Autowired
    private PersonRepository personRepository;

    private MockMvc mockMvc;


    @BeforeEach
    void beforeEach(){
        mockMvc = MockMvcBuilders.standaloneSetup(personController).build();

    }

    @Test
    void getPerson() throws Exception{
        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/person/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    void postPerson() throws Exception{
        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"name\": \"martin2\",\n" +
                                "    \"age\": 20, \n" +
                                "    \"bloodType\": \"A\"\n" +
                                "}"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @Transactional
    void updatePerson() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.put("/api/person/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"name\": \"martin\",\n" +
                        "    \"age\": 20, \n" +
                        "    \"bloodType\": \"A\"\n" +
                        "}"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @Transactional
    void updateName() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.patch("/api/person/1")
                .param("name", "martin22"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @Transactional
    void delete() throws  Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/person/1")).andDo(print()).andExpect(status().isOk());

        log.info("people deleted : {} ", personRepository.findByPeopleDeleted());


    }
}