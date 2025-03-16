package com.tienda.productosElectronicos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tienda.productosElectronicos.repositories.interfaces.RIAdmin;
import com.tienda.productosElectronicos.repositories.interfaces.RIUsuario;

import jakarta.transaction.Transactional;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.tienda.productosElectronicos.entities.TblAdmin;
import com.tienda.productosElectronicos.entities.usuario;
import com.tienda.productosElectronicos.helpers.ResponseHelper;
import com.tienda.productosElectronicos.models.DTOUsuarioAdmin;

@Service
@Transactional
public class AdminServices {
	
	@Autowired
	private RIAdmin riAdmin;
	
	@Autowired
	private RIUsuario usu;
	
	@Autowired
	private ResponseHelper responseHelper;
	
	public ResponseEntity<ObjectNode> insertData(DTOUsuarioAdmin dtoUsuarioAdmin) {
		
		String answer = "";
		usuario user = new usuario();
		
		user.setNombreUsu(dtoUsuarioAdmin.getNombreUsu());
		user.setEmail(dtoUsuarioAdmin.getEmail());
		user.setMiddle(dtoUsuarioAdmin.getMiddle());
		user.setTipo(dtoUsuarioAdmin.getTipo());
		
		TblAdmin admin = new TblAdmin();
		
		admin.setIdUsu(user);
		admin.setEstado(dtoUsuarioAdmin.getEstado());
		admin.setNivelAcceso(dtoUsuarioAdmin.getNivelAcceso());
		
		try {
			this.riAdmin.save(admin);
			answer = "Datos insertados correctamente.";
		}catch(Exception e) {
			System.out.println("Error al insertar: " + e);
			answer = "Error al insertar datos.";
		}
		
		return this.responseHelper.returnLogProcess(answer);
	}
	
	/*public ResponseEntity<ObjectNode> updateAdmin(DTOUsuarioAdmin dtoUsuarioAdmin){
		
		String answer = "";
		
		
		Optional<usuario> existingUserOpt = this.usu.findById(dtoUsuarioAdmin.getId());
		
		 if (existingUserOpt.isPresent()) {
			 
			 usuario user = existingUserOpt.get();
			 user.setId(dtoUsuarioAdmin.getId());
			 user.setNombreUsu(dtoUsuarioAdmin.getNombreUsu());
			 user.setEmail(dtoUsuarioAdmin.getEmail());
			 user.setMiddle(dtoUsuarioAdmin.getMiddle());
			 user.setTipo(dtoUsuarioAdmin.getTipo());
			 
			 Optional<TblAdmin> existingAdminOpt = this.riAdmin.findById(user.getId());
			 
			 if (existingAdminOpt.isPresent()) {
				 TblAdmin admin = existingAdminOpt.get();
		         admin.setEstado(dtoUsuarioAdmin.getEstado());
		         admin.setNivelAcceso(dtoUsuarioAdmin.getNivelAcceso());
		         
		         try {
			            
			            this.usu.save(user);
			            this.riAdmin.save(admin);
			            answer = "Administrador actualizado correctamente.";
			        } catch (Exception e) {
			            System.out.println("Error al editar el usuario: " + e);
			            answer = "Error al editar el usuario.";
			        }
			 }
		 }
		return this.responseHelper.returnLogProcess(answer);
	}*/
	
	public ResponseEntity<ObjectNode> updateAdmin(DTOUsuarioAdmin dtoUsuarioAdmin) {
	    String answer = "";

	    Optional<usuario> existingUserOpt = this.usu.findById(dtoUsuarioAdmin.getId());
	    
	    if (existingUserOpt.isPresent()) {
	        usuario user = existingUserOpt.get();
	        user.setNombreUsu(dtoUsuarioAdmin.getNombreUsu());
	        user.setEmail(dtoUsuarioAdmin.getEmail());
	        user.setMiddle(dtoUsuarioAdmin.getMiddle());
	        user.setTipo(dtoUsuarioAdmin.getTipo());

	        Optional<TblAdmin> existingAdminOpt = this.riAdmin.findById(user.getId());
	        
	        if (existingAdminOpt.isPresent()) {
	           
	            TblAdmin admin = existingAdminOpt.get();
	            admin.setEstado(dtoUsuarioAdmin.getEstado());
	            admin.setNivelAcceso(dtoUsuarioAdmin.getNivelAcceso());
	            
	            try {
	               
	                this.usu.save(user); 
	                this.riAdmin.saveAndFlush(admin); 
	                answer = "Administrador actualizado correctamente.";
	            } catch (Exception e) {
	                System.out.println("Error al editar el usuario: " + e);
	                answer = "Error al editar el usuario.";
	            }
	        } else {
	            answer = "No se encontró el administrador asociado al usuario.";
	        }
	    }

	    return this.responseHelper.returnLogProcess(answer);  
	}
	
	public ResponseEntity<ObjectNode> deleteAdmin(int idUser){
		
		String answer = "";
		
		try {
			
			this.riAdmin.deleteAdminByUserId(idUser);
			this.usu.deleteById(idUser);
			answer = "Administrador eliminado correctamente.";
		} catch (Exception e) {
			System.out.println("Error al intentar eliminar el administrador: " + e);
			answer = "Error al intentar eliminar el administrado.";
		}
		return this.responseHelper.returnLogProcess(answer);
	}
}
