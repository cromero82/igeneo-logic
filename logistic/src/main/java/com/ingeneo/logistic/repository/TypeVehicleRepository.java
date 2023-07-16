package com.ingeneo.logistic.repository;

import com.ingeneo.logistic.domain.entity.TypeVehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeVehicleRepository extends JpaRepository<TypeVehicle, Integer> {
    // Add custom queries or methods if needed
}

