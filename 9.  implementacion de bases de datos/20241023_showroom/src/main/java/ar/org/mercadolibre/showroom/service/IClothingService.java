package ar.org.mercadolibre.showroom.service;

import ar.org.mercadolibre.showroom.dto.ClothingDTO;
import ar.org.mercadolibre.showroom.model.Clothing;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

public interface IClothingService {
    ClothingDTO addClouthing(ClothingDTO clothingdto);
    List<ClothingDTO> getAllClothes(String size, String clothingName);
    ClothingDTO getClothingByCode(long code);
    ClothingDTO updateClothing(long code, ClothingDTO clothingDTO);
    String deleteClothing(long code, ClothingDTO clothingDTO);

    List<ClothingDTO> getAllsClothingBySaleDate(LocalDate date) ;

    List<ClothingDTO> getClothingsBySaleNumber(Long number);
}
