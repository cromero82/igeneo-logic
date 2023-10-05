package com.ingeneo.logistic.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "producto")
@Getter
@Setter
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String caracteristicas;

    // Define a Many-to-One relationship with TipoProducto
    @ManyToOne
    @JoinColumn(name = "tipo_producto_id")
    private TipoProducto tipoProducto;

    // Constructors, getters, and setters

    // You can also add any additional annotations or relationships as needed.
}
