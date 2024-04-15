package com.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.entity.Producto;


@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

	
	public Optional <Producto> findByNombre(String nombre);
	//public Optional <Producto> findByUnidad(String unidad)
	public boolean existsByNombre(String nombre);
}
