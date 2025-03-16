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
@Table(name = "tbl_admin")
public class TblAdmin{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "adm_id", nullable = false)
	private Integer idAdm;
	
	@OneToOne(targetEntity = usuario.class, fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name = "usu_id", nullable = false)
	private usuario idUsu;
	
	@Column(name = "adm_estado", nullable = false, length=255)
	private String estado;
	
	@Column(name = "adm_nivel_acceso", nullable = false, length=255)
	private String nivelAcceso;

	public Integer getIdAdm() {
		return idAdm;
	}

	public void setIdAdm(Integer idAdm) {
		this.idAdm = idAdm;
	}

	public usuario getIdUsu() {
		return idUsu;
	}

	public void setIdUsu(usuario idUsu) {
		this.idUsu = idUsu;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNivelAcceso() {
		return nivelAcceso;
	}

	public void setNivelAcceso(String nivelAcceso) {
		this.nivelAcceso = nivelAcceso;
	}     
}
