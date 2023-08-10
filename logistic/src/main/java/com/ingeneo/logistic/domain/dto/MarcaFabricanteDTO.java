package com.ingeneo.logistic.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MarcaFabricanteDTO {

    private Long id;
    private String nombre;
    private String nombreContacto;
    private String telefonoContacto;
    private String correoContacto;
    private PaisDTO pais;  // Assuming you have a PaisDTO class for Country

    public MarcaFabricanteDTO(Long id, String nombre, String nombreContacto, String telefonoContacto,
                              String correoContacto, PaisDTO pais) {
        this.id = id;
        this.nombre = nombre;
        this.nombreContacto = nombreContacto;
        this.telefonoContacto = telefonoContacto;
        this.correoContacto = correoContacto;
        this.pais = pais;
    }
}
