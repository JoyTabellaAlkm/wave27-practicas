package co.mercadolibre.SocialMeli.service.impl;

import co.mercadolibre.SocialMeli.dto.request.PostRequestDTO;
import co.mercadolibre.SocialMeli.dto.response.PostResponseDTO;
import co.mercadolibre.SocialMeli.dto.response.RecentPostDTO;
import co.mercadolibre.SocialMeli.dto.response.ResponseDTO;
import co.mercadolibre.SocialMeli.entity.Post;
import co.mercadolibre.SocialMeli.entity.User;
import co.mercadolibre.SocialMeli.exception.BadRequestException;
import co.mercadolibre.SocialMeli.exception.NotFoundException;
import co.mercadolibre.SocialMeli.repository.IUsersRepository;
import co.mercadolibre.SocialMeli.service.IPostService;
import co.mercadolibre.SocialMeli.utils.GlobalMethods;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    IUsersRepository usersRepository;
    @Autowired
    GlobalMethods globalMethods;
    @Autowired
    ObjectMapper mapper;


    @Override
    public ResponseDTO createPost(PostRequestDTO postDTO) {
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

        LocalDate lastTwoWeeks = LocalDate.now().minusWeeks(2);
        for (User userFollowed : userFollowedList) {
            postList.addAll(userFollowed.getPosts().stream()
                    .filter(p -> p.getDate().isAfter(lastTwoWeeks))
                    .map(post -> mapper.convertValue(post, PostResponseDTO.class))

                    .toList());
        }
        postList.sort(Comparator.comparing(PostResponseDTO::getDate).reversed());

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

}



