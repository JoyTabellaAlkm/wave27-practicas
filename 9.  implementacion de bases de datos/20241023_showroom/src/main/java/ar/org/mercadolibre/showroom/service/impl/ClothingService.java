package ar.org.mercadolibre.showroom.service.impl;

import ar.org.mercadolibre.showroom.dto.ClothingDTO;
import ar.org.mercadolibre.showroom.model.Clothing;
import ar.org.mercadolibre.showroom.repository.ClothingRepository;
import ar.org.mercadolibre.showroom.service.IClothingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClothingService implements IClothingService {
    @Autowired
    ClothingRepository clothingRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ClothingDTO addClouthing(ClothingDTO clothingdto) {
        Clothing clothing= modelMapper.map(clothingdto, Clothing.class);
        Clothing newClothing= clothingRepository.save(clothing);
        return modelMapper.map(newClothing, ClothingDTO.class);
    }

    //ver exceptions
    @Override
    public List<ClothingDTO> getAllClothes(String size, String name) {
        List<Clothing> list=new ArrayList<>();

        // Si ambos parámetros son nulos, se obtienen todos los elementos
        if (size == null && name == null) {
            list = clothingRepository.findAll();
       }
        if (size != null  ) {
            // Si solo se proporciona el tamaño
            list = clothingRepository.findClothingBySize(size);
        }
        if (name != null  ) { // Solo se proporciona el nombre de la ropa
            list = clothingRepository.findClothingByNameContainingIgnoreCase(name);
        }

        return list.stream()
                .map(l -> modelMapper.map(l, ClothingDTO.class))
                .toList();
    }

    @Override
    public ClothingDTO getClothingByCode(long code) {
        Clothing c= clothingRepository.findById(code).orElse(null); //agregar excepciones
        return modelMapper.map(c, ClothingDTO.class);
    }

    // VER CODIGO
    @Override
    public ClothingDTO updateClothing(long code, ClothingDTO clothingDTO) {
        Clothing clothing= modelMapper.map(clothingDTO, Clothing.class);
        clothing.setCode(code);
        Clothing newClothing= clothingRepository.save(clothing);
        return modelMapper.map(newClothing, ClothingDTO.class);
    }

    @Override
    public String deleteClothing(long code, ClothingDTO clothingDTO) {
        Clothing clothing= modelMapper.map(clothingDTO, Clothing.class);
        clothing.setCode(code);
        clothingRepository.delete(clothing);
        Clothing c= clothingRepository.findById(code).orElse(null);
         if (c==null)return "Delete ok";
         else return "No ok"; //usar exceptions
    }


    @Override
    public List<ClothingDTO> getAllsClothingBySaleDate(LocalDate date) {
        List<Clothing> clothings= clothingRepository.findClothingBySalesDate(date);
        return clothings.stream().map(c-> modelMapper.map(c,ClothingDTO.class)).toList();
    }

    @Override
    public List<ClothingDTO> getClothingsBySaleNumber(Long number) {
        List<Clothing> clothings= clothingRepository.findAllBySales_id(number);
        return clothings.stream().map(c-> modelMapper.map(c,ClothingDTO.class)).toList();

    }

}
