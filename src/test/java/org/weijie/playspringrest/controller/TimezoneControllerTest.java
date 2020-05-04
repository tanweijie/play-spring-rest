package org.weijie.playspringrest.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.weijie.playspringrest.service.TimezoneService;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest
class TimezoneControllerTest {

    @Autowired
    MockMvc mvc;

    // have to mock this because @WebMvcTest only creates context for controller beans
    @MockBean
    TimezoneService service;

    @Test
    void getTime() throws Exception {
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/timezone/show").param("timezone", "Europe/Monaco"))
                              .andExpect(status().isOk())
                              .andReturn();
    }

    @Test
    void getAllTimezones() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/timezone/all"))
           .andExpect(status().isOk());
    }
}