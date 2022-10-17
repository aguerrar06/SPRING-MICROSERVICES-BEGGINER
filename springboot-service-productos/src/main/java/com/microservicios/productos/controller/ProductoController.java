package com.microservicios.productos.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservicios.productos.entity.Producto;
import com.microservicios.productos.service.ProductoService;

@RestController
public class ProductoController {

	@Autowired
	private Environment env; // Extraer cualquier dato del application.properties
	
	//@Value("${server.port}") // Extraer el puerto con la anotación Value
	//private Integer port;
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/listar")
	public List<Producto> getAllProductos() {
		return this.productoService.findAll().stream().map(producto -> {
			producto.setPuerto(Integer.parseInt(this.env.getProperty("local.server.port")));
			//producto.setPuerto(this.port);
			return producto;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/ver/{id}")
	public Producto getAllProductos(@PathVariable Long id) {
		Producto producto = this.productoService.findById(id);
		producto.setPuerto(Integer.parseInt(this.env.getProperty("local.server.port")));
		//producto.setPuerto(this.port);
		
		/*try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		return producto;
	}
	
}
 