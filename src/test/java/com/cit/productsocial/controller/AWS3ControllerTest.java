package com.cit.productsocial.controller;

import com.cit.productsocial.service.AWS3FileStorageService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AWS3ControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AWS3FileStorageService aws3Service;

    @Before
    public void setUp() {

    }

    @Test
    public void should_return_file_url_success() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/api/aws3/{key}", "cuatung")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string(
                        "[\"https://s3-ap-southeast-1.amazonaws.com/new-albums/cuatung.jpg\"]"
                ));
    }

    @Test
    public void should_return_null() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/api/aws3/not-exist")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string("[]"));
    }
}
