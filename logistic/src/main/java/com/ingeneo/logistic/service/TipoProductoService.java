package com.ingeneo.logistic.service;
import com.ingeneo.logistic.domain.entity.TipoProducto;

import java.util.List;

public interface TipoProductoService {
    TipoProducto guardarTipoProducto(TipoProducto tipoProducto);

    TipoProducto obtenerTipoProductoPorId(Long id);

    List<TipoProducto> obtenerTodosLosTiposDeProductos();

    TipoProducto actualizarTipoProducto(TipoProducto tipoProducto);

    void eliminarTipoProductoPorId(Long id);
}

