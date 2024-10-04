package com.mercadolibre.calculadorametroscuadrados.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class HouseResponseDTO {
  private Integer squareFeet;
  private Integer price;
  private RoomDTO biggest;

  public HouseResponseDTO(HouseDTO house) {
    this.setName(house.getName());
    this.setAddress(house.getAddress());
    this.setRooms(house.getRooms());
  }

  private void setRooms(List<RoomDTO> rooms) {

  }

  private void setAddress(String address) {
  }

  private void setName(String name) {
  }

}
