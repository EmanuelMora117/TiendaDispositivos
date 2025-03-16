package com.tienda.productosElectronicos.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_categoria")
public class TblCategoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "categoria_id", nullable = false)
	private Integer idCategoria;
	
	@Column(name = "categoria_nombre", nullable = false, length=255)
	private String categoriaDescripcion;
	
	@Column(name = "categoria_img1", nullable = false)
	private byte[] imagen1;
	
	@Column(name = "categoria_img2", nullable = false)
	private byte[] imagen2;
	
	@Column(name = "categoria_img3", nullable = false)
	private byte[] imagen3;
	
	@JsonBackReference
	@OneToMany(mappedBy = "idCat")
    private List<TblMarcaProductos> marca;
	
	
    public TblCategoria() {}

   
    public TblCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getCategoriaDescripcion() {
		return categoriaDescripcion;
	}

	public void setCategoriaDescripcion(String categoriaDescripcion) {
		this.categoriaDescripcion = categoriaDescripcion;
	}

	/*public List<TblProducto> getProducto() {
		return producto;
	}

	public void setProducto(List<TblProducto> producto) {
		this.producto = producto;
	}*/

	public byte[] getImagen1() {
		return imagen1;
	}

	public void setImagen1(byte[] imagen) {
		this.imagen1 = imagen;
	}

	public byte[] getImagen2() {
		return imagen2;
	}

	public void setImagen2(byte[] imagen2) {
		this.imagen2 = imagen2;
	}

	public byte[] getImagen3() {
		return imagen3;
	}

	public void setImagen3(byte[] imagen3) {
		this.imagen3 = imagen3;
	}
}
