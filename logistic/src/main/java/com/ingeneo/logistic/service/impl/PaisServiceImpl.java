package com.ingeneo.logistic.service.impl;

import com.ingeneo.logistic.domain.dto.PaisDTO;
import com.ingeneo.logistic.domain.entity.Pais;
import com.ingeneo.logistic.repository.PaisRepository;
import com.ingeneo.logistic.service.PaisService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaisServiceImpl implements PaisService {
    private final PaisRepository paisRepository;
    private final ModelMapper modelMapper;

    public PaisServiceImpl(PaisRepository paisRepository, ModelMapper modelMapper) {
        this.paisRepository = paisRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PaisDTO> getAllPaises() {
        List<Pais> paises = paisRepository.findAll();
        return paises.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PaisDTO getPaisById(Long id) {
        Optional<Pais> paisOptional = paisRepository.findById(id);
        return paisOptional.map(this::convertToDTO).orElse(null);
    }

    @Override
    public PaisDTO createPais(PaisDTO paisDTO) {
        Pais pais = convertToEntity(paisDTO);
        Pais savedPais = paisRepository.save(pais);
        return convertToDTO(savedPais);
    }

    @Override
    public PaisDTO updatePais(Long id, PaisDTO paisDTO) {
        Optional<Pais> paisOptional = paisRepository.findById(id);
        if (paisOptional.isPresent()) {
            Pais pais = paisOptional.get();
            pais.setNombre(paisDTO.getNombre());
            pais.setSigla(paisDTO.getSigla());
            Pais updatedPais = paisRepository.save(pais);
            return convertToDTO(updatedPais);
        }
        return null;
    }

    @Override
    public void deletePais(Long id) {
        paisRepository.deleteById(id);
    }

    @Override
    public PaisDTO updatePatchPais(Long idPais, PaisDTO paisEnviadoCliente) {
        Optional<Pais> paisLeidoBaseDatosOpt = paisRepository.findById(idPais);

        // Check if the record exists in the database
        if (paisLeidoBaseDatosOpt.isPresent()) {
            Pais pais = paisLeidoBaseDatosOpt.get();

            if (paisEnviadoCliente.getNombre() != null && !paisEnviadoCliente.getNombre().equals("")) {
                pais.setNombre(paisEnviadoCliente.getNombre());
            }

            if (paisEnviadoCliente.getSigla() != null && !paisEnviadoCliente.getSigla().equals("")) {
                pais.setSigla(paisEnviadoCliente.getSigla());
            }

            Pais updatedPais = paisRepository.save(pais);
            return convertToDTO(updatedPais);
        }
        return null;
    }

    private PaisDTO convertToDTO(Pais pais) {
        return modelMapper.map(pais, PaisDTO.class);
    }

    private Pais convertToEntity(PaisDTO paisDTO) {
        return modelMapper.map(paisDTO, Pais.class);
    }
}
