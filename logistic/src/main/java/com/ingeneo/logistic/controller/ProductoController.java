package com.ingeneo.logistic.controller;

import com.ingeneo.logistic.domain.dto.ProductoDto;
import com.ingeneo.logistic.service.ProductoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    private final ProductoService productoService;
    Logger logger = LoggerFactory.getLogger(ProductoController.class);

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public ResponseEntity<List<ProductoDto>> getAllProductos() {
        List<ProductoDto> productos = productoService.getAllProductos();
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDto> getProductoById(@PathVariable Long id) {
        logger.info("Inicia controlador ProductoController{.. al servicio getProductoById(..) con id = " + id);
        ProductoDto producto = productoService.getProductoById(id);

        if (producto != null) {
            logger.info("Finaliza Ok - controlador ProductoController{.. al servicio getProductoById(..) con id = " + id + " retornando OK");
            return ResponseEntity.ok(producto);
        } else {
            logger.info("Finaliza Ok - controlador ProductoController{.. al servicio getProductoById(..) con id = " + id + " retornando NotFound");
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ProductoDto> createProducto(@RequestBody ProductoDto productoDto) {
        logger.info("Inicia controlador ProductoController{.. al servicio createProducto(..) con nombre = " + productoDto.getNombre());
        ProductoDto createdProducto = productoService.createProducto(productoDto);
        logger.info("Finaliza OK controlador ProductoController{.. al servicio createProducto(..) con nombre = " + productoDto.getNombre());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProducto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDto> updateProducto(@PathVariable Long id, @RequestBody ProductoDto productoDto) throws Exception {
        logger.info("Inicia controlador ProductoController{.. al servicio updateProducto(..) con nombre = " + productoDto.getNombre());
        ProductoDto updatedProducto = productoService.updateProducto(id, productoDto);
        if (updatedProducto != null) {
            logger.info("Finaliza OK controlador ProductoController{.. al servicio updateProducto(..) con nombre = " + productoDto.getNombre() + " Result: OK(200)");
            return ResponseEntity.ok(updatedProducto);
        } else {
            logger.info("Finaliza OK controlador ProductoController{.. al servicio updateProducto(..) con nombre = " + productoDto.getNombre() + " Result: NotFound(400)");
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
        productoService.deleteProducto(id);
        return ResponseEntity.noContent().build();
    }
}
