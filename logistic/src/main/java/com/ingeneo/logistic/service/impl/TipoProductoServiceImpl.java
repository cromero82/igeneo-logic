package com.ingeneo.logistic.service.impl;

import com.ingeneo.logistic.domain.entity.TipoProducto;
import com.ingeneo.logistic.repository.TipoProductoRepository;
import com.ingeneo.logistic.service.TipoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoProductoServiceImpl implements TipoProductoService {

    private final TipoProductoRepository tipoProductoRepository;

    @Autowired
    public TipoProductoServiceImpl(TipoProductoRepository tipoProductoRepository) {
        this.tipoProductoRepository = tipoProductoRepository;
    }

    @Override
    public TipoProducto guardarTipoProducto(TipoProducto tipoProducto) {
        return tipoProductoRepository.save(tipoProducto);
    }

    @Override
    public TipoProducto obtenerTipoProductoPorId(Long id) {
        return tipoProductoRepository.findById(id).orElse(null);
    }

    @Override
    public List<TipoProducto> obtenerTodosLosTiposDeProductos() {
        return tipoProductoRepository.findAll();
    }

    @Override
    public TipoProducto actualizarTipoProducto(TipoProducto tipoProducto) {
        return tipoProductoRepository.save(tipoProducto);
    }

    @Override
    public void eliminarTipoProductoPorId(Long id) {
        tipoProductoRepository.deleteById(id);
    }
}

