package ar.com.mercadolibre.test.util;

import org.modelmapper.ModelMapper;

public class Utils {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static <T, E> E changeDtoToEntity(T dto, Class<E> entityClass) {
        return modelMapper.map(dto, entityClass);
    }


    public static <T, E> E changeEntityToDTO(T dto, Class<E> entityClass){
        return modelMapper.map(dto, entityClass);
    }
}
