package com.sprint1.be_java_hisp_w27_g04.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    @JsonProperty(value = "post_id")
    private int postId;
    @JsonProperty(value = "user_id")
    private int userId;
    private double price;
    @JsonProperty(value = "price_with_discount")
    private double priceWithDiscount;
    @JsonProperty(value = "has_promo")
    private boolean hasPromo;
    private double discount;
}
