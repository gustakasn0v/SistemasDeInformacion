package net.excelsior.domain;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Table(name="formacion")
public class Titulo {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Column(name="nombre_usuario")
	private String nombreUsuario;
	
	@Column(name="formacion")	
	private String formacion;
	
		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
		
	public String getNombreUsuario() {
		return this.nombreUsuario;
	}
	
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	
	public String getFormacion() {
		return this.formacion;
	}
	
	public void setFormacion(String formacion) {
		this.formacion = formacion;
	}

}
