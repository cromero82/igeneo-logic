package com.ingeneo.logistic.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductoDto {

    private Long id;
    private String nombre;
    private String caracteristicas;
    private TipoProductoDto tipoProducto;

    public ProductoDto(Long id, String nombre, String caracteristicas, TipoProductoDto tipoProducto) {
        this.id = id;
        this.nombre = nombre;
        this.caracteristicas = caracteristicas;
        this.tipoProducto = tipoProducto;
    }
}

