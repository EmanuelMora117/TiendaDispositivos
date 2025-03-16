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
import com.tienda.productosElectronicos.entities.TblCliente;
import com.tienda.productosElectronicos.entities.usuario;
import com.tienda.productosElectronicos.models.DTOUsuarioCliente;
import com.tienda.productosElectronicos.services.ClienteServices;

@RestController
@RequestMapping("cliente")
public class ClienteController {
	
	@Autowired
	private ClienteServices clienteServices;
	
	@PostMapping("/createCliente")
	public ResponseEntity<ObjectNode> createCliente(@RequestBody DTOUsuarioCliente dtoUsuarioCliente){
		return this.clienteServices.insertData(dtoUsuarioCliente);
	}
	
	@PutMapping("/updateCliente")
	public ResponseEntity<ObjectNode> updateCliente(@RequestBody TblCliente cliente){
		return this.clienteServices.updateCliente(cliente);
	}
	
	//aqui debe llegar es el usu_id de la tabla usuario ya que este id es el mismo que en la tabla cliente asi se eliminaran los dos
	@DeleteMapping("/deleteCliente")
	public ResponseEntity<ObjectNode> deleteProduct(@RequestParam("idUsu") int idUser){
		return this.clienteServices.deleteCliente(idUser);
	}
}
