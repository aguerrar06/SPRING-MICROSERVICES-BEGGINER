package com.microservicios.item.service;

import java.util.List;

import com.microservicios.item.entity.Item;

public interface ItemService {

	public List<Item> findAll();
	public Item ver(Long id, Integer cantidad);
	
}
