package com.tienda.productosElectronicos.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.tienda.productosElectronicos.entities.TblAdmin;
import com.tienda.productosElectronicos.models.DTOUsuarioAdmin;
import com.tienda.productosElectronicos.services.AdminServices;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminServices admServices;
	
	@PostMapping("/createUserAdmin")
	public ResponseEntity<ObjectNode> createUserAdmin(@RequestBody DTOUsuarioAdmin dtoUsuarioAdmin) {
		return this.admServices.insertData(dtoUsuarioAdmin);	
	}
	
	@PutMapping("/updateAdmin")
	public ResponseEntity<ObjectNode> updateProduct(@RequestBody DTOUsuarioAdmin dtoUsuarioAdmin){
		return this.admServices.updateAdmin(dtoUsuarioAdmin);
	}
	
	
	//aqui debe llegar es el usu_id de la tabla usuario para que desde la tabla admin se elimine tambien al usuario
	@DeleteMapping("/deleteAdmin")
	public ResponseEntity<ObjectNode> deleteProduct(@RequestParam("idUsu") int idUser){
		return this.admServices.deleteAdmin(idUser);
	}
}
