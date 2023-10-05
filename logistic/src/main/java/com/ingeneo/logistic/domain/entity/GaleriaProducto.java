package com.ingeneo.logistic.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "galeria_productos")
@Getter
@Setter
public class GaleriaProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String referencia;

    private String caracteristicas;

    private String materiales;

    @ManyToOne(fetch = FetchType.LAZY) // Lazy loading
    private GaleriaProducto galeriaProducto;

    // Constructors, getters, and setters

    // You can also add any additional annotations or relationships as needed.
}
