package com.ingeneo.logistic.controller;

import com.ingeneo.logistic.domain.dto.TypeVehicleDTO;
import com.ingeneo.logistic.service.TypeVehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/type-vehicles")
public class TypeVehicleController {
    private final TypeVehicleService typeVehicleService;

    public TypeVehicleController(TypeVehicleService typeVehicleService) {
        this.typeVehicleService = typeVehicleService;
    }

    @GetMapping
    public ResponseEntity<List<TypeVehicleDTO>> getAllTypeVehicles() {
        List<TypeVehicleDTO> typeVehicles = typeVehicleService.getAllTypeVehicles();
        return ResponseEntity.ok(typeVehicles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeVehicleDTO> getTypeVehicleById(@PathVariable int id) {
        TypeVehicleDTO typeVehicle = typeVehicleService.getTypeVehicleById(id);
        if (typeVehicle != null) {
            return ResponseEntity.ok(typeVehicle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<TypeVehicleDTO> createTypeVehicle(@RequestBody TypeVehicleDTO typeVehicleDTO) {
        TypeVehicleDTO createdTypeVehicle = typeVehicleService.createTypeVehicle(typeVehicleDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTypeVehicle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeVehicleDTO> updateTypeVehicle(@PathVariable int id, @RequestBody TypeVehicleDTO typeVehicleDTO) {
        TypeVehicleDTO updatedTypeVehicle = typeVehicleService.updateTypeVehicle(id, typeVehicleDTO);
        if (updatedTypeVehicle != null) {
            return ResponseEntity.ok(updatedTypeVehicle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypeVehicle(@PathVariable int id) {
        typeVehicleService.deleteTypeVehicle(id);
        return ResponseEntity.noContent().build();
    }
}

