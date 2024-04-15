package com.springboot.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class ProductoDto {
	
	@NotBlank
	private String nombre;
	private String unidad;
	private float stock;
	 @Min(0)
	private float precio;
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
	public ProductoDto() {
		
	}
	public ProductoDto(String nombre, String unidad, float stock, float precio) {
	
		this.nombre = nombre;
		this.unidad = unidad;
		this.stock = stock;
		this.precio = precio;
	}
	
	
}
