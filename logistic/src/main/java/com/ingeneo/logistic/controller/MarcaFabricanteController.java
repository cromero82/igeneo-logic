package com.ingeneo.logistic.controller;

import com.ingeneo.logistic.domain.dto.MarcaFabricanteDTO;
import com.ingeneo.logistic.service.MarcaFabricanteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marca-fabricante")
public class MarcaFabricanteController {
    private final MarcaFabricanteService marcaFabricanteService;
    Logger logger = LoggerFactory.getLogger(MarcaFabricanteController.class);

    public MarcaFabricanteController(MarcaFabricanteService marcaFabricanteService) {
        this.marcaFabricanteService = marcaFabricanteService;
    }

    @GetMapping
    public ResponseEntity<List<MarcaFabricanteDTO>> getAllMarcaFabricantes() {
        List<MarcaFabricanteDTO> marcaFabricantes = marcaFabricanteService.getAllMarcaFabricantes();
        return ResponseEntity.ok(marcaFabricantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarcaFabricanteDTO> getMarcaFabricanteById(@PathVariable Long id) {
        logger.info("Inicia controlador MarcaFabricanteController{.. al servicio getAllMarcaFabricantes(..) con id = " + id);
        MarcaFabricanteDTO marcaFabricante = marcaFabricanteService.getMarcaFabricanteById(id);

        if (marcaFabricante != null) {
            logger.info("Finaliza Ok - controlador MarcaFabricanteController{.. al servicio getMarcaFabricanteById(..) con id = " + id + " retornando OK");
            return ResponseEntity.ok(marcaFabricante);
        } else {
            logger.info("Finaliza Ok - controlador MarcaFabricanteController{.. al servicio getMarcaFabricanteById(..) con id = " + id + " retornando NotFound");
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<MarcaFabricanteDTO> createMarcaFabricante(@RequestBody MarcaFabricanteDTO marcaFabricanteDTO) {
        logger.info("Inicia controlador MarcaFabricanteController{.. al servicio createMarcaFabricante(..) con nombre = " + marcaFabricanteDTO.getNombre());
        MarcaFabricanteDTO createdMarcaFabricante = marcaFabricanteService.createMarcaFabricante(marcaFabricanteDTO);
        logger.info("Finaliza OK controlador MarcaFabricanteController{.. al servicio createMarcaFabricante(..) con nombre = " + marcaFabricanteDTO.getNombre());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMarcaFabricante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MarcaFabricanteDTO> updateMarcaFabricante(@PathVariable Long id, @RequestBody MarcaFabricanteDTO marcaFabricanteDTO) {
        logger.info("Inicia controlador MarcaFabricanteController{.. al servicio updateMarcaFabricante(..) con nombre = " + marcaFabricanteDTO.getNombre());
        MarcaFabricanteDTO updatedMarcaFabricante = marcaFabricanteService.updateMarcaFabricante(id, marcaFabricanteDTO);
        if (updatedMarcaFabricante != null) {
            logger.info("Finaliza OK controlador MarcaFabricanteController{.. al servicio updateMarcaFabricante(..) con nombre = " + marcaFabricanteDTO.getNombre() + " Result: OK(200)");
            return ResponseEntity.ok(updatedMarcaFabricante);
        } else {
            logger.info("Finaliza OK controlador MarcaFabricanteController{.. al servicio updateMarcaFabricante(..) con nombre = " + marcaFabricanteDTO.getNombre() + " Result: NotFound(400)");
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMarcaFabricante(@PathVariable Long id) {
        marcaFabricanteService.deleteMarcaFabricante(id);
        return ResponseEntity.noContent().build();
    }
}

