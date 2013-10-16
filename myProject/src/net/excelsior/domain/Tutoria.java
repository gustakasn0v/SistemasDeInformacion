package net.excelsior.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.NotEmpty;

@Entity
@Table(name="TUTORIA")
public class Tutoria {

	@Id
	@Column(name="TUTORIA_ID")
	@GeneratedValue
	private Long Id;
	
	@NotEmpty(message = "El título del material no puede estar vacío")
	@Column(name="TITULO_TUTORIA")
	private String titulo;
		
	//Aqui supongo falta algo que diga que apunta a carrera
	@Column(name="CODIGO_CARRERA")
	private Integer codigoCarrera;
	
	@Column(name="NOMBRE_USUARIO_PROF")
	private String nombreUsuario;
	
	@Column(name="TIPO_TUTORIA")
	private String tipoTutoria;
	
	@Column(name="NOMBRE_ESTUDIANTE")
	private String nombreEstudiante;
	
	public Long getId(){
		return Id;
	}
	
	public void setId(Long tutoriaId){
		this.Id = tutoriaId;
	}
	
	public String getTitulo(){
		return titulo;
	}
	
	public void setTitulo(String titulo){
		this.titulo = titulo;
	}
	
	public Integer getCodigoCarrera(){
		return this.codigoCarrera;
	}
	
	public void setCodigoCarrera(Integer codigo){
		this.codigoCarrera = codigo;
	}
	
	public String getNombreUsuario(){
		return this.nombreUsuario;
	}
	
	public void setNombreUsuario(String nombre){
		this.nombreUsuario = nombre;
	}
	
	public String getTipoTutoria(){
		if (this.tipoTutoria.equals("1")){
			return "Curso en Cooperación Corto";
		}
		else if (this.tipoTutoria.equals("2")){
			return "Curso en Cooperación Largo";
		}
		else if (this.tipoTutoria.equals("3")){
			return "Proyecto de Grado";
		}
		else return this.tipoTutoria;
	}
	
	public void setTipoTutoria(String tipo){
		this.tipoTutoria = tipo;
	}

	public String getNombreEstudiante(){
		return this.nombreEstudiante;
	}
	
	public void setNombreEstudiante(String nombre){
		this.nombreEstudiante = nombre;
	}
	
}
