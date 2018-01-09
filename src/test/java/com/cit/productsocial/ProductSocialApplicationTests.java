package com.cit.productsocial;

import com.cit.productsocial.service.AWS3FileStorageService;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;



@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductSocialApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AWS3FileStorageService aws3Service;

	@Test
	public void contextLoads() {

	}

	@Test
	public void testGetByKeyAWS3() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/aws3/cuatung")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is2xxSuccessful())
				.andExpect(content().string("[\"https://s3-ap-southeast-1.amazonaws.com/new-albums/cuatung.jpg\"]"));

	}

	@Test
	public void testGetAllAWS3() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/api/aws3")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is2xxSuccessful());
	}
}
