package com.ingeneo.logistic.service;

import com.ingeneo.logistic.domain.dto.PaisDTO;

import java.util.List;

public interface PaisService {
    List<PaisDTO> getAllPaises();
    PaisDTO getPaisById(Long id);
    PaisDTO createPais(PaisDTO paisDTO);
    PaisDTO updatePais(Long id, PaisDTO paisDTO);
    void deletePais(Long id);
    PaisDTO updatePatchPais(Long idPais, PaisDTO paisEnviadoCliente);
}
