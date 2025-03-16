package com.tienda.productosElectronicos.repositories.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tienda.productosElectronicos.entities.usuario;
import com.tienda.productosElectronicos.models.DTOUsuarioAdmin;
import com.tienda.productosElectronicos.models.DTOUsuarioCliente;

@Repository
public interface RIUsuario extends JpaRepository<usuario, Integer>{
	
	usuario findByNombreUsu(String name);
	
	@Query("SELECT new com.tienda.productosElectronicos.models.DTOUsuarioAdmin(u.id, u.nombreUsu, u.email, u.middle, u.tipo, a.estado, a.nivelAcceso) " +
		       "FROM usuario u " +
		       "JOIN u.admin a")
		List<DTOUsuarioAdmin> DtoUsuarioAdmins();
	
	
	@Query("SELECT new com.tienda.productosElectronicos.models.DTOUsuarioCliente(u.id, u.nombreUsu, u.email, u.middle, u.tipo, a.cedula, a.direccion, a.celular, a.telefono) " +
		       "FROM usuario u " +
		       "JOIN u.cliente a " +
		       "WHERE u.nombreUsu = :user")
		List<DTOUsuarioCliente> DtoUsuarioCliente(@Param("user") String user);
}
