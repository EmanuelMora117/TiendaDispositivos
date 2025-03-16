package com.tienda.productosElectronicos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.tienda.productosElectronicos.repositories.interfaces.RIUsuario;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.tienda.productosElectronicos.entities.usuario;
import com.tienda.productosElectronicos.helpers.ResponseHelper;
import com.tienda.productosElectronicos.models.DTOLogin;
import com.tienda.productosElectronicos.models.DTOUsuarioAdmin;
import com.tienda.productosElectronicos.models.DTOUsuarioCliente;

@Service
public class UsuarioServices {
	
	@Autowired
	private RIUsuario usu;
	
	@Autowired
	private ResponseHelper responseHelper;
	
	public usuario getUsu(String name) {
		return this.usu.findByNombreUsu(name);
	}
	
	public ResponseEntity<ObjectNode> getUsuario(DTOLogin dtoLogin) {
		String answer = "";
		
		
		try {
			usuario user = this.usu.findByNombreUsu(dtoLogin.getUsername());
			if(user != null) {
				if(user.getMiddle().equals(dtoLogin.getMiddle())) {
					answer = "Inicio de sesion Completado";
					return this.responseHelper.returnLogProcess(answer, user.getTipo());
				}else {
					answer = "Datos incorrectos.";
				}
			}else {
				answer = "Usuario no existente.";
			}
			
		} catch (Exception e) {
			System.out.println("Error: " + e);
			answer = "Error.";
		}
		
		return this.responseHelper.returnLogProcess(answer, null);
	}
	
	public List<DTOUsuarioCliente>getClientByUser(String user){
		 return usu.DtoUsuarioCliente(user);
	}
	
	public List<DTOUsuarioAdmin>getAllAdmins(){
		 return usu.DtoUsuarioAdmins();
	}
	
	public ResponseEntity<ObjectNode> updateUser(usuario user){
		
		String answer = "";
		
		try {
			this.usu.save(user);
			answer = "Datos actualizados correctamente.";
		} catch (Exception e) {
			System.out.println("Error al actualizar: " + e);
			answer = "Error al actualizar.";
		}
		
		return this.responseHelper.returnLogProcess(answer);
	}
}
