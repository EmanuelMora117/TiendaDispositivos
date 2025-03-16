package com.tienda.productosElectronicos.repositories.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tienda.productosElectronicos.entities.TblAdmin;

@Repository
public interface RIAdmin extends JpaRepository<TblAdmin, Integer> {
	
	@Query("SELECT a FROM TblAdmin a JOIN FETCH a.idUsu u WHERE u.nombreUsu = :nombreUsu")
    TblAdmin getUserByNombreUsuario(@Param("nombreUsu") String nombreUsu);
	
	@Modifying
	@Query("DELETE FROM TblAdmin a WHERE a.idUsu.id = :idUser")
	void deleteAdminByUserId(@Param("idUser") int idUser);
}
