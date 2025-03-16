package com.tienda.productosElectronicos.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_marca_productos")
public class TblMarcaProductos {
	

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "marca_id", nullable = false)
	private int idMarca;
	
	@Column(name = "marca_descripcion", nullable = false, length=255)
	private String descripcionMarca;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "marca")
    private List<TblProducto> marca;
	
	@JsonBackReference
	@ManyToOne(targetEntity = TblCategoria.class)
	@JoinColumn(name="categoria_id")
    private TblCategoria idCat;   

	public int getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}

	public String getDescripcionMarca() {
		return descripcionMarca;
	}

	public void setDescripcionMarca(String descripcionMarca) {
		this.descripcionMarca = descripcionMarca;
	}

	public List<TblProducto> getMarca() {
		return marca;
	}

	public void setMarca(List<TblProducto> marca) {
		this.marca = marca;
	}

	public TblCategoria getIdCat() {
		return idCat;
	}

	public void setIdCat(TblCategoria idCat) {
		this.idCat = idCat;
	}

}
