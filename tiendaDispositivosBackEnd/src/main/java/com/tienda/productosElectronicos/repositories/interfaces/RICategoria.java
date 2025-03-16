package com.tienda.productosElectronicos.repositories.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tienda.productosElectronicos.entities.TblCategoria;

@Repository
public interface RICategoria extends JpaRepository<TblCategoria, Integer> {
	
	List<TblCategoria> findAll();
}
