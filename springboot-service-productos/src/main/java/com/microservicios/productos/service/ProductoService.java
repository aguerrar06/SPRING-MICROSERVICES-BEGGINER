package com.microservicios.productos.service;

import java.util.List;

import com.microservicios.productos.entity.Producto;

public interface ProductoService {

	public List<Producto> findAll();
	public Producto findById(Long id);
	
}
