package co.mercadolibre.SocialMeli.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @JsonProperty("post_id")
    private  int postId;
    @JsonProperty("user_id")
    private int userId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private  Product product;
    private int category;
    private double price;
    @JsonProperty("has_promo")
    private boolean hasPromo;
    private double discount;

    public Post(int postId, int userId, LocalDate date, Product product, int category, double price) {
        this.postId = postId;
        this.userId = userId;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
        this.hasPromo = false;
        this.discount = 0;
    }
}
