package com.ingeneo.logistic.service;

import com.ingeneo.logistic.domain.dto.TypeVehicleDTO;

import java.util.List;

public interface TypeVehicleService {
    List<TypeVehicleDTO> getAllTypeVehicles();
    TypeVehicleDTO getTypeVehicleById(int id);
    TypeVehicleDTO createTypeVehicle(TypeVehicleDTO typeVehicleDTO);
    TypeVehicleDTO updateTypeVehicle(int id, TypeVehicleDTO typeVehicleDTO);
    void deleteTypeVehicle(int id);
}

