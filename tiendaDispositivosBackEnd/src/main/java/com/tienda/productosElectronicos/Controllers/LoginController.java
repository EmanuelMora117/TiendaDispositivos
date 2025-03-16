package com.tienda.productosElectronicos.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.tienda.productosElectronicos.models.DTOLogin;
import com.tienda.productosElectronicos.services.UsuarioServices;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	  @Autowired
	  private UsuarioServices usuarioServices;
	  
	  @PostMapping("/loginUser")
	    public ResponseEntity<ObjectNode> login(@RequestBody DTOLogin dtoLogin) {
		  
		 return this.usuarioServices.getUsuario(dtoLogin);
	    }
}
