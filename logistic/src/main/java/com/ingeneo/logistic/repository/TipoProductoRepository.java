package com.ingeneo.logistic.repository;

import com.ingeneo.logistic.domain.entity.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoProductoRepository extends JpaRepository<TipoProducto, Long> {
    // You can add custom query methods here if needed
}

