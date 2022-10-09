package com.microservicios.item.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservicios.item.entity.Producto;

// La siguiente linea es si no usamos un balanceador de carga como Ribbon
// @FeignClient(name = "servicio-productos", url = "http://localhost:8001")
@FeignClient(name = "servicio-productos")
public interface ProductoClienteRest {

	/* 
	 * Se utiliza la misma anotación que en el controlador
	 * pero la diferencia es que esta sirve para indicar 
	 * el protocolo HTTP con el que se va a llamar al endpoint destino 
	 */
	@GetMapping("/listar")
	public List<Producto> listar();
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id);
	
}
