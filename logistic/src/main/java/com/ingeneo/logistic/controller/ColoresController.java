package com.ingeneo.logistic.controller;

import com.ingeneo.logistic.domain.dto.ColoresDTO;
import com.ingeneo.logistic.service.ColoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colores")
public class ColoresController {

    private final ColoresService coloresService;

    @Autowired
    public ColoresController(ColoresService coloresService) {
        this.coloresService = coloresService;
    }

    @GetMapping
    public ResponseEntity<List<ColoresDTO>> getAllColores() {
        List<ColoresDTO> coloresList = coloresService.getAllColores();
        return ResponseEntity.ok(coloresList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ColoresDTO> getColoresById(@PathVariable Long id) {
        ColoresDTO coloresDTO = coloresService.getColoresById(id);
        if (coloresDTO != null) {
            return ResponseEntity.ok(coloresDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ColoresDTO> createColores(@RequestBody ColoresDTO coloresDTO) {
        ColoresDTO createdColores = coloresService.createColores(coloresDTO);
        return new ResponseEntity<>(createdColores, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ColoresDTO> updateColores(@PathVariable Long id, @RequestBody ColoresDTO coloresDTO) {
        ColoresDTO updatedColores = coloresService.updateColores(id, coloresDTO);
        if (updatedColores != null) {
            return ResponseEntity.ok(updatedColores);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteColores(@PathVariable Long id) {
        coloresService.deleteColores(id);
        return ResponseEntity.noContent().build();
    }
}

