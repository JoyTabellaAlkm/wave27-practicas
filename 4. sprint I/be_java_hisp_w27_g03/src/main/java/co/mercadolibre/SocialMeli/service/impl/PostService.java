package co.mercadolibre.SocialMeli.service.impl;

import co.mercadolibre.SocialMeli.dto.request.PostRequestDTO;
import co.mercadolibre.SocialMeli.dto.response.PostResponseDTO;
import co.mercadolibre.SocialMeli.dto.response.RecentPostDTO;
import co.mercadolibre.SocialMeli.dto.response.ResponseDTO;
import co.mercadolibre.SocialMeli.entity.Post;
import co.mercadolibre.SocialMeli.entity.Product;
import co.mercadolibre.SocialMeli.entity.User;
import co.mercadolibre.SocialMeli.exception.BadRequestException;
import co.mercadolibre.SocialMeli.exception.NotFoundException;
import co.mercadolibre.SocialMeli.repository.impl.UsersRepository;
import co.mercadolibre.SocialMeli.service.IPostService;
import co.mercadolibre.SocialMeli.utils.GlobalMethods;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class PostService implements IPostService {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    GlobalMethods globalMethods;
    @Autowired
    ObjectMapper mapper;


    @Override
    public ResponseDTO createPost(PostRequestDTO postDTO) {
        mapper.registerModule(new JavaTimeModule());

        if (postDTO.getDate() == null || postDTO.getUserId() == 0
                || postDTO.getCategory() == 0 || postDTO.getPrice() == 0) {
            throw new BadRequestException("Formato de la request erroneo");
        }

        if (usersRepository.findAllUsers().isEmpty()) throw new NotFoundException("No hay usuarios registrados");

        Post post = mapper.convertValue(postDTO, Post.class);
        User user = globalMethods.getUserById(post.getUserId());


        if (user == null) {
            throw new NotFoundException("Usuario no encontrado");
        }
        if (!(globalMethods.verifyProduct(post.getProduct()))) {
            throw new NotFoundException("Producto no encontrado");
        }
        try {
            post.setPostId(globalMethods.getNewPostId(user));
            usersRepository.createPost(post, user);
            return new ResponseDTO("Post creado correctamente.", HttpStatus.OK);
        } catch (Exception e) {
            throw new BadRequestException("No se pudo crear el post");
        }
    }

    @Override
    public RecentPostDTO getPostsByFollowedUsersLastTwoWeeks(int userId, String order) {
        if (usersRepository.findAllUsers().isEmpty()) throw new NotFoundException("No hay usuarios registrados");

        if (globalMethods.getUserById(userId) == null) {
            throw new NotFoundException("Usuario no encontrado");
        }
        List<PostResponseDTO> postList = new ArrayList<>();
        List<User> userFollowedList = globalMethods.getUserById(userId).getFollowed();
        if (userFollowedList.isEmpty()) {
            throw new BadRequestException("El usuario no sigue a nadie.");
        }
        getPostsFromFollowedLastTwoWeeks(userFollowedList,postList);
        if (order != null) {
            if (order.equalsIgnoreCase("date_asc")) {
                postList.sort(Comparator.comparing(PostResponseDTO::getDate));
            } else if (order.equalsIgnoreCase("date_desc")) {
            } else {
                throw new BadRequestException("Orden no válido.");
            }
        }
        return new RecentPostDTO(userId, postList);
    }

    private void getPostsFromFollowedLastTwoWeeks(List<User> userFollowedList, List<PostResponseDTO> postList){
        LocalDate lastTwoWeeks = LocalDate.now().minusWeeks(2);
        for (User userFollowed : userFollowedList) {
            postList.addAll(userFollowed.getPosts().stream()
                    .filter(p -> p.getDate().isAfter(lastTwoWeeks))
                    .map(post -> mapper.convertValue(post, PostResponseDTO.class))
                    .sorted(Comparator.comparing(PostResponseDTO::getDate).reversed())
                    .toList());
        }

    }
}