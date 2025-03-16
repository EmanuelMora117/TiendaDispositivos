package com.tienda.productosElectronicos.models;

public class DTOUsuarioAdmin extends DTOUsuario{
	private String estado;
	private String nivelAcceso;
	
	public DTOUsuarioAdmin(Integer id, String nombreUsu, String email, String middle, String tipo, String estado, String nivelAcceso) {
        super(id, nombreUsu, email, middle, tipo);
        this.estado = estado;
        this.nivelAcceso = nivelAcceso;
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
