package ar.com.mercadolibre.socialmeli.utils;

import ar.com.mercadolibre.socialmeli.dto.request.PostRequestDTO;
import ar.com.mercadolibre.socialmeli.entity.Post;
import ar.com.mercadolibre.socialmeli.entity.Product;
import ar.com.mercadolibre.socialmeli.entity.User;
import org.modelmapper.ModelMapper;

import java.text.Normalizer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<User> createDefaultUsers(){

        List<User> users = new ArrayList<>();


        User user1 = new User(1, "Fernando Baldrich");
        User user2 = new User(2, "Matias Gregorat");
        user2.addFollowedId(4);
        User user3 = new User(3, "Stephanie Castillo");
        User user4 = new User(4, "Maria Emilia");
        User user5 = new User(5, "Delfina Glavas");
        user5.addFollowedId(2);
        user5.addFollowedId(4);

        Product product1 = new Product(1, "Silla gamer", "Gamer",  "Racer", "Red", "Special Edition");
        Post post1 = new Post(1, product1, LocalDate.of(2021, 9, 16), 100, 15000.00, false, 0.0 );

        Product product2 = new Product(2, "Teclado mecánico", "Periférico", "Logitech", "Negro", "RGB");
        Post post2 = new Post(2, product2, LocalDate.of(2024, 9, 17), 200, 5000.00, false, 0.0 );

        Product product3 = new Product(3, "Monitor 4K", "Monitor", "Samsung", "Negro", "Ultra HD");
        Post post3 = new Post(3, product3, LocalDate.of(2024, 9, 18), 300, 30000.00, true, 0.3);

        user2.addToPosts(post1);
        user2.addToPosts(post3);
        user4.addToPosts(post2);

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        return users;
    }

    public static Post changePostDtoToEntity(PostRequestDTO postRequestDTO){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(postRequestDTO, Post.class);
    }

    public static String removeAccents(String str){
        String string = Normalizer.normalize(str, Normalizer.Form.NFD);
        return string.replaceAll("[^\\p{ASCII}]", "");
    }

}
