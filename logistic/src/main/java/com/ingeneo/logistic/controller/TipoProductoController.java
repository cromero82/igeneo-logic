package com.ingeneo.logistic.controller;

import com.ingeneo.logistic.domain.entity.TipoProducto;
import com.ingeneo.logistic.service.TipoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-productos")
public class TipoProductoController {

    private final TipoProductoService tipoProductoService;

    @Autowired
    public TipoProductoController(TipoProductoService tipoProductoService) {
        this.tipoProductoService = tipoProductoService;
    }

    @GetMapping
    public ResponseEntity<List<TipoProducto>> getAllTipoProductos() {
        List<TipoProducto> tipoProductos = tipoProductoService.obtenerTodosLosTiposDeProductos();
        return ResponseEntity.ok(tipoProductos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoProducto> getTipoProductoById(@PathVariable Long id) {
        TipoProducto tipoProducto = tipoProductoService.obtenerTipoProductoPorId(id);
        if (tipoProducto != null) {
            return ResponseEntity.ok(tipoProducto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<TipoProducto> createTipoProducto(@RequestBody TipoProducto tipoProducto) {
        TipoProducto createdTipoProducto = tipoProductoService.guardarTipoProducto(tipoProducto);
        return new ResponseEntity<>(createdTipoProducto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoProducto> updateTipoProducto(@PathVariable Long id, @RequestBody TipoProducto tipoProducto) {
        TipoProducto updatedTipoProducto = tipoProductoService.actualizarTipoProducto(tipoProducto);
        if (updatedTipoProducto != null) {
            return ResponseEntity.ok(updatedTipoProducto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoProducto(@PathVariable Long id) {
        tipoProductoService.eliminarTipoProductoPorId(id);
        return ResponseEntity.noContent().build();
    }
}
