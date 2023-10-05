package com.ingeneo.logistic.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="marca_fabricante")
@Data
@NoArgsConstructor
public class MarcaFabricante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String nombreContacto;

    private String telefonoContacto;

    private String correoContacto;

    @ManyToOne(fetch = FetchType.LAZY) // Lazy loading
    private Pais pais;
}
