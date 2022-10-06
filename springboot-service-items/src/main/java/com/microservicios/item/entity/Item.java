package com.microservicios.item.entity;

import lombok.Data;

@Data
public class Item {

	private Producto producto;
	private Integer cantidad;
	
	public Double getTotal() {
		return this.producto.getPrecio() * this.cantidad;
	}
	
}
