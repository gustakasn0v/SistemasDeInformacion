package net.excelsior.domain;

import java.math.BigInteger;
import java.util.Date;

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
	@NotEmpty(message = "El título del material no puede estar vacío")
	@Column(name="TITULO_TUTORIA")
	private String titulo;
		
	//Aqui supongo falta algo que diga que apunta a carrera
	@Column(name="CODIGO_CARRERA")
	private BigInteger codigoCarrera;
	
	@Column(name="NOMBRE_USUARIO_PROF")
	private String nombreUsuario;
	
	@Column(name="TIPO_TUTORIA")
	private String tipoTutoria;
	
	@Column(name="NOMBRE_ESTUDIANTE")
	private String nombreEstudiante;
	
    @Column(name="FECHA_INIC")
    private Date fecha_inic;
    
    @Column(name="FECHA_FIN")
    private Date fecha_fin;
    
	public String getTitulo(){
		return titulo;
	}
	
	public void setTitulo(String titulo){
		this.titulo = titulo;
	}
	
	public BigInteger getCodigoCarrera(){
		return this.codigoCarrera;
	}	
	
	public void setCodigoCarrera(BigInteger codigo){
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
	
	public Date getFechaInic() {
		return fecha_inic;
	}

	public void setFechaInic(Date fecha_inic) {
		this.fecha_inic = fecha_inic;
	}
	
	
	public Date getFechaFin() {
		return fecha_fin;
	}

	public void setFechaFin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
}
