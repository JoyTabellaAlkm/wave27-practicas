package com.mercadolibre.productos.service.impl;

import com.mercadolibre.productos.dto.request.ProductoRequestDto;
import com.mercadolibre.productos.dto.response.ProductoResponseDto;
import com.mercadolibre.productos.entity.Producto;
import com.mercadolibre.productos.repository.IProductoRepository;
import com.mercadolibre.productos.service.IProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService {
    @Autowired
    private IProductoRepository repository;

    ModelMapper mapper = new ModelMapper();

    @Override
    public ProductoResponseDto createProducto(ProductoRequestDto productoRequestDto) {
        Producto producto = mapper.map(productoRequestDto, Producto.class);
        repository.save(producto);
        return mapper.map(producto, ProductoResponseDto.class);
    }

    @Override
    public ProductoResponseDto updateProducto(String id, ProductoRequestDto productoRequestDto) {
        Producto producto = repository.findById(id).orElseThrow(()-> new RuntimeException("Producto no encontrado"));
        mapper.map(productoRequestDto, producto);
        producto.setId(id);
        repository.save(producto);
        return mapper.map(producto, ProductoResponseDto.class);
    }

    @Override
    public List<ProductoResponseDto> getAllProductos() {
        List<ProductoResponseDto> productos = new ArrayList<>();
        repository.findAll().forEach(producto -> {
            ProductoResponseDto productoResponseDto = mapper.map(producto, ProductoResponseDto.class);
            productos.add(productoResponseDto);
        });
        return productos;
    }
}
