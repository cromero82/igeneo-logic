package com.ingeneo.logistic.service;

import com.ingeneo.logistic.domain.dto.ProductoDto;

import java.util.List;

public interface ProductoService {
    List<ProductoDto> getAllProductos();

    ProductoDto getProductoById(Long id);

    ProductoDto createProducto(ProductoDto productoDto);

    ProductoDto updateProducto(Long id, ProductoDto productoDto) throws Exception;

    void deleteProducto(Long id);

    // You can add more methods if needed
}
