package com.mercadolibre.student.util;

import org.modelmapper.ModelMapper;

public class Util {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static <T, E> E changeDtoToEntity(T dto, Class<E> entityClass) {
        return modelMapper.map(dto, entityClass);
    }
}
