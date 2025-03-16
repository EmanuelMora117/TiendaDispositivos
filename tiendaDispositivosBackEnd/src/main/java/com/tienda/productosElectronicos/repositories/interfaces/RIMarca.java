package com.tienda.productosElectronicos.repositories.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.tienda.productosElectronicos.entities.TblMarcaProductos;

@Repository
public interface RIMarca extends JpaRepository<TblMarcaProductos, Integer> {
	
	@Query("SELECT p FROM TblMarcaProductos p WHERE p.idCat.idCategoria = :categoriaId")
    List<TblMarcaProductos> findByIdCat(@Param("categoriaId") Integer categoriaId);
	
	TblMarcaProductos findBydescripcionMarca(String descripcion);
}
