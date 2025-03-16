package com.tienda.productosElectronicos.repositories.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.tienda.productosElectronicos.entities.TblProducto;

@Repository
public interface RIProducto extends JpaRepository<TblProducto, Integer> {
	
	/*@Query("SELECT p FROM TblProducto p WHERE p.idCategoria.idCategoria = :categoriaId")
    List<TblProducto> findByCategoriaId(@Param("categoriaId") Integer categoriaId);*/
}
