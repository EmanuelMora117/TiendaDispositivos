package com.tienda.productosElectronicos.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.tienda.productosElectronicos.services.UsuarioServices;
import com.tienda.productosElectronicos.entities.usuario;
import com.tienda.productosElectronicos.models.DTOUsuarioAdmin;
import com.tienda.productosElectronicos.models.DTOUsuarioCliente;

@RestController
@RequestMapping("/user")
public class UsuarioController {
	
	@Autowired
	private UsuarioServices usuarioServices;
	
	@GetMapping("/getDataUsers")
	public ResponseEntity<JsonNode>getDataUsers(@RequestParam("user") String user){
		
		ObjectMapper objectMapper = new ObjectMapper();
		ObjectNode jsonNode = objectMapper.createObjectNode();
		
		usuario usu = this.usuarioServices.getUsu(user);
		JsonNode userJson = objectMapper.valueToTree(usu);
		
		jsonNode.set("Users", userJson);
		return ResponseEntity.ok(jsonNode);
	}
	
	@GetMapping("/getClientByUser")
	public List<DTOUsuarioCliente>getClientByUser(@RequestParam("user") String user){
		return this.usuarioServices.getClientByUser(user);
	}
	
	
	@GetMapping("/getAllAdmins")
	public List<DTOUsuarioAdmin>getAllAdmins(){
		return this.usuarioServices.getAllAdmins();
	}
	
	@PutMapping("/updateUsuario")
	public ResponseEntity<ObjectNode> updateUsuario(@RequestBody usuario user){
		return this.usuarioServices.updateUser(user);
	}
}
