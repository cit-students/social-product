package com.cit.productsocial.controller;

import com.cit.productsocial.service.AWS3FileStorageService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AWS3ControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    @Before
    public void setUp() {

    }

    @Test
    public void should_return_file_url_success() throws Exception {
        String url = "http://localhost:" + port;
        ResponseEntity responseEntity = restTemplate.getForEntity(url + "/api/aws3/cuatung", List.class);
        Assert.assertEquals(responseEntity.getStatusCodeValue(), 200);
        List<String> urls = (List<String>) responseEntity.getBody();
        Assert.assertTrue(urls.size() > 0);
        urls.forEach(System.out::println);
    }
}
