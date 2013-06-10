package net.excelsior.domain;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Table(name="formacion")
public class Titulo {
	
	private Long id;
	private String nombreUsuario;
	private String formacion;
	
	@Id
	@GeneratedValue
	@Column(name="USER_ID")	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="nombre_usuario")	
	public String getNombreUsuario() {
		return this.nombreUsuario;
	}
	
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	@Column(name="formacion")	
	public String getFormacion() {
		return this.formacion;
	}
	
	public void setFormacion(String formacion) {
		this.formacion = formacion;
	}

}
