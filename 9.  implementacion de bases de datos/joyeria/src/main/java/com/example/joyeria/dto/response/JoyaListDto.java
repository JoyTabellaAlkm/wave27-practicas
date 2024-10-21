package com.example.joyeria.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JoyaListDto {
    @JsonProperty("lista_joyas")
    public List<JoyaDto> joyaList;
}
