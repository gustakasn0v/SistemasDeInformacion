package net.excelsior.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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
	
	@Column(name="nombre_formacion")
	public String getFormacion() {
		return formacion;
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
	
	@Column(name="institucion")
	public String getInstitucion() {
		return institucion;
	}
	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}
	
	@Column(name="tipo_formacion")
	public String getTipoformacion() {
		return tipoformacion;
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
