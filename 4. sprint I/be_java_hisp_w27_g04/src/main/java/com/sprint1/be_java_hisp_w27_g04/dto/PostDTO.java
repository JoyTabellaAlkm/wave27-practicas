package com.sprint1.be_java_hisp_w27_g04.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private int postId;
    private int userId;
    private double price;
    private double priceWithDiscount;
    private boolean hasPromo;
    private double discount;
}
