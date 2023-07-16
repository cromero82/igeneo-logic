package com.ingeneo.logistic.service;

import com.ingeneo.logistic.domain.dto.TypeVehicleDTO;
import com.ingeneo.logistic.domain.entity.TypeVehicle;

import java.util.List;

public interface TypeVehicleService {
    List<TypeVehicleDTO> getAllTypeVehicles();
    TypeVehicleDTO getTypeVehicleById(int id);
    TypeVehicleDTO createTypeVehicle(TypeVehicleDTO typeVehicleDTO);
    TypeVehicleDTO updateTypeVehicle(int id, TypeVehicleDTO typeVehicleDTO);
    void deleteTypeVehicle(int id);

    TypeVehicleDTO updatePatchTypeVehicle(int idTipoVehiculo, TypeVehicleDTO tipoVehiculoEnviadoCliente);
}

