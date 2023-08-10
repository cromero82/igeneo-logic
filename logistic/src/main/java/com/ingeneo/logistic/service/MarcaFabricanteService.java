package com.ingeneo.logistic.service;

import com.ingeneo.logistic.domain.dto.MarcaFabricanteDTO;

import java.util.List;

public interface MarcaFabricanteService {
    List<MarcaFabricanteDTO> getAllMarcaFabricantes();

    MarcaFabricanteDTO getMarcaFabricanteById(Long id);

    MarcaFabricanteDTO createMarcaFabricante(MarcaFabricanteDTO marcaFabricanteDTO);

    MarcaFabricanteDTO updateMarcaFabricante(Long id, MarcaFabricanteDTO marcaFabricanteDTO);

    void deleteMarcaFabricante(Long id);

    // You can add more methods if needed
}
