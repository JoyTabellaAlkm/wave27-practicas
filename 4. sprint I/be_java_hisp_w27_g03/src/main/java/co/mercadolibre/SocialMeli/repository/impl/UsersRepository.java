package co.mercadolibre.SocialMeli.repository.impl;

import ch.qos.logback.core.net.DefaultSocketConnector;
import co.mercadolibre.SocialMeli.entity.Post;
import co.mercadolibre.SocialMeli.entity.Product;
import co.mercadolibre.SocialMeli.entity.User;
import co.mercadolibre.SocialMeli.repository.IProductRepository;
import co.mercadolibre.SocialMeli.repository.IUsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.aot.hint.TypeReference.listOf;

@Repository
public class UsersRepository implements IUsersRepository {

    private IProductRepository iProductRepository;
    private List<User> usersList = new ArrayList<>();

    public UsersRepository(List<User> usersList, ProductRepository productRepository) {
        this.iProductRepository = productRepository;
        fillUsers();
    }

    public void fillUsers(){

        User userJuanPerez = new User(1,"JuanPerez");
        User userLeandroDiaz = new User(2,"LeandroDiaz");
        User userAngelaGonzales = new User(3,"AngelaGonzales");
        User userAnita99 = new User(4,"Anita99");
        User userFedericoV = new User(5,"FedericoV");

        usersList.add(userJuanPerez);
        usersList.add(userLeandroDiaz);
        usersList.add(userAngelaGonzales);
        usersList.add(userAnita99);
        usersList.add(userFedericoV);

        Product sillaGamer = iProductRepository.findAllProducts().stream()
                .filter(p->p.getProductId()==1).findFirst().orElse(null);

        Product almohadaDeChayanne = iProductRepository.findAllProducts().stream()
                .filter(p -> p.getProductId() == 4).findFirst().orElse(null);

        userJuanPerez.getPosts().add(new Post(1, userJuanPerez.getUserId(), LocalDate.parse("2024-09-22"),sillaGamer,1,223.3));
        userJuanPerez.getPosts().add(new Post(2, userJuanPerez.getUserId(), LocalDate.now(),almohadaDeChayanne,2,227.7));

    }

    @Override
    public List<User> findAllUsers() {
        return usersList;
    }

    @Override
    public void createPost(Post post, User user) {
        user.getPosts().add(post);
    }

}
