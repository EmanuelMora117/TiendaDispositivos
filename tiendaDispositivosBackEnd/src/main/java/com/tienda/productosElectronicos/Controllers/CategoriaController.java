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
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.tienda.productosElectronicos.entities.TblCategoria;
import com.tienda.productosElectronicos.services.CategoriaServices;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaServices categoriaServices;
	
	@GetMapping("/getCategoria")
	public List<TblCategoria> getCategoria(){
		return this.categoriaServices.getCategoria();
	}
	
	@PostMapping("/createCategoria")
	public ResponseEntity<ObjectNode> createCategoria(
		    @RequestParam("categoriaDescripcion") String categoriaDescripcion,
		    @RequestParam("imagen1") MultipartFile imagen1,
		    @RequestParam("imagen2") MultipartFile imagen2,
		    @RequestParam("imagen3") MultipartFile imagen3){
		return this.categoriaServices.insertData(categoriaDescripcion, imagen1, imagen2, imagen3);
	}
	
	@PutMapping("/updateCategory")
	public ResponseEntity<ObjectNode> updateCategory(
				@RequestParam("idCategoria") Integer idCategoria,
				@RequestParam("categoriaDescripcion") String categoriaDescripcion,
			    @RequestParam("imagen1") MultipartFile imagen1,
			    @RequestParam("imagen2") MultipartFile imagen2,
			    @RequestParam("imagen3") MultipartFile imagen3){
		return this.categoriaServices.updateCategory(idCategoria, categoriaDescripcion, imagen1, imagen2, imagen3);
	}
	
	@DeleteMapping("/deleteCategory")
	public ResponseEntity<ObjectNode> deleteProduct(@RequestParam("idCategoria") int idCategory){
		return this.categoriaServices.deleteCategory(idCategory);
	}
}

