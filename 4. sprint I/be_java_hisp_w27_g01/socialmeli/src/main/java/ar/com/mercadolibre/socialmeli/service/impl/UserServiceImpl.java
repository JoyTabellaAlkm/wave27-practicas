package ar.com.mercadolibre.socialmeli.service.impl;

import ar.com.mercadolibre.socialmeli.dto.response.*;
import ar.com.mercadolibre.socialmeli.entity.User;
import ar.com.mercadolibre.socialmeli.exception.BadRequestException;
import ar.com.mercadolibre.socialmeli.exception.NotFoundException;
import ar.com.mercadolibre.socialmeli.repository.IRepository;
import ar.com.mercadolibre.socialmeli.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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
        List<User> allUsers = repository.getUsers();

        if (follows == null) {
            throw new BadRequestException("User with the ID: "  + user.getUserId() + " is not following anyone.");
        }

        List<UserNameResponseDTO> followedList = follows.stream()
                .map(followedId -> allUsers.stream()
                        .filter(user1 -> user1.getUserId().equals(followedId))
                        .findFirst()
                        .map(user1 -> new UserNameResponseDTO(user1.getUserId(), user1.getUserName())))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        if(order != null){
            if(order.equals("name_asc")){
                followedList = followedList.stream().sorted(Comparator.comparing(UserNameResponseDTO::getUserName)).toList();
            }
            else if(order.equals("name_desc")){
                followedList = followedList.stream().sorted(Comparator.comparing(UserNameResponseDTO::getUserName).reversed()).toList();
            }
            else{
                throw new BadRequestException("Order " + order + " not recognized.");
            }
        }

        List<UserFollowedResponseDTO> userFollowedResponseDTOList = new ArrayList<>();
        userFollowedResponseDTOList.add(new UserFollowedResponseDTO(user.getUserId(), user.getUserName(), followedList));

        return userFollowedResponseDTOList;
    }

    @Override
    public UserFollowerListResponseDTO getFollowerList(Integer userId, String order){

        if (userId == null || userId <= 0){
            throw new BadRequestException("User ID: " + userId + " is invalid.");
        }

        if (!repository.existId(userId)){
            throw new BadRequestException("User ID: " + userId + " doesn't exist.");
        }

        List<UserNameResponseDTO> followers = repository.getUsers().stream()
                .filter(user -> user.getFollowedIds() != null && user.getFollowedIds().contains(userId))
                .map(user -> new UserNameResponseDTO(user.getUserId(), user.getUserName()))
                .toList();

        if (order != null){
            if(order.equals("name_asc")){
                followers = followers.stream().sorted(Comparator.comparing(UserNameResponseDTO::getUserName)).toList();
            }
            else if(order.equals("name_desc")){
                followers = followers.stream().sorted(Comparator.comparing(UserNameResponseDTO::getUserName).reversed()).toList();
            }
            else{
                throw new BadRequestException("Order " + order + " not recognized.");
            }
        }

        User user = repository.getUserById(userId);

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

        if (userIdToFollow == null ||userId == null || userIdToFollow < 0 || userId < 0 || userId.equals(userIdToFollow)) {
            throw new BadRequestException("Invalid IDs");
        }

        if (!repository.existId(userIdToFollow)){
            throw new BadRequestException("User to follow ID: " + userIdToFollow + " doesn't exist.");
        }

        User user = repository.getUserById(userId);
        User userToFollow = repository.getUserById(userIdToFollow);

        if (userToFollow.getPosts() == null || userToFollow.getPosts().isEmpty()){
            throw new BadRequestException("User to follow is not a seller");
        }

        if (user == null) {
            throw new BadRequestException("User ID: " + userId + " doesn't exist.");
        }

        if (user.getFollowedIds().contains(userIdToFollow)){
            throw new BadRequestException("User ID: " + userId + " already follows User ID: " + userIdToFollow);
        }

        user.addFollowedId(userIdToFollow);
        repository.updateUser(user);

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
