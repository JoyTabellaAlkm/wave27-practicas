package com.sprint1.be_java_hisp_w27_g04.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseUserDTO<T>{
    private T response;
    @JsonProperty(value = "status_code")
    private Integer statusCode;
}
