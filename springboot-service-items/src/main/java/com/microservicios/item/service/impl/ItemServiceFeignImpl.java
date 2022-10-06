package com.microservicios.item.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicios.item.client.ProductoClienteRest;
import com.microservicios.item.entity.Item;
import com.microservicios.item.service.ItemService;

//@Primary
@Service("serviceFeign")
public class ItemServiceFeignImpl implements ItemService {

	@Autowired
	private ProductoClienteRest clienteFeign;
	
	@Override
	public List<Item> findAll() {
		return this.clienteFeign.listar().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item ver(Long id, Integer cantidad) {
		return new Item(this.clienteFeign.detalle(id), cantidad);
	}

}
