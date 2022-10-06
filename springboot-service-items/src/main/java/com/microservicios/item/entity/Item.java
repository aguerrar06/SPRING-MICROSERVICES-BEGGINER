package com.microservicios.item.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Item {

	private Producto producto;
	private Integer cantidad;
	
	public Double getTotal() {
		return this.producto.getPrecio() * this.cantidad;
	}
	
}
