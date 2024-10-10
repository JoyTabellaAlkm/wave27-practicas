package com.sprint1.be_java_hisp_w27_g04.unitarios.service;

import com.sprint1.be_java_hisp_w27_g04.dto.PostListDTO;
import com.sprint1.be_java_hisp_w27_g04.dto.request.PostRequestDTO;
import com.sprint1.be_java_hisp_w27_g04.dto.request.ProductDTO;
import com.sprint1.be_java_hisp_w27_g04.entity.Post;
import com.sprint1.be_java_hisp_w27_g04.entity.Product;
import com.sprint1.be_java_hisp_w27_g04.entity.User;
import com.sprint1.be_java_hisp_w27_g04.dto.PostListDTO;
import com.sprint1.be_java_hisp_w27_g04.dto.request.PostRequestDTO;
import com.sprint1.be_java_hisp_w27_g04.entity.Post;
import com.sprint1.be_java_hisp_w27_g04.entity.User;
import com.sprint1.be_java_hisp_w27_g04.repository.IPostRepository;
import com.sprint1.be_java_hisp_w27_g04.repository.IUserRepository;
import com.sprint1.be_java_hisp_w27_g04.service.impl.ProductsServiceImpl;
import com.sprint1.be_java_hisp_w27_g04.utils.TestUtils;
import org.junit.jupiter.api.Assertions;
import com.sprint1.be_java_hisp_w27_g04.utils.TestUtils;
import jakarta.validation.constraints.NotNull;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

	@Mock
	IPostRepository postRepository;

	@Mock
	IUserRepository userRepository;

	@Mock
	private ModelMapper modelMapper;

	@InjectMocks
	ProductsServiceImpl productsService;

	@Test
	void contextLoads() {
	}

	@Test
	@DisplayName("T0008")
	void dateInvalidateGetPostListEmpty(){
		//arrange
		User user = TestUtils.getUser(1,2);
		User userFollowed = TestUtils.getUser(2,1);
		Product product = TestUtils.getProduct();
		Post post = TestUtils.getPost(product, 3);
		userFollowed.setPosts(Set.of(post));
		//act
		when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
		when(userRepository.findAll()).thenReturn(List.of(userFollowed));
		PostListDTO result = productsService.getPostList(user.getId(),"date_asc");
		List<PostRequestDTO> postRequestDTOS = result.getPosts();

		//assert
		Assertions.assertTrue(postRequestDTOS.isEmpty());

	}

	@Test
	@DisplayName("T0008")
	void dateValidateGetPostList(){
		//arrange
		User user = TestUtils.getUser(1,2);
		User userFollowed = TestUtils.getUser(2,1);
		Product product = TestUtils.getProduct();
		Post post = TestUtils.getPost(product, 1);
		userFollowed.setPosts(Set.of(post));
		ProductDTO productDTO = TestUtils.getProductDTO(product);
		//act
		when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
		when(userRepository.findAll()).thenReturn(List.of(userFollowed));
		when(modelMapper.map(post, PostRequestDTO.class)).thenReturn(new PostRequestDTO(1, post.getPostDate(), productDTO
				, post.getCategory(), post.getPrice()));

		PostListDTO result = productsService.getPostList(user.getId(),"date_asc");
		//assert
		Assertions.assertFalse(result.getPosts().isEmpty());
		Assertions.assertEquals(result.getPosts().size(),1);
	}

	@Test
	void ordenamientoPostsAsc(){

		//Arrange
		User user1 = new User(1,"Carlos", Set.of(2), Set.of(2), Set.of());
		User user2 = TestUtils.getUserWithPosts();

			//Obtengo los post mockeados y los ordeno según corresponde
		List<Post> orderedPosts = user2.getPosts().stream().toList();
		orderedPosts = orderedPosts.stream().sorted(Comparator.comparing(Post::getPostDate)).toList();

		List<PostRequestDTO> orderedPostsDTO = TestUtils.getPostListDTOOfLastTwoWeeksOfUserId2().getPosts();
		orderedPostsDTO = orderedPostsDTO.stream()
				.sorted(Comparator.comparing(PostRequestDTO::getDate)).toList();

		//Act
		Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(user1));
		Mockito.when(userRepository.findAll()).thenReturn(List.of(user1, user2));
		Mockito.when(modelMapper.map(orderedPosts.get(0), PostRequestDTO.class)).thenReturn(orderedPostsDTO.get(0));
		Mockito.when(modelMapper.map(orderedPosts.get(1), PostRequestDTO.class)).thenReturn(orderedPostsDTO.get(1));

		PostListDTO postListDTO = productsService.getPostList(1,"date_asc");

		Mockito.verify(userRepository, Mockito.times(1)).findById(1);
		Mockito.verify(userRepository, Mockito.times(1)).findAll();
		Mockito.verify(modelMapper, Mockito.times(1)).map(orderedPosts.get(0), PostRequestDTO.class);
		Mockito.verify(modelMapper, Mockito.times(1)).map(orderedPosts.get(1), PostRequestDTO.class);

		//Assert
		Assertions.assertEquals(orderedPostsDTO, postListDTO.getPosts());
	}

	@Test
	void ordenamientoPostsDesc(){

		//Arrange
		User user1 = new User(1,"Carlos", Set.of(2), Set.of(2), Set.of());
		User user2 = TestUtils.getUserWithPosts();

		//Obtengo los post mockeados y los ordeno según corresponde
		List<Post> orderedPosts = user2.getPosts().stream().toList();
		orderedPosts = orderedPosts.stream().sorted(Comparator.comparing(Post::getPostDate).reversed()).toList();

		List<PostRequestDTO> orderedPostsDTO = TestUtils.getPostListDTOOfLastTwoWeeksOfUserId2().getPosts();
		orderedPostsDTO = orderedPostsDTO.stream()
				.sorted(Comparator.comparing(PostRequestDTO::getDate).reversed()).toList();

		//Act
		Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(user1));
		Mockito.when(userRepository.findAll()).thenReturn(List.of(user1, user2));
		Mockito.when(modelMapper.map(orderedPosts.get(0), PostRequestDTO.class)).thenReturn(orderedPostsDTO.get(0));
		Mockito.when(modelMapper.map(orderedPosts.get(1), PostRequestDTO.class)).thenReturn(orderedPostsDTO.get(1));

		PostListDTO postListDTO = productsService.getPostList(1,"date_desc");

		Mockito.verify(userRepository, Mockito.times(1)).findById(1);
		Mockito.verify(userRepository, Mockito.times(1)).findAll();
		Mockito.verify(modelMapper, Mockito.times(1)).map(orderedPosts.get(0), PostRequestDTO.class);
		Mockito.verify(modelMapper, Mockito.times(1)).map(orderedPosts.get(1), PostRequestDTO.class);

		//Assert
		Assertions.assertEquals(orderedPostsDTO, postListDTO.getPosts());
	}

}
