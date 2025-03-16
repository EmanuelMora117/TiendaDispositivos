package com.tienda.productosElectronicos.repositories.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tienda.productosElectronicos.entities.TblCliente;

@Repository
public interface RICliente extends JpaRepository<TblCliente, Integer> {
	
}
