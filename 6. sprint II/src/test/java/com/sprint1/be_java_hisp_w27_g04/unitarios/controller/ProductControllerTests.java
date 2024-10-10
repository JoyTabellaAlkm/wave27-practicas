package com.sprint1.be_java_hisp_w27_g04.unitarios.controller;

import com.sprint1.be_java_hisp_w27_g04.dto.PostListDTO;
import com.sprint1.be_java_hisp_w27_g04.entity.User;
import com.sprint1.be_java_hisp_w27_g04.exceptions.NotFoundException;
import com.sprint1.be_java_hisp_w27_g04.service.IProductsService;
import com.sprint1.be_java_hisp_w27_g04.utils.TestUtils;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTests {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	private IProductsService productsService;


	@Test
	@DisplayName("Ordenamiento fecha válido")
	@Order(1)
	public void getPostListAsc() throws Exception {

		PostListDTO postListDTO = TestUtils.getPostListDTOOfLastTwoWeeksOfUserId2();

		Mockito.when(productsService.getPostList(Mockito.anyInt(), Mockito.anyString()))
				.thenReturn(postListDTO);

		this.mockMvc
				.perform(MockMvcRequestBuilders.get("/products/followed/1/list?order=date_asc",1))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	@DisplayName("Ordenamiento fecha inválido")
	@Order(3)
	public void getPostListWrongParam() throws Exception {

		PostListDTO postListDTO = TestUtils.getPostListDTOOfLastTwoWeeksOfUserId2();

		Mockito.when(productsService.getPostList(Mockito.anyInt(), Mockito.anyString()))
				.thenReturn(postListDTO);

		this.mockMvc
				.perform(MockMvcRequestBuilders.get("/products/followed/1/list?order=date_wrong",1))
				.andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$.message[0]")
						.value("El parámetro order debe ser 'date_asc' o 'date_desc"));
	}













}
