package com.ingeneo.logistic.service.impl;

import com.ingeneo.logistic.domain.dto.ColoresDTO;
import com.ingeneo.logistic.domain.entity.Colores;
import com.ingeneo.logistic.repository.ColoresRepository;
import com.ingeneo.logistic.service.ColoresService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ColoresServiceImpl implements ColoresService {
    private final ColoresRepository coloresRepository;
    private final ModelMapper modelMapper;

    public ColoresServiceImpl(ColoresRepository coloresRepository, ModelMapper modelMapper) {
        this.coloresRepository = coloresRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ColoresDTO> getAllColores() {
        List<Colores> coloresList = coloresRepository.findAll();
        return coloresList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ColoresDTO getColoresById(Long id) {
        Optional<Colores> coloresOptional = coloresRepository.findById(id);
        return coloresOptional.map(this::convertToDTO).orElse(null);
    }

    @Override
    public ColoresDTO createColores(ColoresDTO coloresDTO) {
        Colores colores = convertToEntity(coloresDTO);
        Colores savedColores = coloresRepository.save(colores);
        return convertToDTO(savedColores);
    }

    @Override
    public ColoresDTO updateColores(Long id, ColoresDTO coloresDTO) {
        Optional<Colores> coloresOptional = coloresRepository.findById(id);
        if (coloresOptional.isPresent()) {
            Colores colores = coloresOptional.get();
            colores.setNombre(coloresDTO.getNombre());
            colores.setRgb(coloresDTO.getRgb());
            colores.setFavorito(coloresDTO.isFavorito());
            Colores updatedColores = coloresRepository.save(colores);
            return convertToDTO(updatedColores);
        }
        return null;
    }

    @Override
    public void deleteColores(Long id) {
        coloresRepository.deleteById(id);
    }

    private ColoresDTO convertToDTO(Colores colores) {
        return modelMapper.map(colores, ColoresDTO.class);
    }

    private Colores convertToEntity(ColoresDTO coloresDTO) {
        return modelMapper.map(coloresDTO, Colores.class);
    }
}
