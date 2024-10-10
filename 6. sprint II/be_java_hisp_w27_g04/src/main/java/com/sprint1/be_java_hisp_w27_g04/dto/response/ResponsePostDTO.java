package com.sprint1.be_java_hisp_w27_g04.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sprint1.be_java_hisp_w27_g04.dto.request.ProductDTO;
import com.sprint1.be_java_hisp_w27_g04.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePostDTO {
    @JsonProperty(value = "post_id")
    private int postId;
    private ProductDTO product;
    private int category;
    private double price;
    @JsonProperty(value = "post_date")
    private LocalDate postDate;
    private double discount;
}
