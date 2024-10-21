package ar.com.mercadolibre.joyas.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;

public class Utils {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static <T, E> E changeDtoToEntity(T dto, Class<E> entityClass) {
        return modelMapper.map(dto, entityClass);
    }
}
