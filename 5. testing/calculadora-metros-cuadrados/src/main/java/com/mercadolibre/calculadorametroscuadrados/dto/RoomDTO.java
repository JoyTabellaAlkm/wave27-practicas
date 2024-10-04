package com.mercadolibre.calculadorametroscuadrados.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class RoomDTO {
  private String name;
  private Integer width;
  private Integer length;

  public Integer getSquareFeet() {
    int result = 0;
    if(this.width != null && this.length != null)
      result = this.width * this.length;
    return result;
  }
}
