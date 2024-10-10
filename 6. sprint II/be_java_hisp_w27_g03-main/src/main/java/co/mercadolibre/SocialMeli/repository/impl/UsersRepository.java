package co.mercadolibre.SocialMeli.repository.impl;

import co.mercadolibre.SocialMeli.entity.Post;
import co.mercadolibre.SocialMeli.entity.Product;
import co.mercadolibre.SocialMeli.entity.User;
import co.mercadolibre.SocialMeli.repository.IProductRepository;
import co.mercadolibre.SocialMeli.repository.IUsersRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        User userJohanna = new User(100,"Joy");
        User userMartin = new User(150, "Tincho");
        User userPepito = new User(400,"PepitoPerez");

        usersList.add(userJuanPerez);
        usersList.add(userLeandroDiaz);
        usersList.add(userAngelaGonzales);
        usersList.add(userAnita99);
        usersList.add(userFedericoV);
        usersList.add(userJohanna);
        usersList.add(userMartin);
        usersList.add(userPepito);

        Product mesedora = iProductRepository.findAllProducts().stream()
                .filter(p->p.getProductId()==1).findFirst().orElse(null);

        Product almohadaDeChayanne = iProductRepository.findAllProducts().stream()
                .filter(p -> p.getProductId() == 4).findFirst().orElse(null);

        Product mesa = iProductRepository.findAllProducts().stream()
                        .filter(p -> p.getProductId() == 5).findFirst().orElse(null);

        userJuanPerez.getPosts().add(new Post(1, userJuanPerez.getUserId(), LocalDate.parse("2024-10-03"),mesedora,1,223.3));
        userJuanPerez.getPosts().add(new Post(2, userJuanPerez.getUserId(), LocalDate.parse("2024-09-22"),almohadaDeChayanne,2,227.7));

        userMartin.getPosts().add(new Post(1,userMartin.getUserId(), LocalDate.parse("2024-10-05"), mesa,1,300.0));

        userPepito.getPosts().add(new Post(1,userPepito.getUserId(),LocalDate.parse("2021-10-03"), almohadaDeChayanne,4,200.0));

        //Usuario 2 sigue al usuario 1
        userLeandroDiaz.getFollowed().add(userJuanPerez);
        userJuanPerez.getFollowers().add(userLeandroDiaz);

        //Usuario 100 sigue al usuario 1
        userJohanna.getFollowed().add(userJuanPerez);
        userJuanPerez.getFollowers().add(userJohanna);

        //Usuario 100 sigue al usuario 150
        userJohanna.getFollowed().add(userMartin);
        userMartin.getFollowers().add(userJohanna);
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
