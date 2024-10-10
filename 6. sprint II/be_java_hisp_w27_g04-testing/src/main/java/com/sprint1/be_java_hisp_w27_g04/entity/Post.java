package com.sprint1.be_java_hisp_w27_g04.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sprint1.be_java_hisp_w27_g04.dto.request.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private int postId;
    private int userId;
    private Product product;
    private int category;
    private double price;
    private LocalDate postDate;
    private boolean hasPromo;
    private double discount;

}
