package com.tienda.productosElectronicos.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tienda.productosElectronicos.repositories.interfaces.RIMarca;
import com.tienda.productosElectronicos.repositories.interfaces.RIProducto;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.tienda.productosElectronicos.entities.TblMarcaProductos;
import com.tienda.productosElectronicos.entities.TblProducto;
import com.tienda.productosElectronicos.helpers.ResponseHelper;

@Service
public class ProductoServices {
	
	@Autowired
	private RIProducto riProducto;
	
	@Autowired
	private ResponseHelper responseHelper;
	
	@Autowired
	private RIMarca riMarca;
	
	public List<TblProducto> getAllProducts(){
		return this.riProducto.findAll();
	}
	
	public ResponseEntity<ObjectNode> insertProduct(String titulo, String precio, String marca, MultipartFile  image1, 
													MultipartFile  image2, MultipartFile  image3, Integer idGestor){
		String answer = "";
		try {
	        byte[] image1Bytes = image1.getBytes();
	        byte[] image2Bytes = image2.getBytes();
	        byte[] image3Bytes = image3.getBytes();
	        
	        TblMarcaProductos marcaData = riMarca.findBydescripcionMarca(marca);
	        
	        TblProducto tblProducto = new TblProducto();
	        tblProducto.setTitulo(titulo);
	        tblProducto.setPrecio(precio);
	        tblProducto.setMarca(marcaData);
	        tblProducto.setImage1(image1Bytes);
	        tblProducto.setImage2(image2Bytes);
	        tblProducto.setImage3(image3Bytes);
	        tblProducto.setIdGestor(idGestor);

	        this.riProducto.save(tblProducto);
	        answer = "Producto agregado correctamente.";
	    } catch (Exception e) {
	    	System.out.println("Error al insertar un producto: " + e);
	    	answer = "Error al insertar un producto.";
	    }
		
		return this.responseHelper.returnLogProcess(answer);
	}
	
	public ResponseEntity<ObjectNode> updateProduct(Integer id, String titulo, String precio, String marca, MultipartFile  image1, 
			MultipartFile  image2, MultipartFile  image3, Integer idGestor) throws IOException{
		
		String answer = "";
		
		byte[] image1Bytes = image1.getBytes();
        byte[] image2Bytes = image2.getBytes();
        byte[] image3Bytes = image3.getBytes();
        
        TblMarcaProductos marcaData = riMarca.findBydescripcionMarca(marca);
        
        TblProducto tblProducto = new TblProducto();
        tblProducto.setId(id);
        tblProducto.setTitulo(titulo);
        tblProducto.setPrecio(precio);
        tblProducto.setMarca(marcaData);
        tblProducto.setImage1(image1Bytes);
        tblProducto.setImage2(image2Bytes);
        tblProducto.setImage3(image3Bytes);
        tblProducto.setIdGestor(idGestor);
		
		try {
			this.riProducto.save(tblProducto);
			answer = "Producto actualizado correctamente.";
		} catch(Exception e) {
			System.out.println("Error al actualizar el producto: " + e);
			answer = "Error al actualizar el producto.";
		}
		
		return this.responseHelper.returnLogProcess(answer);
		
	}
	
	public ResponseEntity<ObjectNode> deleteProduct(int idProduct){
		
		String answer = "";
		
		try {
			this.riProducto.deleteById(idProduct);
			answer = "Producto eliminado correctamente.";
		} catch (Exception e) {
			System.out.println("Error al intentar eliminar el Producto: " + e);
			answer = "Error al intentar eliminar el Producto.";
		}
		return this.responseHelper.returnLogProcess(answer);
	}
	
	

}
