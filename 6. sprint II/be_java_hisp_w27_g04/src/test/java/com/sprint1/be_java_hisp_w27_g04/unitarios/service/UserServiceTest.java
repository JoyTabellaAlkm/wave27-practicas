package com.sprint1.be_java_hisp_w27_g04.unitarios.service;

import com.sprint1.be_java_hisp_w27_g04.dto.response.*;
import com.sprint1.be_java_hisp_w27_g04.entity.User;
import com.sprint1.be_java_hisp_w27_g04.exceptions.InvalidOrderException;
import com.sprint1.be_java_hisp_w27_g04.exceptions.NotFoundException;
import com.sprint1.be_java_hisp_w27_g04.repository.IUserRepository;
import com.sprint1.be_java_hisp_w27_g04.service.impl.UsersServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.*;
import static com.sprint1.be_java_hisp_w27_g04.utils.TestUtils.getUsersTest;
import static org.junit.jupiter.api.Assertions.*;
import com.sprint1.be_java_hisp_w27_g04.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.*;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserServiceTest {

	@Mock
	IUserRepository userRepository;

	@InjectMocks
	UsersServiceImpl usersService;

	@Mock
	private ModelMapper modelMapper;


	@Test
	@DisplayName("T-0001- Se sigue usuario")
	@Order(1)
	void followExistingUser() {

		int userId = 1;
		int userIdToFollow = 2;
		User user = getUsersTest().get(0);
		User userToFollow = getUsersTest().get(1);

		when(userRepository.findById(userId)).thenReturn(Optional.of(user));
		when(userRepository.findById(userIdToFollow)).thenReturn(Optional.of(userToFollow));

		ResponseDTO response = usersService.followSeller(userId, userIdToFollow);

		assertNotNull(response);
		assertEquals("200", response.getHttpCode());
		assertEquals("Se empezó a seguir a User 2", response.getMessage());
		assertTrue(user.getFollowed().contains(userToFollow.getId()));
		assertTrue(userToFollow.getFollowers().contains(user.getId()));

	}

	@Test
	@DisplayName("T-0001-No se puede seguir usuario")
	@Order(2)
	void userIsNotFollowedBecauseItDoesNotExist() {
		//ARRANGE
		int userId = 1;
		int userIdToFollow = 2;

		User user = getUsersTest().getFirst();

		//ACT
		when(userRepository.findById(userId)).thenReturn(Optional.of(user));
		when(userRepository.findById(userIdToFollow)).thenReturn(Optional.empty());

		Exception exception = assertThrows(NotFoundException.class, () -> {
			usersService.followSeller(userId, userIdToFollow);
		});

		//ASSERT
		assertEquals("No existe usuario con ese id", exception.getMessage());
		assertTrue(user.getFollowed().isEmpty());
	}

	@Test
	@DisplayName("T-0002- Se deja de seguir usuario")
	@Order(3)
	void unfollowExistingUser() {
		//ARRANGE
		int userId = 1;
		int userIdToUnFollow = 2;
		User user = getUsersTest().get(0);
		User userToFollow = getUsersTest().get(1);


		user.addFollowed(userToFollow);
		userToFollow.addFollower(user);

		//ACT
		when(userRepository.findById(userId)).thenReturn(Optional.of(user));
		when(userRepository.findById(userIdToUnFollow)).thenReturn(Optional.of(userToFollow));

		ResponseDTO response = usersService.unfollowSeller(userId, userToFollow.getId());

		// ASSERT
		assertNotNull(response);
		assertEquals("200", response.getHttpCode());
		assertEquals("Se dejó de seguir a " + userToFollow.getName(), response.getMessage());
		assertFalse(user.getFollowed().contains(userToFollow.getId()));
		assertFalse(userToFollow.getFollowers().contains(user.getId()));
	}

	@Test
	@DisplayName("T-0002- No se deja de seguir usuario")
	@Order(4)
	void userIsNotUnFollowedBecauseItDoesNotExist() {
		//ARRANGE
		int userId = 1;
		int userIdToUnFollow = 2;

		User user = getUsersTest().getFirst();

		//ACT
		when(userRepository.findById(userId)).thenReturn(Optional.of(user));
		when(userRepository.findById(userIdToUnFollow)).thenReturn(Optional.empty());

		Exception exception = assertThrows(NotFoundException.class, () -> {
			usersService.unfollowSeller(userId, userIdToUnFollow);
		});

		// ASSERT
		assertEquals("No existe usuario con ese id", exception.getMessage());
		assertTrue(user.getFollowed().isEmpty());
	}

	@Test
	@DisplayName(value = "T-0007: Cantidad de seguidores de un usuario correctamente")
	void testUserFollowersCountByIdSuccess() {
		// ARRANGE
		int followersExpected = 3;
		Optional<User> user = Optional.of(TestUtils.getUserId1WithFollowers());

		// ACT
		when(userRepository.findById(user.get().getId())).thenReturn(user);
		usersService.getUserFollowersCountById(user.get().getId());

		//ASSERT
		verify(userRepository, atLeastOnce()).findById(user.get().getId());
		assertEquals(followersExpected, user.get().getFollowers().size());
	}

	@Test
	@DisplayName(value = "T-0007: El usuario no existe")
	void testUserFollowersCountNotExists() {
		// ARRANGE
		Optional<User> user = Optional.empty();
		String errorExpected = "El usuario no existe";

		// ACT
		when(userRepository.findById(1)).thenReturn(user);

		//ASSERT
		Exception exception = assertThrows(NotFoundException.class, () -> {
			usersService.getUserFollowersCountById(1);
		});
		assertTrue(exception.getMessage().contains(errorExpected));
		verify(userRepository, atLeastOnce()).findById(1);
	}

	@Test
	@DisplayName("T-0003: Verificar que el tipo de ordenamiento alfabético 'name_asc' exista")
	public void testValidOrderNameAsc() {
		String order = "name_asc";
		assertTrue(usersService.isValidOrder(order));
	}

	@Test
	@DisplayName("T-0003: Verificar que el tipo de ordenamiento alfabético 'name_desc' exista")
	public void testValidOrderNameDesc() {
		String order = "name_desc";
		assertTrue(usersService.isValidOrder(order));
	}

	@Test
	@DisplayName("T-0003: Lanzar excepción si el ordenamiento es inválido")
	public void testInvalidOrderThrowsException() {
		String invalidOrder = "invalid_order";
		InvalidOrderException exception = assertThrows(InvalidOrderException.class, () -> {
			usersService.getFollowers(1, invalidOrder);
		});
		assertEquals("Ordenamiento inválido: " + invalidOrder, exception.getMessage());
	}

	@Test
	@DisplayName("T-0004: Verificar el correcto ordenamiento ascendente por nombre.")
	public void testGetFollowersOrderByNameAsc() {
		// Arrange
		String orderAsc = "name_asc";
		User user = TestUtils.getUserWithFollowersTest();
		List<User> followersAsc = TestUtils.getFollowersListTest();

		// Act
		when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
		when(userRepository.findAllFollowersInOrder(user.getId(), Optional.of(orderAsc)))
				.thenReturn(followersAsc);

		for (User follower : followersAsc) {
			when(modelMapper.map(follower, FollowerDTO.class))
					.thenReturn(new FollowerDTO(follower.getId(), follower.getName()));
		}

		ResponseFollowersDTO resultAsc = usersService.getFollowers(user.getId(), orderAsc);

		// Assert
		assertNotNull(resultAsc);
		assertEquals(user.getId(), resultAsc.getUserID());
		assertEquals(user.getName(), resultAsc.getUserName());
		assertEquals(followersAsc.size(), resultAsc.getFollowers().size());
		for (int i = 0; i < followersAsc.size(); i++) {
			assertEquals(followersAsc.get(i).getName(), resultAsc.getFollowers().get(i).getUserName());
		}
	}

	@Test
	@DisplayName("T-0004: Verificar el correcto ordenamiento descendente por nombre.")
	public void testGetFollowersOrderByNameDesc() {
		// Arrange
		String orderDesc = "name_desc";
		User user = TestUtils.getUserWithFollowersTest();
		List<User> followersAsc = TestUtils.getFollowersListTest();
		List<User> followersDesc = new ArrayList<>(followersAsc);
		Collections.reverse(followersDesc);

		// Act
		when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
		when(userRepository.findAllFollowersInOrder(user.getId(), Optional.of(orderDesc)))
				.thenReturn(followersDesc);

		for (User follower : followersDesc) {
			when(modelMapper.map(follower, FollowerDTO.class))
					.thenReturn(new FollowerDTO(follower.getId(), follower.getName()));
		}

		ResponseFollowersDTO resultDesc = usersService.getFollowers(user.getId(), orderDesc);

		// Assert
		assertNotNull(resultDesc);
		assertEquals(user.getId(), resultDesc.getUserID());
		assertEquals(user.getName(), resultDesc.getUserName());
		assertEquals(followersDesc.size(), resultDesc.getFollowers().size());
		for (int i = 0; i < followersDesc.size(); i++) {
			assertEquals(followersDesc.get(i).getName(), resultDesc.getFollowers().get(i).getUserName());
		}
	}

	@Test
	@DisplayName("T-0004(Followed): Verificar el correcto ordenamiento ascendente por nombre.")
	public void testGetFollowedOrderByNameAsc() {
		// Arrange
		String orderAsc = "name_asc";
		User user = TestUtils.getUserWithFollowedTest();
		List<User> followedAsc = TestUtils.getFollowedListTest();

		// Act: Orden Ascendente
		when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
		when(userRepository.findAllFollowedInOrder(user.getId(), Optional.of(orderAsc)))
				.thenReturn(followedAsc);

		for (User followed : followedAsc) {
			when(modelMapper.map(followed, FollowedDTO.class))
					.thenReturn(new FollowedDTO(followed.getId(), followed.getName()));
		}

		ResponseFollowedDTO resultAsc = usersService.getFollowed(user.getId(), orderAsc);

		// Assert: Orden Ascendente
		assertNotNull(resultAsc);
		assertEquals(user.getId(), resultAsc.getUserID());
		assertEquals(user.getName(), resultAsc.getUserName());
		assertEquals(followedAsc.size(), resultAsc.getFollowed().size());

		int indexAsc = 0;
		for (User expectedFollowed : followedAsc) {
			assertEquals(expectedFollowed.getName(), resultAsc.getFollowed().get(indexAsc++).getUserName());
		}
	}

	@Test
	@DisplayName("T-0004(Followed): Verificar el correcto ordenamiento descendente por nombre.")
	public void testGetFollowedOrderByNameDesc() {
		// Arrange
		String orderDesc = "name_desc";
		User user = TestUtils.getUserWithFollowedTest();
		List<User> followedAsc = TestUtils.getFollowedListTest();
		List<User> followedDesc = new ArrayList<>(followedAsc);
		Collections.reverse(followedDesc);

		// Act: Orden Descendente
		when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
		when(userRepository.findAllFollowedInOrder(user.getId(), Optional.of(orderDesc)))
				.thenReturn(followedDesc);

		for (User followed : followedDesc) {
			when(modelMapper.map(followed, FollowedDTO.class))
					.thenReturn(new FollowedDTO(followed.getId(), followed.getName()));
		}

		ResponseFollowedDTO resultDesc = usersService.getFollowed(user.getId(), orderDesc);

		// Assert: Orden Descendente
		assertNotNull(resultDesc);
		assertEquals(user.getId(), resultDesc.getUserID());
		assertEquals(user.getName(), resultDesc.getUserName());
		assertEquals(followedDesc.size(), resultDesc.getFollowed().size());

		int indexDesc = 0;
		for (User expectedFollowed : followedDesc) {
			assertEquals(expectedFollowed.getName(), resultDesc.getFollowed().get(indexDesc++).getUserName());
		}
	}


}