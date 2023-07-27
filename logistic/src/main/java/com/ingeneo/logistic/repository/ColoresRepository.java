package com.ingeneo.logistic.repository;

import com.ingeneo.logistic.domain.entity.Colores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColoresRepository extends JpaRepository<Colores, Long> {

    // You can define custom query methods here if needed.
    // Spring Data JPA will automatically generate the queries based on method names.

}
