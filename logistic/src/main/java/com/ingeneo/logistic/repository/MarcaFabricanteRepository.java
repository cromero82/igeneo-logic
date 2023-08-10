package com.ingeneo.logistic.repository;

import com.ingeneo.logistic.domain.entity.MarcaFabricante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaFabricanteRepository extends JpaRepository<MarcaFabricante, Long> {
    // Add any custom query methods if needed
}

