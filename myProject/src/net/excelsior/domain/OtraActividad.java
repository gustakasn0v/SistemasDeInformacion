package net.excelsior.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="OTRA_ACTIVIDAD")
public class OtraActividad {
     
    @Id
    @Column(name="NOMBRE_ACTIVIDAD")
    private String nombre_actividad;
	
    @Id
    @Column(name="NOMBRE_USUARIO_PROF")
    private String nombre_usuario_prof;
    
    @Column(name="FECHA_INIC")
    private Date fecha_inic;
    
    @Column(name="FECHA_FIN")
    private Date fecha_fin;

	/**
	 * @return the nombreUsuario
	 */
	public String getNombreUsuarioProf() {
		return nombre_usuario_prof;
	}

	/**
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreActividad(String nombreActividad) {
		this.nombre_actividad = nombreActividad;
	}

	public String getNombreActividad() {
		return nombre_actividad;
	}

	/**
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreUsuarioProf(String nombre_usuario_prof) {
		this.nombre_usuario_prof = nombre_usuario_prof;
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