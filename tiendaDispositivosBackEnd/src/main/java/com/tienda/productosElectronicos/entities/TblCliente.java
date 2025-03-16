package com.tienda.productosElectronicos.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_cliente")
public class TblCliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cli_id", nullable = false)
	private Integer idCli;
	
	@OneToOne(targetEntity = usuario.class, fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name = "usu_id", nullable = false)
	private usuario idUsu;
	
	@Column(name = "cli_cedula", nullable = false, length=255)
	private String cedula;
	
	@Column(name = "cli_direccion", nullable = false, length=255)
	private String direccion;
	
	@Column(name = "cli_celular")
	private Integer celular;
	
	@Column(name = "cli_telefono")
	private Integer telefono;
	
	

	public Integer getIdCli() {
		return idCli;
	}

	public void setIdCli(Integer idCli) {
		this.idCli = idCli;
	}

	public usuario getIdUsu() {
		return idUsu;
	}

	public void setIdUsu(usuario idUsu) {
		this.idUsu = idUsu;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(Integer celular) {
		this.celular = celular;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
}
