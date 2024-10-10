package com.sprint1.be_java_hisp_w27_g04.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowedDTO {
    @JsonProperty(value = "user_id")
    private Integer userId;
    @JsonProperty(value = "user_name")
    private String userName;
}
