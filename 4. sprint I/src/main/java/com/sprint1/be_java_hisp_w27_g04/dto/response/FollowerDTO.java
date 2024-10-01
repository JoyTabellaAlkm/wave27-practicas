package com.sprint1.be_java_hisp_w27_g04.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowerDTO {
    private Integer userId;
    private String userName;
}
