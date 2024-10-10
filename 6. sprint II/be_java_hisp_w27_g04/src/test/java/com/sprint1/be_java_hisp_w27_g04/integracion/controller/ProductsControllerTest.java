package com.sprint1.be_java_hisp_w27_g04.integracion.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sprint1.be_java_hisp_w27_g04.dto.request.PostPromotionDTO;
import com.sprint1.be_java_hisp_w27_g04.dto.request.PostRequestDTO;
import com.sprint1.be_java_hisp_w27_g04.entity.Post;
import com.sprint1.be_java_hisp_w27_g04.entity.User;
import com.sprint1.be_java_hisp_w27_g04.repository.impl.PostRepositoryImpl;
import com.sprint1.be_java_hisp_w27_g04.repository.impl.UserRepositoryImpl;
import com.sprint1.be_java_hisp_w27_g04.service.IProductsService;
import com.sprint1.be_java_hisp_w27_g04.service.IUsersService;
import com.sprint1.be_java_hisp_w27_g04.utils.TestUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ProductsControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	PostRepositoryImpl postRepository;

	@Autowired
	UserRepositoryImpl userRepository;

	@Autowired
	IUsersService usersService;

	@Autowired
	IProductsService productsService;

	@Test
	void contextLoads() {
	}

	@Test
	@DisplayName(value = "TI-0001: Probar el correcto guardado de una publicacion")
	public void testSavePostSuccessful() throws Exception {
		PostRequestDTO payloadDTO = TestUtils.getPostRequest();
		String payloadJSON = objectMapper.writeValueAsString(payloadDTO);
		mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
				.contentType(MediaType.APPLICATION_JSON)
				.content(payloadJSON))
				.andExpect(status().isOk());
	}

	@Test
	@DisplayName(value = "TI-0001: Probar el error cuando el usuario no existe")
	public void testSavePostUserNotExist() throws Exception {
		PostRequestDTO payloadDTO = TestUtils.getPostRequest();
		payloadDTO.setUserId(1000);
		String payloadJSON = objectMapper.writeValueAsString(payloadDTO);
		mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
						.contentType(MediaType.APPLICATION_JSON)
						.content(payloadJSON))
				.andExpect(status().isNotFound())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$.message")
						.value("No existe usuario con ese id"));
	}
	@Test
	@DisplayName("TI-0002: Listar post por fecha válida")
	public void dateValidateGetPostList() throws Exception {
		String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		int userid = 1;
		int userIdToFollow = 2;
		PostRequestDTO post = TestUtils.getPostRequest();
		productsService.newPost(post);
		usersService.followSeller(userid, userIdToFollow);
		this.mockMvc
				.perform(MockMvcRequestBuilders.get("/products/followed/1/list", userid))
				.andDo(print())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(userid))
				.andExpect(MockMvcResultMatchers.jsonPath("$.posts[0].user_id").value(userIdToFollow))
				.andExpect(MockMvcResultMatchers.jsonPath("$.posts[0].date").value(currentDate))
				.andExpect(MockMvcResultMatchers.jsonPath("$.posts[0].product.product_id").value(7));
	}

	@Test
	@DisplayName("TI-0003: DeletePost")
	public void deletePost() throws Exception {
		PostRequestDTO post =TestUtils.getPostRequest();
		productsService.newPost(post);
		this.mockMvc
				.perform(MockMvcRequestBuilders.delete("/products/delete/1"))
				.andDo(print())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Eliminado con exito"));
	}

	@Test
	@DisplayName("TI-0003: DeletePost")
	public void deletePostError() throws Exception {
		PostRequestDTO post =TestUtils.getPostRequest();
		productsService.newPost(post);
		int nonExistentPostId = 5;

		this.mockMvc.perform(MockMvcRequestBuilders.delete("/products/delete/" + nonExistentPostId))
						.andDo(print())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isNotFound())
				.andExpect(MockMvcResultMatchers.jsonPath("$.message").value("No se encontró ese post"));
	}

	@Test
	@DisplayName(value = "TI-0004: Save post con promocion")
	public void testSavePostPromotionSuccessful() throws Exception {
		PostPromotionDTO payloadDTO = TestUtils.getPostPromotion();
		String payloadJSON = objectMapper.writeValueAsString(payloadDTO);
		mockMvc.perform(MockMvcRequestBuilders.post("/products/promo-post")
						.contentType(MediaType.APPLICATION_JSON)
						.content(payloadJSON))
						.andExpect(status().isCreated())
						.andExpect(MockMvcResultMatchers.jsonPath("$.message")
								.value("Se ha creado el post con la promoción exitosamente. ID: 1"));
	}

	@Test
	@DisplayName(value = "TI-0004: Save post con promocion y usuario no existe")
	public void testSavePostPromotionUserNotExist() throws Exception {
		PostRequestDTO payloadDTO = TestUtils.getPostRequest();
		payloadDTO.setUserId(1000);
		String payloadJSON = objectMapper.writeValueAsString(payloadDTO);
		mockMvc.perform(MockMvcRequestBuilders.post("/products/promo-post")
						.contentType(MediaType.APPLICATION_JSON)
						.content(payloadJSON))
						.andExpect(status().isNotFound())
						.andExpect(content().contentType(MediaType.APPLICATION_JSON))
						.andExpect(MockMvcResultMatchers.jsonPath("$.message")
								.value("No existe usuario con ese id"));
	}

	@Test
	@DisplayName(value = "TI-0005: Obtener posts con promocion de un usuario")
	public void testGetPostWithPromoFromUser() throws Exception {
		//Arrange
		Post post = TestUtils.getPostPromotion(TestUtils.getProduct());
		Post post2 = TestUtils.getPostPromotion(TestUtils.getProduct());
		post2.getProduct().setProductId(2);
		postRepository.save(post);
		postRepository.save(post2);
		User user = userRepository.findById(2).orElseThrow();
		user.setPosts(Set.of(post,post2));
		Integer id = post.getUserId();
		mockMvc.perform(MockMvcRequestBuilders.get("/products/promo-post/list?user_id={id}",id))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.posts[0].product.product_id").value(2))
				.andExpect(jsonPath("$.posts[1].product.product_id").value(1));
	}

	@Test
	@DisplayName(value = "TI-0006: Obtener cantidad de post con promocion de un usuario")
	public void testCountPostWithPromoFromUser() throws Exception {
		//Arrange
		Post post = TestUtils.getPostPromotion(TestUtils.getProduct());
		postRepository.save(post);
		User user = userRepository.findById(2).orElseThrow();
		user.setPosts(Set.of(post));
		Integer id = post.getUserId();

		//Assert
		mockMvc.perform(MockMvcRequestBuilders.get("/products/promo-post/count?user_id={id}",id))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.user_id").value(id))
				.andExpect(jsonPath("$.promo_products_count").value(1));
	}

	@Test
	@DisplayName(value = "TI-0007: Eliminar Promoción")
	public void testEndPromotion() throws Exception {
		//Arrange
		Post post = TestUtils.getPostPromotion(TestUtils.getProduct());
		postRepository.save(post);
		Integer id = post.getPostId();

		//Assert
		mockMvc.perform(MockMvcRequestBuilders.patch("/products/promo-post/{id}/end",id))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.post_id").value(id))
				.andExpect(jsonPath("$.has_promo").value(false));
	}

	@Test
	@DisplayName(value = "TI-0007: Eliminar Promoción de post sin promoción")
	public void testEndPromotionWithoutPromotion() throws Exception {
		//Arrange
		Post post = TestUtils.getPostPromotion(TestUtils.getProduct());
		post.setHasPromo(false);
		post.setDiscount(0d);
		postRepository.save(post);
		Integer id = post.getPostId();

		//Assert
		mockMvc.perform(MockMvcRequestBuilders.patch("/products/promo-post/{id}/end",id))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.message").value("Este post no posee una promocion"));
	}

	@Test
	@DisplayName(value = "TI-0007: Eliminar Promoción de post inexistente")
	public void testEndPromotionWithoutPost() throws Exception {
		//Arrange
		Integer id = 13512;

		//Assert
		mockMvc.perform(MockMvcRequestBuilders.patch("/products/promo-post/{id}/end",id))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound())
				.andExpect(jsonPath("$.message").value("El post no existe"));
	}


}
