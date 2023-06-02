package com.ingeneo.logistic.service.impl;

import com.ingeneo.logistic.domain.dto.TypeVehicleDTO;
import com.ingeneo.logistic.domain.entity.TypeVehicle;
import com.ingeneo.logistic.repository.TypeVehicleRepository;
import com.ingeneo.logistic.service.TypeVehicleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TypeVehicleServiceImpl implements TypeVehicleService {
    private final TypeVehicleRepository typeVehicleRepository;
    private final ModelMapper modelMapper;

    public TypeVehicleServiceImpl(TypeVehicleRepository typeVehicleRepository, ModelMapper modelMapper) {
        this.typeVehicleRepository = typeVehicleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TypeVehicleDTO> getAllTypeVehicles() {
        List<TypeVehicle> typeVehicles = typeVehicleRepository.findAll();
        return typeVehicles.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TypeVehicleDTO getTypeVehicleById(int id) {
        Optional<TypeVehicle> typeVehicleOptional = typeVehicleRepository.findById(id);
        return typeVehicleOptional.map(this::convertToDTO).orElse(null);
    }

    @Override
    public TypeVehicleDTO createTypeVehicle(TypeVehicleDTO typeVehicleDTO) {
        TypeVehicle typeVehicle = convertToEntity(typeVehicleDTO);
        TypeVehicle savedTypeVehicle = typeVehicleRepository.save(typeVehicle);
        return convertToDTO(savedTypeVehicle);
    }

    @Override
    public TypeVehicleDTO updateTypeVehicle(int id, TypeVehicleDTO typeVehicleDTO) {
        Optional<TypeVehicle> typeVehicleOptional = typeVehicleRepository.findById(id);
        if (typeVehicleOptional.isPresent()) {
            TypeVehicle typeVehicle = typeVehicleOptional.get();
            typeVehicle.setName(typeVehicleDTO.getName());
            typeVehicle.setPattern(typeVehicleDTO.getPattern());
            TypeVehicle updatedTypeVehicle = typeVehicleRepository.save(typeVehicle);
            return convertToDTO(updatedTypeVehicle);
        }
        return null;
    }

    @Override
    public void deleteTypeVehicle(int id) {
        typeVehicleRepository.deleteById(id);
    }

    private TypeVehicleDTO convertToDTO(TypeVehicle typeVehicle) {
        return modelMapper.map(typeVehicle, TypeVehicleDTO.class);
    }

    private TypeVehicle convertToEntity(TypeVehicleDTO typeVehicleDTO) {
        return modelMapper.map(typeVehicleDTO, TypeVehicle.class);
    }
}
