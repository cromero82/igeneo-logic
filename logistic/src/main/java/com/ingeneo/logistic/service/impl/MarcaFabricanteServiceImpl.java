package com.ingeneo.logistic.service.impl;

import com.ingeneo.logistic.domain.dto.MarcaFabricanteDTO;
import com.ingeneo.logistic.domain.entity.MarcaFabricante;
import com.ingeneo.logistic.repository.MarcaFabricanteRepository;
import com.ingeneo.logistic.service.MarcaFabricanteService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MarcaFabricanteServiceImpl implements MarcaFabricanteService {

    private final MarcaFabricanteRepository marcaFabricanteRepository;
    private final ModelMapper modelMapper;

    public MarcaFabricanteServiceImpl(MarcaFabricanteRepository marcaFabricanteRepository, ModelMapper modelMapper) {
        this.marcaFabricanteRepository = marcaFabricanteRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<MarcaFabricanteDTO> getAllMarcaFabricantes() {
        List<MarcaFabricante> marcaFabricantes = marcaFabricanteRepository.findAll();
        return marcaFabricantes.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MarcaFabricanteDTO getMarcaFabricanteById(Long id) {
        Optional<MarcaFabricante> marcaFabricanteOptional = marcaFabricanteRepository.findById(id);
        return marcaFabricanteOptional.map(this::convertToDTO).orElse(null);
    }

    @Override
    public MarcaFabricanteDTO createMarcaFabricante(MarcaFabricanteDTO marcaFabricanteDTO) {
        MarcaFabricante marcaFabricante = convertToEntity(marcaFabricanteDTO);
        MarcaFabricante savedMarcaFabricante = marcaFabricanteRepository.save(marcaFabricante);
        return convertToDTO(savedMarcaFabricante);
    }

    @Override
    public MarcaFabricanteDTO updateMarcaFabricante(Long id, MarcaFabricanteDTO marcaFabricanteDTO) {
        Optional<MarcaFabricante> marcaFabricanteOptional = marcaFabricanteRepository.findById(id);
        if (marcaFabricanteOptional.isPresent()) {
            MarcaFabricante marcaFabricante = marcaFabricanteOptional.get();
            // Update fields here
            MarcaFabricante updatedMarcaFabricante = marcaFabricanteRepository.save(marcaFabricante);
            return convertToDTO(updatedMarcaFabricante);
        }
        return null;
    }

    @Override
    public void deleteMarcaFabricante(Long id) {
        marcaFabricanteRepository.deleteById(id);
    }

    private MarcaFabricanteDTO convertToDTO(MarcaFabricante marcaFabricante) {
        return modelMapper.map(marcaFabricante, MarcaFabricanteDTO.class);
    }

    private MarcaFabricante convertToEntity(MarcaFabricanteDTO marcaFabricanteDTO) {
        return modelMapper.map(marcaFabricanteDTO, MarcaFabricante.class);
    }
}
