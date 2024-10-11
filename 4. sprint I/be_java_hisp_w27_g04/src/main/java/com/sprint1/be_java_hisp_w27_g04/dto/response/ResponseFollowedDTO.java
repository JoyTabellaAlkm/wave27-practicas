package com.sprint1.be_java_hisp_w27_g04.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseFollowedDTO {
    private Integer userID;
    private String userName;
    private List<FollowedDTO> followed;
}
