package com.ingeneo.logistic.controller;

import com.ingeneo.logistic.domain.dto.PaisDTO;
import com.ingeneo.logistic.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paises")
public class PaisController {

    private final PaisService paisService;

    @Autowired
    public PaisController(PaisService paisService) {
        this.paisService = paisService;
    }

    @GetMapping
    public ResponseEntity<List<PaisDTO>> getAllPaises() {
        List<PaisDTO> paises = paisService.getAllPaises();
        return ResponseEntity.ok(paises);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaisDTO> getPaisById(@PathVariable Long id) {
        PaisDTO pais = paisService.getPaisById(id);
        if (pais != null) {
            return ResponseEntity.ok(pais);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<PaisDTO> createPais(@RequestBody PaisDTO paisDTO) {
        PaisDTO createdPais = paisService.createPais(paisDTO);
        return new ResponseEntity<>(createdPais, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaisDTO> updatePais(@PathVariable Long id, @RequestBody PaisDTO paisDTO) {
        PaisDTO updatedPais = paisService.updatePais(id, paisDTO);
        if (updatedPais != null) {
            return ResponseEntity.ok(updatedPais);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePais(@PathVariable Long id) {
        paisService.deletePais(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PaisDTO> updatePatchPais(@PathVariable Long id, @RequestBody PaisDTO paisDTO) {
        PaisDTO updatedPais = paisService.updatePatchPais(id, paisDTO);
        if (updatedPais != null) {
            return ResponseEntity.ok(updatedPais);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
