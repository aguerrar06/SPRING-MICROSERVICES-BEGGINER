package com.microservicios.productos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.microservicios.productos.entity.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long>{

}
