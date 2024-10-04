package co.mercadolibre.SocialMeli.service.impl;

import co.mercadolibre.SocialMeli.dto.response.CountFollowersDTO;
import co.mercadolibre.SocialMeli.dto.response.CountPostDTO;
import co.mercadolibre.SocialMeli.dto.response.SellerFollowersDTO;
import co.mercadolibre.SocialMeli.dto.response.SellerLastPostDTO;
import co.mercadolibre.SocialMeli.dto.response.UserDTO;
import co.mercadolibre.SocialMeli.entity.User;
import co.mercadolibre.SocialMeli.entity.Post;
import co.mercadolibre.SocialMeli.exception.BadRequestException;
import co.mercadolibre.SocialMeli.exception.NotFoundException;
import co.mercadolibre.SocialMeli.repository.impl.UsersRepository;
import co.mercadolibre.SocialMeli.service.ISellerService;
import co.mercadolibre.SocialMeli.utils.GlobalMethods;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Service
public class SellerService implements ISellerService {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    GlobalMethods globalMethods;
    @Autowired
    ObjectMapper mapper;

    @Override
    public CountFollowersDTO countFollowers(int userId) {
        User sellerToCheck = globalMethods.getUserById(userId);
        if (sellerToCheck == null){
            throw new NotFoundException("El usuario con el id %d no se ha encontrado".formatted(userId));
        }
        if (globalMethods.isNotSeller(sellerToCheck)){
            throw new NotFoundException("El usuario con el id %d no es un vendedor".formatted(userId));
        }
        return new CountFollowersDTO(sellerToCheck.getUserId(), sellerToCheck.getUserName(), sellerToCheck.getFollowers().size());
    }

    @Override
    public SellerFollowersDTO listFollowers(int userId, String order) {
        User sellerToCheck = globalMethods.getUserById(userId);
        if (sellerToCheck == null){
            throw new NotFoundException("El usuario con el id %d no se ha encontrado".formatted(userId));
        }
        if (globalMethods.isNotSeller(sellerToCheck)){
            throw new NotFoundException("El usuario con el id %d no es un vendedor".formatted(userId));
        }

        List<User> listOfFollowers;
        if (order == null){
            listOfFollowers = sellerToCheck.getFollowers();
        } else if (order.equals("name_asc")){
            listOfFollowers = sellerToCheck.getFollowers().stream()
                    .sorted(Comparator.comparing(User::getUserName)).toList();
        } else if (order.equals("name_desc")){
            listOfFollowers = sellerToCheck.getFollowers().stream()
                    .sorted(Comparator.comparing(User::getUserName)).toList().reversed();
        } else {
            throw new BadRequestException("Ordenamiento inválido");
        }
        List<UserDTO> listOfFollowersDTO = listOfFollowers.stream()
                .map(follower -> new UserDTO(follower.getUserId(), follower.getUserName())).toList();
        return new SellerFollowersDTO(sellerToCheck.getUserId(), sellerToCheck.getUserName(), listOfFollowersDTO);
    }

    @Override
    public List<CountPostDTO> listMostActiveSellers(){

        List<CountPostDTO> countPostDTOList = new ArrayList<>();

        List<User> usersListSorted = usersRepository.findAllUsers().stream().limit(5)
                .sorted(Comparator.comparing(user -> user.getPosts().size()))
                .toList().reversed();

        if (usersListSorted.isEmpty()){
            throw new NotFoundException("No hay usuarios registrados.");
        }

        for (User user: usersListSorted){
            if (!user.getPosts().isEmpty()) {
                countPostDTOList.add(new CountPostDTO(
                        user.getUserId(),
                        user.getUserName(),
                        user.getPosts().size()
                ));
            }
        }

        if (countPostDTOList.isEmpty()){
            throw new NotFoundException("No hay usuarios con posts.");
        }

        return countPostDTOList;
    }

    @Override
    public List<SellerLastPostDTO> inactiveSeller() {
        if (usersRepository.findAllUsers().isEmpty()) throw new NotFoundException("No hay usuarios registrados");

        LocalDate lastSixMonths = LocalDate.now().minusMonths(6);
        List<User> inactiveList = usersRepository.findAllUsers().stream()
                .filter(user -> !globalMethods.isNotSeller(user))
                .filter(seller -> seller.getPosts().stream()
                        .noneMatch(post -> post.getDate().isAfter(lastSixMonths)))
                .toList();
        if (inactiveList.isEmpty()){
            throw new NotFoundException("No se encontraron usuarios inactivos en los últimos 6 meses");
        }
        return inactiveList.stream().map(seller -> new SellerLastPostDTO(seller.getUserId(),
                seller.getUserName(),
                seller.getPosts().stream().max(Comparator.comparing(Post::getDate)).orElse(null).getDate()
        )).toList();
    }

}
