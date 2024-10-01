package ar.com.mercadolibre.socialmeli2.service.impl;

import ar.com.mercadolibre.socialmeli2.dto.*;
import ar.com.mercadolibre.socialmeli2.entity.Follow;
import ar.com.mercadolibre.socialmeli2.entity.User;
import ar.com.mercadolibre.socialmeli2.exception.NotFoundException;
import ar.com.mercadolibre.socialmeli2.exception.ValidationException;
import ar.com.mercadolibre.socialmeli2.repository.IFollowRepository;
import ar.com.mercadolibre.socialmeli2.repository.IPostRepository;
import ar.com.mercadolibre.socialmeli2.repository.IUserRepository;
import ar.com.mercadolibre.socialmeli2.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    private final IUserRepository userRepository;
    private final IFollowRepository followRepository;
    private final IPostRepository postRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(IUserRepository userRepository, IFollowRepository followRepository, IPostRepository postRepository) {
        this.userRepository = userRepository;
        this.followRepository = followRepository;
        this.postRepository = postRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public FollowDto followUser(int userId, int userIdToFollow) {
        if (userId == userIdToFollow) {
            throw new ValidationException("User " + userId + " can't follow himself");
        }

        User user = userRepository.findById(userId).orElseThrow(
                () -> new NotFoundException("User " + userId + " not found"));

        User userToFollow = userRepository.findById(userIdToFollow).orElseThrow(
                () -> new NotFoundException("User " + userIdToFollow + " not found"));

        if (!userToFollow.isSeller()) {
            throw new ValidationException("User " + userIdToFollow + " is not a seller");
        }

        followRepository.findFollowsByFollowerId(userId).stream()
                .filter(follow -> follow.getUserToFollow().getId() == userIdToFollow)
                .findFirst()
                .ifPresent(follow -> {
                    throw new ValidationException("User " + userId + " already follows user " + userIdToFollow);
                });

        Follow follow = new Follow(user, userToFollow);
        followRepository.save(follow);

        return new FollowDto(user.getId(), userToFollow.getId());
    }

    @Override
    public UserFollowedDto findAllFollowed(int userId, String order) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new NotFoundException("User " + userId + " not found"));

        List<Follow> follows = followRepository.findFollowsByFollowerId(userId);

        List<UserDto> followedSellers = follows.stream()
                .map(Follow::getUserToFollow)
                .map(followed -> new UserDto(followed.getId(), followed.getUsername()))
                .toList();
        if (order != null) {
            followedSellers = sortUserName(followedSellers, order);
        }

        return new UserFollowedDto(user.getId(), user.getUsername(), followedSellers);
    }

    public FollowersCountDto countFollowers(int userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new NotFoundException("User " + userId + " not found"));
        if (!user.isSeller()) {
            throw new ValidationException("User " + userId + " is not a seller");
        }

        List<Follow> followers = followRepository.findFollowsByFollowedId(userId);
        return new FollowersCountDto(user.getId(), user.getUsername(), followers.size());
    }

    @Override
    public UserWithFollowersDto findAllFollowers(int userId, String order) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new NotFoundException("User " + userId + " not found"));

        if (!user.isSeller()) {
            throw new ValidationException("User " + userId + " is not a seller");
        }

        UserWithFollowersDto userDto = modelMapper.map(user, UserWithFollowersDto.class);

        List<Follow> followersById = followRepository.findFollowsByFollowedId(userId);

        List<UserDto> followers = followersById.stream()
                .map(follow -> new UserDto(follow.getUser().getId(), follow.getUser().getUsername()))
                .toList();

        if (order != null) {
            followers = sortUserName(followers, order);
        }

        userDto.setFollowers(followers);
        return userDto;
    }

    @Override
    public List<Top10UserDto> findTop10Users() {
        return userRepository.findAll().stream()
                .filter(User::isSeller)
                .map(user -> new Top10UserDto(
                        user.getId(),
                        user.getUsername(),
                        followRepository.findFollowsByFollowedId(user.getId()).size(),
                        postRepository.findByUserId(user.getId()).size()))
                .sorted(
                        Comparator.comparing(Top10UserDto::getFollowersCount)
                                .thenComparing(Top10UserDto::getPostsCount).reversed())
                .limit(10)
                .toList();
    }

    @Override
    public FollowDto unfollowUser(int userId, int userIdToUnfollow) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new NotFoundException("User " + userId + " not found"));
        User userToUnfollow = userRepository.findById(userIdToUnfollow).orElseThrow(
                () -> new NotFoundException("User " + userIdToUnfollow + " not found"));

        if (!followRepository.isFollowing(userId, userIdToUnfollow)) {
            throw new NotFoundException("User " + userId + " does not follow user " + userIdToUnfollow);
        }

        followRepository.unfollowUser(new Follow(user, userToUnfollow));

        return new FollowDto(user.getId(), userToUnfollow.getId());
    }

    private List<UserDto> sortUserName(List<UserDto> userDtos, String order) {
        if (order.equals("name_asc")) {
            return userDtos.stream()
                    .sorted(Comparator.comparing(UserDto::getUsername))
                    .toList();
        } else if (order.equals("name_desc")) {
            return userDtos.stream()
                    .sorted(Comparator.comparing(UserDto::getUsername).reversed())
                    .toList();
        } else {
            throw new ValidationException("Cannot order by " + order);
        }
    }
}
