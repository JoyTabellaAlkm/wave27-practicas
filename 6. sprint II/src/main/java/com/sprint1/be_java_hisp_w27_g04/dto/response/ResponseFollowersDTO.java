package com.sprint1.be_java_hisp_w27_g04.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseFollowersDTO {
    @JsonProperty(value = "user_id")
    private Integer userID;
    @JsonProperty(value = "user_name")
    private String userName;
    private List<FollowerDTO> followers;
}
