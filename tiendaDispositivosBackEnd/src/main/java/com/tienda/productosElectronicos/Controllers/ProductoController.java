package com.tienda.productosElectronicos.Controllers;
import java.io.IOException;
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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.tienda.productosElectronicos.services.ProductoServices;
import com.tienda.productosElectronicos.entities.TblProducto;

@RestController
@RequestMapping("/product")
public class ProductoController {

	@Autowired
	private ProductoServices productoServices;
	
	@GetMapping("/getAllProducts")
	public List<TblProducto>getProducts(){
		return this.productoServices.getAllProducts();
	}
	
	@PostMapping("/insertProduct")
	public ResponseEntity<ObjectNode> insertProduct(
			@RequestParam("titulo") String titulo,
		    @RequestParam("precio") String precio,
		    @RequestParam("marca") String marca,
		    @RequestParam("image1") MultipartFile image1,
		    @RequestParam("image2") MultipartFile image2,
		    @RequestParam("image3") MultipartFile image3,
		    @RequestParam("idGestor") Integer idGestor){
		return this.productoServices.insertProduct(titulo, precio, marca, image1, image2, image3, idGestor);
	}
	
	@PutMapping("/updateProduct")
	public ResponseEntity<ObjectNode> updateProduct(
			@RequestParam("id") Integer id,
			@RequestParam("titulo") String titulo,
		    @RequestParam("precio") String precio,
		    @RequestParam("marca") String marca,
		    @RequestParam("image1") MultipartFile image1,
		    @RequestParam("image2") MultipartFile image2,
		    @RequestParam("image3") MultipartFile image3,
		    @RequestParam("idGestor") Integer idGestor) throws IOException{
		return this.productoServices.updateProduct(id, titulo, precio, marca, image1, image2, image3, idGestor);
	}
	
	@DeleteMapping("/deleteProduct")
	public ResponseEntity<ObjectNode> deleteProduct(@RequestParam("idProduct") int idProduct){
		return this.productoServices.deleteProduct(idProduct);
	}
}
