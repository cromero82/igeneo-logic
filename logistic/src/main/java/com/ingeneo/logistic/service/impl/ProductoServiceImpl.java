package com.ingeneo.logistic.service.impl;

import com.ingeneo.logistic.domain.dto.ProductoDto;
import com.ingeneo.logistic.domain.entity.Producto;
import com.ingeneo.logistic.domain.entity.TipoProducto;
import com.ingeneo.logistic.repository.ProductoRepository;
import com.ingeneo.logistic.repository.TipoProductoRepository;
import com.ingeneo.logistic.service.ProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final TipoProductoRepository tipoProductoRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductoServiceImpl(ProductoRepository productoRepository, TipoProductoRepository tipoProductoRepository, ModelMapper modelMapper) {
        this.productoRepository = productoRepository;
        this.tipoProductoRepository = tipoProductoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductoDto> getAllProductos() {
        List<Producto> productos = productoRepository.findAll();
        return productos.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductoDto getProductoById(Long id) {
        Optional<Producto> productoOptional = productoRepository.findById(id);
        return productoOptional.map(this::convertToDto).orElse(null);
    }

    @Override
    public ProductoDto createProducto(ProductoDto productoDto) {
        Producto producto = convertToEntity(productoDto);
        Producto savedProducto = productoRepository.save(producto);
        return convertToDto(savedProducto);
    }

    @Override
    public ProductoDto updateProducto(Long id, ProductoDto productoDto) throws Exception {
        Optional<Producto> productoOptional = productoRepository.findById(id);
        if (productoOptional.isPresent()) {
            Producto producto = productoOptional.get();

            // Retrieve the TipoProducto entity
            Optional<TipoProducto> tipoProductoOptional = tipoProductoRepository.findById(productoDto.getTipoProducto().getId());
            if (!tipoProductoOptional.isPresent()) {
                throw new Exception("No se encontró TipoProducto con id = " + productoDto.getTipoProducto().getId());
            }

            producto.setNombre(productoDto.getNombre());
            producto.setCaracteristicas(productoDto.getCaracteristicas());
            producto.setTipoProducto(tipoProductoOptional.get());

            // Update other fields here if needed
            Producto updatedProducto = productoRepository.save(producto);
            return convertToDto(updatedProducto);
        } else {
            throw new Exception("No se encontró Producto con id = " + id);
        }
    }

    @Override
    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }

    private ProductoDto convertToDto(Producto producto) {
        return modelMapper.map(producto, ProductoDto.class);
    }

    private Producto convertToEntity(ProductoDto productoDto) {
        return modelMapper.map(productoDto, Producto.class);
    }
}

