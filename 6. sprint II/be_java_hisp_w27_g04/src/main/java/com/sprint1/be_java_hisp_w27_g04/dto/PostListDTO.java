package com.sprint1.be_java_hisp_w27_g04.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sprint1.be_java_hisp_w27_g04.dto.request.PostRequestDTO;
import com.sprint1.be_java_hisp_w27_g04.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostListDTO {
    @JsonProperty("user_id")
    private int userId;
    private List<PostRequestDTO> posts;
}
