package ar.com.mercadolibre.socialmeli2.utils;

import ar.com.mercadolibre.socialmeli2.dto.requests.ProductDto;
import ar.com.mercadolibre.socialmeli2.dto.requests.PromoPostDto;
import ar.com.mercadolibre.socialmeli2.entity.Follow;
import ar.com.mercadolibre.socialmeli2.entity.Post;
import ar.com.mercadolibre.socialmeli2.entity.Product;
import ar.com.mercadolibre.socialmeli2.entity.User;

import java.time.LocalDate;

import java.time.LocalDate;
import java.util.List;

public class TestUtils {

    /**
     * Creates a list of Follow objects representing the follow relationships between users.
     * <p>
     * Juan Perez has 2 followers, Pedro Gomez and Ana Rodriguez.
     * <p>
     * Maria Lopez has 1 follower, Pedro Gomez.
     * <p>
     * Carlos Marquez has 1 follower, Pedro Gomez.
     *
     *  @return a list of Follow objects
     */
    public static List<Follow> createUserFollows() {
        List<User> sellers = List.of(
                new User(1, "Juan Perez", true),
                new User(2, "Maria Lopez", true),
                new User(3, "Carlos Marquez", true));

        User follower1 = new User(4, "Pedro Gomez");
        User follower2 = new User(5, "Ana Rodriguez");

        return List.of(
                new Follow(follower1, sellers.get(0)),
                new Follow(follower1, sellers.get(1)),
                new Follow(follower1, sellers.get(2)),
                new Follow(follower2, sellers.get(0))
        );
    }

    public static PromoPostDto createPromoPostDto() {
        ProductDto productDto = new ProductDto(
                1,
                "Silla",
                "Gamer",
                "Racer",
                "Rojo",
                "Special Edition"
        );

        return new PromoPostDto(
                1,
                LocalDate.now(),
                productDto,
                456,
                15000.0,
                true,
                20.0
        );
    }

    public static PromoPostDto createPromoPostDtoIncorrect() {
        ProductDto productDto = new ProductDto(
                null,
                "",
                "",
                "",
                "",
                "&"
        );

        return new PromoPostDto(
                null,
                null,
                productDto,
                0,
                -1.0,
                null,
                0.0
        );
    }

    public static Post createPromoPost() {

        Product product = new Product(
                1,
                "Silla",
                "Gamer",
                "Racer",
                "Rojo",
                "Special Edition"
        );

        return new Post(
                1,
                new User(1, "Juan Perez", true),
                product,
                LocalDate.now(),
                456,
                true,
                20.0
        );
    }
}
