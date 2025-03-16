package com.tienda.productosElectronicos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.tienda.productosElectronicos.entities.TblMarcaProductos;
import com.tienda.productosElectronicos.helpers.ResponseHelper;
import com.tienda.productosElectronicos.repositories.interfaces.RIMarca;

@Service
public class MarcaServices {
	
	@Autowired
	private RIMarca riMarca;
	
	@Autowired
	private ResponseHelper responseHelper;
	
	public List<TblMarcaProductos> getMarcaByCategory(int idCategoria) {
		return this.riMarca.findByIdCat(idCategoria);
	}
	
	public List<TblMarcaProductos> getMarca() {
		return this.riMarca.findAll();
	}
	
	public ResponseEntity<ObjectNode> insertData(TblMarcaProductos tblMarca) {
		
		String answer = "";
		
		try {
			this.riMarca.save(tblMarca);
			answer = "Marca creada correctamente";
		} catch (Exception e) {
			System.out.println("Error al insertar: " + e);
			answer = "Error al crear una marca";
		}
		return this.responseHelper.returnLogProcess(answer);
	}
	
	public ResponseEntity<ObjectNode> updateMarca(TblMarcaProductos tblMarca){
		
		String answer = "";
		
		try {
			this.riMarca.save(tblMarca);
			answer = "Marca actualizada correctamente.";
		}catch(Exception e) {
			System.out.println("Error en la actualizacion de la marca: " + e);
			answer = "Error en la actualizacion de la marca.";
		}
		return this.responseHelper.returnLogProcess(answer);
	}
	
	public ResponseEntity<ObjectNode> deleteMarca(int marcaid){
		
		String answer = "";
		
		try {
			this.riMarca.deleteById(marcaid);
			answer = "Categoria eliminada correctamente.";
		} catch (Exception e) {
			System.out.println("Error al intentar eliminar la categoria: " + e);
			answer = "Error al intentar eliminar la categoria.";
		}
		return this.responseHelper.returnLogProcess(answer);
	}
}
