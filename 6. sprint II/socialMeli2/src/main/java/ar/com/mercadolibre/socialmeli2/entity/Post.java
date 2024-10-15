package ar.com.mercadolibre.socialmeli2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Post {
    private int id;
    private User user;
    private Product product;
    private LocalDate date;
    private double price;
    private boolean hasPromo;
    private double discount;

    public Post(User user, Product product, LocalDate date, double price) {
        this.id = 0;
        this.user = user;
        this.product = product;
        this.date = date;
        this.price = price;
        this.hasPromo = false;
        this.discount = 0.0;
    }
}


