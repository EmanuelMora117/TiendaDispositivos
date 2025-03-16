package com.tienda.productosElectronicos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.tienda.productosElectronicos.entities.TblCategoria;
import com.tienda.productosElectronicos.helpers.ResponseHelper;
import com.tienda.productosElectronicos.repositories.interfaces.RICategoria;

@Service
public class CategoriaServices {

	@Autowired
	private RICategoria riCategoria;
	
	@Autowired
	private ResponseHelper responseHelper;
	
	public List<TblCategoria> getCategoria() {
		return this.riCategoria.findAll();
	}
	
	public ResponseEntity<ObjectNode> insertData(
			String categoriaDescripcion, MultipartFile  imagen1,
			MultipartFile  imagen2, MultipartFile  imagen3) {
		
		String answer = "";
		
		try {
			byte[] image1Bytes = imagen1.getBytes();
	        byte[] image2Bytes = imagen2.getBytes();
	        byte[] image3Bytes = imagen3.getBytes();
	        
	        TblCategoria tblCategoria = new TblCategoria();
	        tblCategoria.setCategoriaDescripcion(categoriaDescripcion);
	        tblCategoria.setImagen1(image1Bytes);
	        tblCategoria.setImagen2(image2Bytes);
	        tblCategoria.setImagen3(image3Bytes);
			
			this.riCategoria.save(tblCategoria);
			answer = "Categoria creada correctamente";
		} catch (Exception e) {
			System.out.println("Error al insertar: " + e);
			answer = "Error al crear una categoria";
		}
		return this.responseHelper.returnLogProcess(answer);
	}
	
	public ResponseEntity<ObjectNode> updateCategory(
			Integer idCategoria, String categoriaDescripcion, MultipartFile  imagen1,
			MultipartFile  imagen2, MultipartFile  imagen3){
		
		String answer = "";
		
		try {
			byte[] image1Bytes = imagen1.getBytes();
	        byte[] image2Bytes = imagen2.getBytes();
	        byte[] image3Bytes = imagen3.getBytes();
	        
	        TblCategoria tblCategoria = new TblCategoria();
	        tblCategoria.setIdCategoria(idCategoria);
	        tblCategoria.setCategoriaDescripcion(categoriaDescripcion);
	        tblCategoria.setImagen1(image1Bytes);
	        tblCategoria.setImagen2(image2Bytes);
	        tblCategoria.setImagen3(image3Bytes);
	        
			this.riCategoria.save(tblCategoria);
			answer = "Categoria actualizada correctamente.";
		}catch(Exception e) {
			System.out.println("Error en la actualizacion de la categoria: " + e);
			answer = "Error en la actualizacion de la categoria.";
		}
		return this.responseHelper.returnLogProcess(answer);
	}
	
	public ResponseEntity<ObjectNode> deleteCategory(int idCategory){
		
		String answer = "";
		
		try {
			this.riCategoria.deleteById(idCategory);
			answer = "Categoria eliminada correctamente.";
		} catch (Exception e) {
			System.out.println("Error al intentar eliminar la categoria: " + e);
			answer = "Error al intentar eliminar la categoria.";
		}
		return this.responseHelper.returnLogProcess(answer);
	}
	
}
