package com.ingeneo.logistic.repository;

import com.ingeneo.logistic.domain.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // Add any custom query methods if needed
}
