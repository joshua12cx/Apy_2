package com.springboot.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.dto.ProductoDto;
import com.springboot.entity.Mensaje;
import com.springboot.entity.Producto;
import com.springboot.service.ProductoService;

@RestController
@RequestMapping("/apiproducto")
public class ProductoController {

	@Autowired
	ProductoService productoService;
	
	@GetMapping("/lista")
	public ResponseEntity<List<Producto>>listar(){
		List<Producto> listaProducto = productoService.listar();
		return new ResponseEntity<List<Producto>>(listaProducto,HttpStatus.OK);
	}
	
	@GetMapping("/lista2")
	public List<Producto>listar2(){
		List<Producto> listaProducto = productoService.listar();
		return listaProducto;
	}
	
	@GetMapping("/detalle/{id}")
	public ResponseEntity <Producto> getById(@PathVariable("id")int id){
	
	if(!productoService.existsById(id)) {
		return new ResponseEntity(new Mensaje("No existe productos con este codigo"),HttpStatus.NOT_FOUND);
	}else {
		Producto producto = productoService.getOne(id).get();
		return new ResponseEntity<Producto>(producto,HttpStatus.OK);
	}
	
}
	@GetMapping("/detallepor/{nombre}")
	public ResponseEntity<Producto> getByNombre(@PathVariable("nombre")String nombre){
		
		if(!productoService.existsByNombre(nombre)){
			return new ResponseEntity(new Mensaje("nose puede detallar datos porque el producto no existe")
					,HttpStatus.NOT_FOUND);
		}
		else{
			Producto producto =  productoService.getByNombre(nombre).get();
			//return new ResponseEntity(producto,HttpStatus.OK);
		return new ResponseEntity(producto,HttpStatus.OK);
		}
		
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody ProductoDto productoDto){
       		if(StringUtils.isBlank(productoDto.getNombre())){
       			return new ResponseEntity(new Mensaje("nombre no debe ser nulo"),HttpStatus.BAD_REQUEST);
       		}
       		if(productoDto.getPrecio()<0) {
       			return new ResponseEntity(new Mensaje("Precio debe tener un valor positivo"),HttpStatus.BAD_REQUEST);
       		}
       		if(productoService.existsByNombre(productoDto.getNombre())) {
       			return new ResponseEntity(new Mensaje("El nombre de producto ya existe"),HttpStatus.BAD_REQUEST);
       		}
       		Producto producto = new Producto(productoDto.getNombre(),productoDto.getUnidad(),productoDto.getStock(),
       				productoDto.getPrecio());
       		productoService.save(producto);
       		return new ResponseEntity(new Mensaje("producto insertado"),HttpStatus.OK);
       		
	}
}

