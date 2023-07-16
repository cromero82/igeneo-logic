package com.ingeneo.logistic.controller;

import com.ingeneo.logistic.domain.dto.TypeVehicleDTO;
import com.ingeneo.logistic.service.TypeVehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/type-vehicles")
public class TypeVehicleController {
    private final TypeVehicleService typeVehicleService;
    Logger logger = LoggerFactory.getLogger(TypeVehicleController.class);

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
        logger.info("Inicia controlador TypeVehicleController{.. al servicio getAllTypeVehicles(..) con id = " + id);
        TypeVehicleDTO typeVehicle = typeVehicleService.getTypeVehicleById(id);

        if (typeVehicle != null) {
            logger.info("Finaliza Ok - controlador TypeVehicleController{.. al servicio getTypeVehicleById(..) con id = " + id + " retornando OK");
            return ResponseEntity.ok(typeVehicle);
        } else {
            logger.info("Finaliza Ok - controlador TypeVehicleController{.. al servicio getTypeVehicleById(..) con id = " + id + " retornando NotFound");
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping
    public ResponseEntity<TypeVehicleDTO> createTypeVehicle(@RequestBody TypeVehicleDTO typeVehicleDTO) {
        logger.info("Inicia controlador TypeVehicleController{.. al servicio createTypeVehicle(..) con name = " + typeVehicleDTO.getName() + ", pattern: " + typeVehicleDTO.getPattern());
        TypeVehicleDTO createdTypeVehicle = typeVehicleService.createTypeVehicle(typeVehicleDTO);
        logger.info("Finaliza OK controlador TypeVehicleController{.. al servicio createTypeVehicle(..) con name = " + typeVehicleDTO.getName() + ", pattern: " + typeVehicleDTO.getPattern());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTypeVehicle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeVehicleDTO> updateTypeVehicle(@PathVariable int id, @RequestBody TypeVehicleDTO typeVehicleDTO) {
        logger.info("Inicia controlador TypeVehicleController{.. al servicio updateTypeVehicle(..) con name = " + typeVehicleDTO.getName() + ", pattern: " + typeVehicleDTO.getPattern());
        TypeVehicleDTO updatedTypeVehicle = typeVehicleService.updateTypeVehicle(id, typeVehicleDTO);
        if (updatedTypeVehicle != null) {
            logger.info("Finaliza OK controlador TypeVehicleController{.. al servicio updateTypeVehicle(..) con name = " + typeVehicleDTO.getName() + ", pattern: " + typeVehicleDTO.getPattern() + " Result: OK(200)");
            return ResponseEntity.ok(updatedTypeVehicle);
        } else {
            logger.info("Finaliza OK controlador TypeVehicleController{.. al servicio updateTypeVehicle(..) con name = " + typeVehicleDTO.getName() + ", pattern: " + typeVehicleDTO.getPattern() + " Result: NotFound(400)");
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TypeVehicleDTO> updatePatchTypeVehicle(@PathVariable int id, @RequestBody TypeVehicleDTO tipoVehiculoEnviadoCliente) {
        logger.info("Inicia controlador TypeVehicleController{.. al servicio updatePatchTypeVehicle(..) con name = " + tipoVehiculoEnviadoCliente.getName() + ", pattern: " + tipoVehiculoEnviadoCliente.getPattern() + ",los datos null seran omitidos en esta operacion");
        TypeVehicleDTO updatedTypeVehicle = typeVehicleService.updatePatchTypeVehicle(id, tipoVehiculoEnviadoCliente);
        if (updatedTypeVehicle != null) {
            logger.info("Finaliza OK controlador TypeVehicleController{.. al servicio updatePatchTypeVehicle(..) con name = " + tipoVehiculoEnviadoCliente.getName() + ", pattern: " + tipoVehiculoEnviadoCliente.getPattern() + ",los datos null seran omitidos en esta operacion, Result: OK(200)");
            return ResponseEntity.status(HttpStatus.OK).body(updatedTypeVehicle);
        } else {
            logger.info("Finaliza OK controlador TypeVehicleController{.. al servicio updatePatchTypeVehicle(..) con name = " + tipoVehiculoEnviadoCliente.getName() + ", pattern: " + tipoVehiculoEnviadoCliente.getPattern() + ",los datos null seran omitidos en esta operacion, Result: NotFound(200)");
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypeVehicle(@PathVariable int id) {
        typeVehicleService.deleteTypeVehicle(id);
        return ResponseEntity.noContent().build();
    }
}

