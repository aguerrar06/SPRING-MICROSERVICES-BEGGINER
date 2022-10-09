package com.microservicios.productos.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservicios.productos.entity.Producto;
import com.microservicios.productos.service.ProductoService;

@RestController
public class ProductoController {

	@Autowired
	private Environment env;
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/listar")
	public List<Producto> getAllProductos() {
		return this.productoService.findAll().stream().map(producto -> {
			producto.setPuerto(Integer.parseInt(this.env.getProperty("local.server.port")));
			return producto;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/ver/{id}")
	public Producto getAllProductos(@PathVariable Long id) {
		Producto producto = this.productoService.findById(id);
		producto.setPuerto(Integer.parseInt(this.env.getProperty("local.server.port")));
		
		return producto;
	}
	
}
