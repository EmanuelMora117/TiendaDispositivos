package com.tienda.productosElectronicos.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.tienda.productosElectronicos.entities.TblMarcaProductos;
import com.tienda.productosElectronicos.services.MarcaServices;

@RestController
@RequestMapping("/marca")
public class MarcaController {
	
	@Autowired
	private MarcaServices marcaServices;
	
	@GetMapping("/getMarcaYProductos")
	public List<TblMarcaProductos> getMarcaProductos(@RequestParam("category") int category) {
		return this.marcaServices.getMarcaByCategory(category);
	}
	
	@GetMapping("/getAllMarcas")
	public List<TblMarcaProductos> getMarca(){
		return this.marcaServices.getMarca();
	}
	
	@PostMapping("/createMarca")
	public ResponseEntity<ObjectNode> createMarca(@RequestBody TblMarcaProductos tblMarca){
		return this.marcaServices.insertData(tblMarca);
	}
	
	@PutMapping("/updateMarca")
	public ResponseEntity<ObjectNode> updateMarca(@RequestBody TblMarcaProductos tblMarca){
		return this.marcaServices.updateMarca(tblMarca);
	}
	
	@DeleteMapping("/deleteMarca")
	public ResponseEntity<ObjectNode> deleteMarca(@RequestParam("idMarca") int idMarca){
		return this.marcaServices.deleteMarca(idMarca);
	}
}
