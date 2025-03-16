package com.tienda.productosElectronicos.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DTOUsuario {
	
	private Integer id;
	private String nombreUsu;
	private String email;
	private String middle;
	private String tipo;
	
	public DTOUsuario(Integer id, String nombreUsu, String email, String middle, String tipo) {
        this.id = id;
		this.nombreUsu = nombreUsu;
        this.email = email;
        this.middle = middle;
        this.tipo = tipo;
    }
	
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
	
	
}
