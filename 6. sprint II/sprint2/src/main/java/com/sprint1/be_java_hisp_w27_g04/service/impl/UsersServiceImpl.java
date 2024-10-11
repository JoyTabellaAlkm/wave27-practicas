package com.sprint1.be_java_hisp_w27_g04.service.impl;

import com.sprint1.be_java_hisp_w27_g04.dto.response.UserFollowersCountResponseDTO;
import com.sprint1.be_java_hisp_w27_g04.dto.response.*;
import com.sprint1.be_java_hisp_w27_g04.entity.Post;
import com.sprint1.be_java_hisp_w27_g04.entity.User;
import com.sprint1.be_java_hisp_w27_g04.exceptions.BadRequestException;
import com.sprint1.be_java_hisp_w27_g04.exceptions.InvalidOrderException;
import com.sprint1.be_java_hisp_w27_g04.exceptions.NotFoundException;
import com.sprint1.be_java_hisp_w27_g04.repository.IUserRepository;
import com.sprint1.be_java_hisp_w27_g04.service.IUsersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;


@Service
public class UsersServiceImpl implements IUsersService {

    @Autowired
    IUserRepository userRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public ResponseDTO followSeller(int userId, int userIdToFollow) {
        User user = getUserById(userId);
        User userToFollow = getUserById(userIdToFollow);

        if (user.getFollowed().stream().anyMatch(userF->userF.equals(userToFollow.getId()))){
            throw new BadRequestException("Ya está en sus vendedores seguidos");
        }

        if(userToFollow.getPosts().isEmpty()){
            throw new BadRequestException("El usuario no se puede seguir porque no es vendedor");
        }

        user.addFollowed(userToFollow);
        userToFollow.addFollower(user);
        return new ResponseDTO("200","Se empezó a seguir a " + userToFollow.getName());
    }

    @Override
    public ResponseFollowersDTO getFollowers(int userId, String order) {

        // Validar el tipo de ordenamiento
        if (!isValidOrder(order)) {
            throw new InvalidOrderException("Ordenamiento inválido: " + order);
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Usuario no encontrado"));

        List<User> followers = userRepository.findAllFollowersInOrder(userId, Optional.of(order));

        if (followers.isEmpty()) {
            throw new NotFoundException("No se encontraron seguidores");
        }

        List<FollowerDTO> followerDTOS = mapToFollowerDTOs(followers);

        return new ResponseFollowersDTO(userId, user.getName(), followerDTOS);
    }

    public boolean isValidOrder(String order) {
        return "name_asc".equals(order) || "name_desc".equals(order);
    }

    private List<FollowerDTO> mapToFollowerDTOs(List<User> followers) {
        return followers.stream()
                .map(follower -> modelMapper.map(follower, FollowerDTO.class))
                .toList();
    }

    @Override
    public ResponseDTO unfollowSeller(int userId, int userIdToUnfollow) {

        User user = getUserById(userId);
        User userToUnFollow = getUserById(userIdToUnfollow);

        user.getFollowed().stream()
                .filter(userF -> userF == userIdToUnfollow)
                .findFirst()
                .orElseThrow(()-> new BadRequestException("No sigue a ese usuario"));

        user.deleteFollowed(userToUnFollow);
        userToUnFollow.deleteFollower(user);

        return new ResponseDTO("200","Se dejó de seguir a " + userToUnFollow.getName());
    }

    @Override
    public List<ResponsePostDTO> getSellerPosts(int userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new NotFoundException("No existe usuario con ese id"));
        List<Post> posts = new HashSet<>(user.getPosts()).stream().toList();

        if(posts.isEmpty()){
            throw new NotFoundException("El usuario no tiene posts para mostrar");
        }
        return posts.stream().map(post -> modelMapper.map(post,ResponsePostDTO.class)).toList();
    }


    @Override
    public UserFollowersCountResponseDTO getUserFollowersCountById(int userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new NotFoundException("El usuario no existe"));
        int followersCount = user.getFollowers().size();
        return new UserFollowersCountResponseDTO(userId, user.getName(), followersCount);
    }

    @Override
    public ResponseFollowedDTO getFollowed(int userId,String order) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found"));

        List<User> followeds = userRepository.findAllFollowedInOrder(userId,Optional.of(order));

        if(followeds.isEmpty()){
            throw new NotFoundException("No se encontraron usuarios seguidos");
        }

        List<FollowedDTO> followedDTOS = followeds.stream()
                .map(followed -> modelMapper.map(followed, FollowedDTO.class))
                .toList();

        return new ResponseFollowedDTO(userId, user.getName(), followedDTOS);
    }

    private User getUserById(int userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("No existe usuario con ese id"));
    }



}
