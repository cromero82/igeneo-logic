package com.ingeneo.logistic.service;

import com.ingeneo.logistic.domain.dto.ColoresDTO;

import java.util.List;

public interface ColoresService {
    List<ColoresDTO> getAllColores();

    ColoresDTO getColoresById(Long id);

    ColoresDTO createColores(ColoresDTO coloresDTO);

    ColoresDTO updateColores(Long id, ColoresDTO coloresDTO);

    void deleteColores(Long id);
}