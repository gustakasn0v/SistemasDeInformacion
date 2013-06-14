package net.excelsior.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="formacion")
public class Titulo {

	private Long id;
	private String formacion;
	private String nombreusuario;
	
	@Id
	@GeneratedValue
	@Column(name="FORMACION_ID")	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="formacion")
	public String getFormacion() {
		return formacion;
	}
	public void setFormacion(String formacion) {
		this.formacion = formacion;
	}
	
	@Column(name="nombre_usuario")
	public String getNombreusuario() {
		return nombreusuario;
	}
	public void setNombreusuario(String nu) {
		this.nombreusuario = nu;
	}
	

}
