package com.microservicios.productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservicios.productos.entity.Producto;
import com.microservicios.productos.service.ProductoService;

@RestController
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/listar")
	public List<Producto> getAllProductos() {
		return this.productoService.findAll();
	}
	
	@GetMapping("/ver/{id}")
	public Producto getAllProductos(@PathVariable Long id) {
		return this.productoService.findById(id);
	}
	
}
