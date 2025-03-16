package com.tienda.productosElectronicos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.tienda.productosElectronicos.entities.TblCliente;
import com.tienda.productosElectronicos.entities.usuario;
import com.tienda.productosElectronicos.helpers.ResponseHelper;
import com.tienda.productosElectronicos.models.DTOUsuarioCliente;
import com.tienda.productosElectronicos.repositories.interfaces.RICliente;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ClienteServices {
	
	@Autowired
	private RICliente riCliente;
	
	@Autowired
	private ResponseHelper responseHelper;
	
	public ResponseEntity<ObjectNode> insertData(DTOUsuarioCliente dtoUsuarioCliente) {
		
		String answer = "";
		
		usuario user = new usuario();
		
		user.setNombreUsu(dtoUsuarioCliente.getNombreUsu());
		user.setEmail(dtoUsuarioCliente.getEmail());
		user.setMiddle(dtoUsuarioCliente.getMiddle());
		user.setTipo(dtoUsuarioCliente.getTipo());
		
		TblCliente cli = new TblCliente();
		
		cli.setIdUsu(user);
		cli.setCedula(dtoUsuarioCliente.getCedula());
		cli.setDireccion(dtoUsuarioCliente.getDireccion());
		cli.setCelular(dtoUsuarioCliente.getCelular());
		cli.setTelefono(dtoUsuarioCliente.getTelefono());
		
		try {
			
			this.riCliente.save(cli);
			answer = "Datos insertados correctamente.";
			
		}catch(Exception e) {
			
			System.out.println("Error al insertar: " + e);
			answer = "Error al insertar datos.";
			
		}
		
		return this.responseHelper.returnLogProcess(answer);
	}
	public ResponseEntity<ObjectNode> updateCliente(TblCliente cliente){
		
		String answer = "";
		
		try {
			this.riCliente.save(cliente);
			answer = "Usuario actualizado correctamente.";
		} catch (Exception e) {
			System.out.println("Error al editar el usuario: " + e);
			answer = "Error al editar el usuario.";
		}
		return this.responseHelper.returnLogProcess(answer);
	}

	
	public ResponseEntity<ObjectNode> deleteCliente(int idUser){
		
		String answer = "";
		
		try {
			this.riCliente.deleteById(idUser);
			answer = "Usuario eliminado correctamente.";
		} catch (Exception e) {
			System.out.println("Error al intentar eliminar el usuario: " + e);
			answer = "Error al intentar eliminar el usuario.";
		}
		return this.responseHelper.returnLogProcess(answer);
	}
}

