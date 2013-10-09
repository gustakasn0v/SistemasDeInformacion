package net.excelsior.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


import org.hibernate.validator.NotEmpty;

import java.util.Date;

@Entity
@Table(name="formacion")
public class Titulo {

	private Long id;
	private String formacion;
	private String nombreusuario;
	private String institucion;
	private String tipoformacion;
//	private Date fechaFormacion;
	
	@Id
	@GeneratedValue
	@Column(name="FORMACION_ID")	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@NotEmpty(message = "El nombre de la formacion no puede estar vacío")
	@Column(name="nombre_formacion")
	public String getFormacion() {
		return this.formacion;
	}
	public void setFormacion(String formacion) {
		this.formacion = formacion;
	}
	
	@Column(name="nombre_usuario_prof")
	public String getNombreusuario() {
		return nombreusuario;
	}
	public void setNombreusuario(String nu) {
		this.nombreusuario = nu;
	}
	
	@NotEmpty(message = "El nombre de la institucion no puede estar vacío")
	@Column(name="institucion")
	public String getInstitucion() {
		return institucion;
	}
	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}
	
	@NotEmpty(message = "El tipo de formacion no puede estar vacío")
	@Column(name="tipo_formacion")
	public String getTipoformacion() {
		if (this.tipoformacion.equals("1")){
			return "Titulo";
		}
		else if (this.tipoformacion.equals("2")){
			return "Curso";
		}
		else return this.tipoformacion;
	}
	public void setTipoformacion(String tipoformacion) {
		this.tipoformacion = tipoformacion;
	}
	
//	@Column(name="fecha_formacion")
//	public Date getFechaFormacion() {
//		return fechaFormacion;
//	}
//	public void setFechaFormacion(Date ff) {
////		System.out.println("Webo " + ff); 
////		DateFormat formatter = null;
////		Date convertedDate = null;
////		formatter = new SimpleDateFormat("dd/MM/yyyy");
////		try {
////			convertedDate = (Date) formatter.parse(ff);
////		} catch (ParseException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		System.out.println("Hola" + convertedDate);
////		this.fechaFormacion = convertedDate;
//		this.fechaFormacion = ff;
//	}

}
