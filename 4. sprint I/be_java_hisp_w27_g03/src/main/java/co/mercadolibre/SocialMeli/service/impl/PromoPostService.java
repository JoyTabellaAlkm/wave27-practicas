package co.mercadolibre.SocialMeli.service.impl;

import co.mercadolibre.SocialMeli.dto.request.PromoPostRequestDTO;
import co.mercadolibre.SocialMeli.dto.response.CountPromoPostDTO;
import co.mercadolibre.SocialMeli.dto.response.ResponseDTO;
import co.mercadolibre.SocialMeli.entity.Post;
import co.mercadolibre.SocialMeli.entity.User;
import co.mercadolibre.SocialMeli.exception.BadRequestException;
import co.mercadolibre.SocialMeli.exception.NotFoundException;
import co.mercadolibre.SocialMeli.repository.impl.UsersRepository;
import co.mercadolibre.SocialMeli.service.IPromoPostService;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import co.mercadolibre.SocialMeli.utils.GlobalMethods;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class PromoPostService implements IPromoPostService {
    @Autowired
    UsersRepository usersRepository;

    @Autowired
    GlobalMethods globalMethods;

    @Autowired
    ObjectMapper mapper;

    @Override
    public ResponseDTO postPromotion(PromoPostRequestDTO promoPostRequestDTO) {

        if(usersRepository.findAllUsers().isEmpty()){
            throw new NotFoundException("No hay usuarios registrados.");
        }

        if(promoPostRequestDTO.getDate() == null || promoPostRequestDTO.getUserId() == 0
                || promoPostRequestDTO.getCategory() == 0 || promoPostRequestDTO.getPrice() == 0){
            throw new BadRequestException("Formato de la request erroneo.");
        }

        Post post = mapper.convertValue(promoPostRequestDTO, Post.class);


        User user = usersRepository.findAllUsers().stream()
                .filter(p->p.getUserId()==promoPostRequestDTO.getUserId())
                .findFirst().orElse(null);

        if(user == null){
            throw new NotFoundException("El usuario suministrado no existe");
        }

        if( !(globalMethods.verifyProduct(post.getProduct())) ){
            throw new NotFoundException("Producto no encontrado");
        }

        usersRepository.createPost(post, user);
        return new ResponseDTO(
                "Promocion creada: "+promoPostRequestDTO.getProduct().getProductName()+" por "+user.getUserName(),
                HttpStatus.OK);
    }

    @Override
    public CountPromoPostDTO countPromoPostUser(String userId) {

        int userIdInt;

        try {
            userIdInt = Integer.parseInt(userId);
        } catch (NumberFormatException e) {
            throw new BadRequestException("Parametros incorrectos");
        }

        if (usersRepository.findAllUsers().isEmpty()) throw new NotFoundException("No hay usuarios registrados");

        User user = usersRepository.findAllUsers().stream().filter(p -> p.getUserId() == userIdInt).findFirst().orElse(null);

        if (user == null){
            throw new NotFoundException("Usuario no encontrado");
        }

        if (user.getPosts().isEmpty()) throw new BadRequestException("El usuario %d no es un vendedor".formatted(userIdInt));



        return new CountPromoPostDTO(
                user.getUserId(),
                user.getUserName(),
                user.getPosts().stream().filter(Post::isHasPromo).count()
        );

    }
}
