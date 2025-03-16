package com.tienda.productosElectronicos.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public class usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usu_id", nullable = false)
	private Integer id;
	
	@Column(name = "usu_nombre", nullable = false, length=255)
	private String nombreUsu;
	
	@Column(name = "usu_email", nullable = false, length=255)
	private String email;
	
	@Column(name = "usu_pass", nullable = false, length=255)
	private String middle;
	
	@Column(name = "usu_tipo", length=25)
	private String tipo;
	
	@OneToOne(mappedBy = "idUsu")
    private TblAdmin admin;
	
	@OneToOne(mappedBy = "idUsu")
    private TblCliente cliente;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreUsu() {
		return nombreUsu;
	}

	public void setNombreUsu(String nombreUsu) {
		this.nombreUsu = nombreUsu;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMiddle() {
		return middle;
	}

	public void setMiddle(String middle) {
		this.middle = middle;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public TblAdmin getAdmin() {
		return admin;
	}

	public void setAdmin(TblAdmin admin) {
		this.admin = admin;
	}

	public TblCliente getCliente() {
		return cliente;
	}

	public void setCliente(TblCliente cliente) {
		this.cliente = cliente;
	}
}
