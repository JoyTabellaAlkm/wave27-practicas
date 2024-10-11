package com.sprint1.be_java_hisp_w27_g04.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseFollowersDTO {
    private Integer userID;
    private String userName;
    private List<FollowerDTO> followers;
}
