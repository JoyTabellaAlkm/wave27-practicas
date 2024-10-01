package com.sprint1.be_java_hisp_w27_g04.service.impl;

import com.sprint1.be_java_hisp_w27_g04.dto.request.PostPromotionDTO;
import com.sprint1.be_java_hisp_w27_g04.dto.PostListDTO;
import com.sprint1.be_java_hisp_w27_g04.dto.response.ListOfPostsWithPromotionDTO;
import com.sprint1.be_java_hisp_w27_g04.dto.PostDTO;
import com.sprint1.be_java_hisp_w27_g04.dto.response.PostNoPromoDTO;
import com.sprint1.be_java_hisp_w27_g04.dto.response.QuantityOfPostsWithPromotionDTO;
import com.sprint1.be_java_hisp_w27_g04.dto.response.ResponseDTO;
import com.sprint1.be_java_hisp_w27_g04.entity.Post;
import com.sprint1.be_java_hisp_w27_g04.entity.User;
import com.sprint1.be_java_hisp_w27_g04.exceptions.NotFoundException;
import com.sprint1.be_java_hisp_w27_g04.exceptions.NotInPromotion;
import com.sprint1.be_java_hisp_w27_g04.repository.IPostRepository;
import com.sprint1.be_java_hisp_w27_g04.repository.IUserRepository;
import com.sprint1.be_java_hisp_w27_g04.dto.request.PostRequestDTO;
import com.sprint1.be_java_hisp_w27_g04.service.IProductsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.util.*;

@Service
public class ProductsServiceImpl implements IProductsService {

    @Autowired
    IPostRepository postRepository;
    @Autowired
    IUserRepository userRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public void newPost(PostRequestDTO dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new NotFoundException("No existe usuario con ese id"));

