package com.sprint1.be_java_hisp_w27_g04.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sprint1.be_java_hisp_w27_g04.dto.PostDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePostDiscountDTO {

    private String response;
    @JsonProperty(value = "status_code")
    private Integer statusCode;
    @JsonProperty(value = "updated_post")
    private PostDTO updatedPost;


    public ResponsePostDiscountDTO(String s, int value, PostDTO updatedPostDTO) {
        this.response = s;
        this.statusCode = value;
        this.updatedPost = updatedPostDTO;
    }
}
