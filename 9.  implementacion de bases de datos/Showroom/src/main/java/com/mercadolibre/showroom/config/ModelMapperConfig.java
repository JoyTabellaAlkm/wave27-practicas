package com.mercadolibre.showroom.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.mercadolibre.showroom.dto.PrendaResponseDTO;
import com.mercadolibre.showroom.entity.Prenda;
import org.modelmapper.PropertyMap;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();

        /*
        modelMapper.addMappings(new PropertyMap<Prenda, PrendaResponseDTO>() {
            @Override
            protected void configure() {
                map().setNombre(source.getNombre());
                map().setTipo(source.getTipo());
                map().setMarca(source.getMarca());
                map().setColor(source.getColor());
                map().setTalle(source.getTalle());
                map().setCantidad(source.getCantidad());
                map().setPrecioVenta(source.getPrecioVenta());
            }
        });
        */

        return modelMapper;
    }

}
