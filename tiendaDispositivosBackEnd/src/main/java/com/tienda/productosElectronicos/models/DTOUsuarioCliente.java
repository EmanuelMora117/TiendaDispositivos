package com.tienda.productosElectronicos.models;

public class DTOUsuarioCliente extends DTOUsuario {
	private String cedula;
	private String direccion;
	private int celular;
	private int telefono;
	
	public DTOUsuarioCliente(Integer id, String nombreUsu, String email, String middle, String tipo, 
							 String cedula, String direccion, int celular, int telefono) {
        super(id, nombreUsu, email, middle, tipo);  // Llamamos al constructor de DTOUsuario
        this.cedula = cedula;
        this.direccion = direccion;
        this.celular = celular;
        this.telefono = telefono;
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
	public void setCelular(int celular) {
		this.celular = celular;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
}
