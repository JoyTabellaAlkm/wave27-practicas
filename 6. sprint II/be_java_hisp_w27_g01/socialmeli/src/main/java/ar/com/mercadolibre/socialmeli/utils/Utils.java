package ar.com.mercadolibre.socialmeli.utils;

import ar.com.mercadolibre.socialmeli.entity.Post;
import ar.com.mercadolibre.socialmeli.entity.Product;
import ar.com.mercadolibre.socialmeli.entity.User;
import org.modelmapper.ModelMapper;

import java.text.Normalizer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static List<User> createDefaultUsers(){

        List<User> users = new ArrayList<>();


        User user1 = new User(1, "Fernando Baldrich");
        User user2 = new User(2, "Matias Gregorat");
        user2.addFollowedId(4);
        User user3 = new User(3, "Stephanie Castillo");
        User user4 = new User(4, "Maria Emilia");
        User user5 = new User(5, "Delfina Glavas");
        User user6 = new User(6, "Leandro");
        user5.addFollowedId(2);
        user5.addFollowedId(4);
        user1.addFollowedId(3);

        Product product1 = new Product(1, "Silla gamer", "Gamer",  "Racer", "Red", "Special Edition");
        Post post1 = new Post(1, product1, LocalDate.of(2021, 9, 28), 100, 15000.00, false, 0.0 );

        Product product2 = new Product(3, "Monitor 4K", "Monitor", "Samsung", "Negro", "Ultra HD");
        Post post2 = new Post(2, product2, LocalDate.of(2024, 9, 27), 300, 30000.00, true, 0.3);


        Product product3 = new Product(2, "Teclado mecánico", "Periférico", "Logitech", "Negro", "RGB");
        Post post3 = new Post(1, product3, LocalDate.of(2024, 9, 29), 200, 5000.00, false, 0.0 );

        Product product4 = new Product(2, "Teclado mecánico", "Periférico", "Logitech", "Rojo", "RGB");
        Post post4 = new Post(1, product4, LocalDate.of(2024, 6, 29), 200, 5000.00, false, 0.0 );


        user2.addToPosts(post1);
        user2.addToPosts(post2);
        user4.addToPosts(post3);
        user3.addToPosts(post4);

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        return users;
    }

    public static String removeAccents(String str){
        String string = Normalizer.normalize(str, Normalizer.Form.NFD);
        return string.replaceAll("[^\\p{ASCII}]", "");
    }

    public static <T, E> E changeDtoToEntity(T dto, Class<E> entityClass) {
        return modelMapper.map(dto, entityClass);
    }

    public static <T, E> E changeEntityToDTO(T entity, Class<E> DTOClass) {
        return modelMapper.map(entity, DTOClass);
    }
}
