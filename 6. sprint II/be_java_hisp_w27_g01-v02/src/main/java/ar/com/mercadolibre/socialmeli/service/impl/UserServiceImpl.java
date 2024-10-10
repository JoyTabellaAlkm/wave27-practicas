package ar.com.mercadolibre.socialmeli.service.impl;

import ar.com.mercadolibre.socialmeli.dto.response.*;
import ar.com.mercadolibre.socialmeli.entity.User;
import ar.com.mercadolibre.socialmeli.exception.BadRequestException;
import ar.com.mercadolibre.socialmeli.exception.NotFoundException;
import ar.com.mercadolibre.socialmeli.repository.IRepository;
import ar.com.mercadolibre.socialmeli.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {
    private final IRepository repository;

    public UserServiceImpl(IRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UserFollowedResponseDTO> findByFollowed(Integer userId, String order) {
        if (!repository.existId(userId)) {
            throw new NotFoundException("User ID: " + userId + " doesn't exist.");
        }

        User user = repository.getUserById(userId);
        List<Integer> follows = user.getFollowedIds();

        if (follows == null || follows.isEmpty()) {
            throw new BadRequestException("User with the ID: " + user.getUserId() + " is not following anyone.");
        }

        if (order != null && !order.equalsIgnoreCase("name_asc") && !order.equalsIgnoreCase("name_desc")) {
            throw new BadRequestException("Invalid order parameter: " + order);
        }

        List<UserNameResponseDTO> followedList = repository.getUsers().stream()
                .filter(u -> follows.contains(u.getUserId()))
                .map(u -> new UserNameResponseDTO(u.getUserId(), u.getUserName()))
                .sorted(order != null && order.equalsIgnoreCase("name_desc") ?
                        Comparator.comparing(UserNameResponseDTO::getUserName).reversed() :
                        Comparator.comparing(UserNameResponseDTO::getUserName))
                .collect(Collectors.toList());

        return List.of(new UserFollowedResponseDTO(user.getUserId(), user.getUserName(), followedList));
    }

    @Override
    public UserFollowerListResponseDTO getFollowerList(Integer userId, String order) {
        if (userId == null || userId <= 0) {
                throw new BadRequestException("User ID: " + userId + " is invalid.");
        }

        if (!repository.existId(userId)) {
            throw new BadRequestException("User ID: " + userId + " doesn't exist.");
        }

        User user = repository.getUserById(userId);
        List<UserNameResponseDTO> followers = repository.getUsers().stream()
                .   filter(u -> u.getFollowedIds() != null && u.getFollowedIds().contains(userId))
                .map(u -> new UserNameResponseDTO(u.getUserId(), u.getUserName()))
                .sorted(order != null && order.equalsIgnoreCase("name_desc") ?
                        Comparator.comparing(UserNameResponseDTO::getUserName).reversed() :
                        Comparator.comparing(UserNameResponseDTO::getUserName))
                .collect(Collectors.toList());


        return new UserFollowerListResponseDTO(userId, user.getUserName(), followers);
    }

    @Override
    public UserFollowerCountResponseDTO getFollowerCount(Integer userId){

        if (userId == null || userId <= 0){
            throw new BadRequestException("User ID: " + userId + " is invalid.");
        }

        if (!repository.existId(userId)){
            throw new BadRequestException("User ID: " + userId + " doesn't exist.");
        }

        long followerCount = repository.getUsers().stream()
                .filter(user -> user.getFollowedIds() != null && user.getFollowedIds().contains(userId))
                .count();

        User user = repository.getUserById(userId);

        return new UserFollowerCountResponseDTO(userId, user.getUserName(), (int) followerCount);
    }


    @Override
    public UserOkResponseDTO followASpecificUserById(Integer userId, Integer userIdToFollow) {

        if (userIdToFollow == null ||userId == null || userIdToFollow <= 0 || userId <= 0 || userId.equals(userIdToFollow)) {
            throw new BadRequestException("Invalid IDs");
        }

        if (!repository.existId(userIdToFollow)){
            throw new BadRequestException("User to follow ID: " + userIdToFollow + " doesn't exist.");
        }

        User userToFollow = repository.getUserById(userIdToFollow);

        if (userToFollow.getPosts() == null || userToFollow.getPosts().isEmpty()){
            throw new BadRequestException("User to follow is not a seller");
        }

        User user = repository.getUserById(userId);

        if (user == null) {
            throw new BadRequestException("User ID: " + userId + " doesn't exist.");
        }

        if (user.getFollowedIds().contains(userIdToFollow)){
            throw new BadRequestException("User ID: " + userId + " already follows User ID: " + userIdToFollow);
        }

        if (!repository.updateUser(user)){
            throw new NotFoundException("Ocurio un error al actualizar el User ID: " + userId);
        }

        return new UserOkResponseDTO("OK");
    }


    @Override
    public UserOkResponseDTO unfollowASpecificUserById(Integer userId, Integer userIdToUnfollow) {

        if (userId == null || userId <= 0 || !repository.existId(userId) ){
            throw new BadRequestException("Invalid User ID: " +userId);
        }

        if (userId.equals(userIdToUnfollow)){
            throw new BadRequestException("Invalid User and User ID to unfollow");
        }

        if (userIdToUnfollow == null || userIdToUnfollow <= 0 || !repository.existId(userIdToUnfollow)){
            throw new BadRequestException("Invalid User to Unfollow ID: " +  userIdToUnfollow);
        }

        User user = repository.getUserById(userId);


        if (!user.getFollowedIds().contains(userIdToUnfollow)){
            throw new BadRequestException("User ID: " + userId + " does not follow User ID: " + userIdToUnfollow);
        }

        user.removeFollowedId(userIdToUnfollow);

        repository.updateUser(user);

        return new UserOkResponseDTO("OK");
    }


}
