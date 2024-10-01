package com.sprint1.be_java_hisp_w27_g04.dto.response;

import com.sprint1.be_java_hisp_w27_g04.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePostDTO {

    private int postId;
    private Product product;
    private int category;
    private double price;
    private LocalDate postDate;
    private double discount;
}
