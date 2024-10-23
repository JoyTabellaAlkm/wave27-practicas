package com.mercadolibre.productos.service;

import com.mercadolibre.productos.dto.request.ProductoRequestDto;
import com.mercadolibre.productos.dto.response.ProductoResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IProductoService {
    ProductoResponseDto createProducto(ProductoRequestDto productoRequestDto);

    ProductoResponseDto updateProducto(String id, ProductoRequestDto productoRequestDto);

    List<ProductoResponseDto> getAllProductos();
}
