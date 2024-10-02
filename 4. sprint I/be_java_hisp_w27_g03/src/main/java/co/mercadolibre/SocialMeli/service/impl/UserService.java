package co.mercadolibre.SocialMeli.service.impl;

import co.mercadolibre.SocialMeli.dto.response.ClientFollowedDTO;
import co.mercadolibre.SocialMeli.dto.response.ResponseDTO;
import co.mercadolibre.SocialMeli.dto.response.UserDTO;
import co.mercadolibre.SocialMeli.entity.User;
import co.mercadolibre.SocialMeli.exception.BadRequestException;
import co.mercadolibre.SocialMeli.exception.NotFoundException;
import co.mercadolibre.SocialMeli.repository.IUsersRepository;
import co.mercadolibre.SocialMeli.service.IUserService;
import co.mercadolibre.SocialMeli.utils.GlobalMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.util.Comparator;
import java.util.List;
import java.util.Optional;


@Service
public class UserService implements IUserService {

    @Autowired
    GlobalMethods globalMethods;
    @Autowired
    IUsersRepository usersRepository;


    @Override
    public ResponseDTO followSeller(int userId, int userIdToFollow) {
        if (usersRepository.findAllUsers().isEmpty()) throw new NotFoundException("No hay usuarios registrados");

        User user = globalMethods.getUserById(userId);
        User seller = globalMethods.getUserById(userIdToFollow);

        //Validacion existencia de ids
        if (user == null){
            throw new NotFoundException("No existe un usuario con el id %d.".formatted(userId));
        }
        if (seller == null){
            throw new NotFoundException("No existe un vendedor con el id %d.".formatted(userIdToFollow));
        }

        //Validacion vendedor
        if(globalMethods.isNotSeller(seller)){
            throw new BadRequestException("El usuario %d no es un vendedor.".formatted(userIdToFollow));
        }

        //Validacion que usuario no se siga a el mismo
        if (user.equals(seller)) throw new BadRequestException("El usuario %d no se puede seguir a sí mismo.".formatted(userId));

        //Añadir usuario a la lista de seguidores
        List<User> followers = seller.getFollowers();

        //Validacion si usuario ya es seguidor del vendedor
        Optional<User> validationFollower = followers.stream()
                        .filter(v -> v.getUserId() == userId).findFirst();

        if (!validationFollower.isEmpty()) throw new BadRequestException("El usuario %d ya es seguidor del vendedor %d.".formatted(userId, userIdToFollow));

        followers.add(user);
        seller.setFollowers(followers);
        //Añadir vendedor a la lista de seguidos
        List<User> followed = user.getFollowed();
        followed.add(seller);
        user.setFollowed(followed);

        return new ResponseDTO("El usuario %d ha seguido de manera exitosa al vendedor %d.".formatted(userId,userIdToFollow), HttpStatus.OK);

    }

    @Override
    public ClientFollowedDTO listFollowedSellers(int userId, String order) {
        if (usersRepository.findAllUsers().isEmpty()) throw new NotFoundException("No hay usuarios registrados");

        User user =  globalMethods.getUserById(userId);
        if (user == null){
            throw new NotFoundException("Usuario con el id %d no se ha encontrado.".formatted(userId));
        }
        List<UserDTO> followedSellers = user.getFollowed().stream()
                .map(v -> new UserDTO(v.getUserId(), v.getUserName()))
                .toList();

        if (order != null && order.equals("name_asc")){
            return new ClientFollowedDTO(user.getUserId(),user.getUserName(), followedSellers.stream().sorted(Comparator.comparing(UserDTO::getUserName)).toList());
        } else if (order != null && order.equals("name_desc")){
            return new ClientFollowedDTO(user.getUserId(),user.getUserName(), followedSellers.stream().sorted(Comparator.comparing(UserDTO::getUserName).reversed()).toList());
        } else if(order != null){
            throw new BadRequestException("Ordenamiento invalido");
        }

        return new ClientFollowedDTO(user.getUserId(),user.getUserName(), followedSellers);
    }

    @Override
    public ResponseDTO unfollow(int userId, int userIdToUnfollow) {
        if (usersRepository.findAllUsers().isEmpty()) throw new NotFoundException("No hay usuarios registrados");

        User user = globalMethods.getUserById(userId);
        User seller = globalMethods.getUserById(userIdToUnfollow);
        if (user == null){
            throw new NotFoundException("No existe un usuario con el id %d.".formatted(userId));
        }
        if (seller == null){
            throw new NotFoundException("No existe un vendedor con el id %d.".formatted(userIdToUnfollow));
        }

        boolean validateFollower = seller.getFollowers().stream().anyMatch(u -> u.getUserId() == userId);
        if (!validateFollower) throw new BadRequestException("El usuario %d no es un seguidor de el vendedor %d".formatted(userId, userIdToUnfollow));

        //Eliminar usuario a la lista de seguidores
        List<User> followers = seller.getFollowers();
        followers.remove(user);
        seller.setFollowers(followers);
        //Eliminar vendedor a la lista de seguidos
        List<User> followed = user.getFollowed();
        followed.remove(seller);
        user.setFollowed(followed);

        return new ResponseDTO("El usuario %d ha dejado de seguir al vendedor %d.".formatted(userId,userIdToUnfollow), HttpStatus.OK);
    }

}