        Post post = modelMapper.map(dto, Post.class);
        post.setDiscount(0);
        post.setHasPromo(false);
        user.addPost(post);
        postRepository.save(post);
    }

    @Override
    public ResponseDTO createPostWithPromotion(PostPromotionDTO postPromotionDTO) {
        User user = userRepository.findById(postPromotionDTO.getUserId())
                .orElseThrow(() -> new NotFoundException("No existe usuario con ese id"));
        Post post = modelMapper.map(postPromotionDTO, Post.class);
        post.setHasPromo(true);

        user.addPost(post);
        postRepository.save(post);

        ResponseDTO responseDTO = new ResponseDTO("201",
                "Se ha creado el post con la promoción exitosamente. ID: " + post.getPostId());

        return responseDTO;
    }

    @Override
    public QuantityOfPostsWithPromotionDTO countAllPostWithPromoFromUser(Integer userId) {

        User user = getUserFromRepository(userId);
        Set<Post> posts = user.getPosts();

        posts = new HashSet<>(posts.stream().filter(Post::isHasPromo).toList());

        int quantity = posts.size();

        QuantityOfPostsWithPromotionDTO response =
                new QuantityOfPostsWithPromotionDTO(String.valueOf(user.getId()),
                        user.getName(),
                        quantity
                );

        return response;
    }

    @Override
    public ListOfPostsWithPromotionDTO getAllPostWithPromoFromUser(Integer userId) {

        User user = getUserFromRepository(userId);
        Set<Post> posts = user.getPosts();

        posts = new HashSet<>(posts.stream().filter(Post::isHasPromo).toList());

        Set<PostRequestDTO> postsDTO = posts.stream()
                .map(post -> modelMapper.map(post, PostRequestDTO.class))
                .collect(Collectors.toSet());

        ListOfPostsWithPromotionDTO response = new ListOfPostsWithPromotionDTO();
        response.setUserId(user.getId());
        response.setUserName(user.getName());
        response.setPosts(postsDTO);

        return response;
    }

    @Override
    public PostListDTO getPostList(int userId, String order) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("El usuario no existe"));
        Set<Integer> followed = user.getFollowed();
        Set<User> userList = userRepository.findAll().stream().filter(x -> followed.contains(x.getId())).collect(Collectors.toSet());
        List<Post> followedPosts = new ArrayList<>();
        getPostsFromFollowedUsers(userList, followedPosts);
        followedPosts = validationOrderPostList(order, followedPosts);
        List<PostRequestDTO> postRequestDTOs = mapperToPostRequestDto(followedPosts);
        return new PostListDTO(userId, postRequestDTOs);
    }


    @Override
    public PostDTO applyDiscountToPost(Integer postId, Double discount) {
        if (discount < 0) {
            throw new IllegalArgumentException("El descuento no puede ser negativo.");
        }

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException("No existe post con ese id"));

        double currentPrice = post.getPrice();
        double currentDiscount = post.getDiscount();

        double newPrice = currentPrice - currentDiscount - discount;

        post.setDiscount(currentDiscount + discount);
        post.setHasPromo(true);
        post.setPrice(newPrice);

        PostDTO postDTO = modelMapper.map(post, PostDTO.class);
        postDTO.setPriceWithDiscount(newPrice);

        return postDTO;
    }

    @Override
    public List<PostPromotionDTO> getPostsByPrices(int minPrice, int maxPrice) {
        List<Post> filteredPosts= postRepository.findAll().stream().filter(post -> post.getPrice() >= minPrice && post.getPrice() <= maxPrice).toList();
        if(filteredPosts.isEmpty()) throw new NotFoundException("No se encontradon publicaciones entre ese rango de precios");
        List<PostPromotionDTO> dto = filteredPosts.stream().map(post ->
                modelMapper.map(post, PostPromotionDTO.class)).toList();
        return dto;
    }

    @Override
    public PostNoPromoDTO finishPromotion(int postId) {
        Post post = postRepository.findById(postId).orElseThrow(()-> new NotFoundException("El post no existe"));

        if(!post.isHasPromo()) throw new NotInPromotion("Este post no posee una promocion");

        post.setHasPromo(false);
        post.setDiscount(0d);

        PostNoPromoDTO postDTO = modelMapper.map(post,PostNoPromoDTO.class);
        return postDTO;
    }

    @Override
    public ResponseDTO deletePost(int postId) {
       List<User> user = userRepository.findAll();
       Post post = postRepository.findById(postId).orElseThrow(
               () -> new NotFoundException("No se encontró ese post")
       );
       postRepository.delete(post);
       user.forEach(user1 -> user1.getPosts().removeIf(post1 -> post1.getPostId()== postId));
       return new ResponseDTO("200","Eliminado con exito");
    }

    private List<Post> validationOrderPostList(String order, List<Post> followedPosts) {

        if (order == null || order.equals("date_asc")) {
            followedPosts = followedPosts.stream().sorted(Comparator.comparing(Post::getPostDate)).toList();
        } else if (order.equals("date_desc")) {
            followedPosts = followedPosts.stream().sorted(Comparator.comparing(Post::getPostDate).reversed()).toList();
        }

        return followedPosts;
    }


    private void getPostsFromFollowedUsers(Set<User> followed, List<Post> followedPosts) {
        for (User user1 : followed) {
            LocalDate localDate = LocalDate.now().minusWeeks(2);
            List<Post> posts = user1.getPosts().stream().filter(post ->
                    post.getPostDate().isAfter(localDate)).toList();
            followedPosts.addAll(posts);
        }
    }

    private List<PostRequestDTO> mapperToPostRequestDto(List<Post> followedPosts) {
        List<PostRequestDTO> postRequestDTOs = new ArrayList<>();
        for (Post post : followedPosts) {
            postRequestDTOs.add(modelMapper.map(post, PostRequestDTO.class));
        }
        return postRequestDTOs;
    }

    private User getUserFromRepository(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("No existe usuario con ese id"));
    }
}