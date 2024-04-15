package com.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Producto {

	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String unidad;
	private float stock;
	private float precio;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	public float getStock() {
		return stock;
	}
	public void setStock(float stock) {
		this.stock = stock;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public Producto() {
		
	}
	public Producto( String nombre, String unidad, float stock, float precio) {
		
		
		this.nombre = nombre;
		this.unidad = unidad;
		this.stock = stock;
		this.precio = precio;
	}

	

}
