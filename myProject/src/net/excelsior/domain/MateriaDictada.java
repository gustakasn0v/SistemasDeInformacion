package net.excelsior.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="DICTA")
public class MateriaDictada {
     
    @Id
    @Column(name="CODIGO_MATERIA")
    private String codigoMateria;
	
    @Column(name="NOMBRE_USUARIO_PROF")
    private String nombreUsuario;
    
    @Column(name="TRIMESTRE")
    private String trimestre;
    
    @Column(name="cant_nota_1")
    private Integer cantidadUnos;
    
    @Column(name="cant_nota_2")
    private Integer cantidadDos;
    
    @Column(name="cant_nota_3")
    private Integer cantidadTres;
    
    @Column(name="cant_nota_4")
    private Integer cantidadCuatros;
    
    @Column(name="cant_nota_5")
    private Integer cantidadCincos;
    
    @Column(name="cant_retirados")
    private Integer cantidadRetirados;

	/**
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/**
	 * @return the trimestre
	 */
	public String getTrimestre() {
		return trimestre;
	}

	/**
	 * @param trimestre the trimestre to set
	 */
	public void setTrimestre(String trimestre) {
		this.trimestre = trimestre;
	}

	/**
	 * @return the cantidadUno
	 */
	public Integer getCantidadUnos() {
		return cantidadUnos;
	}

	/**
	 * @param cantidadUno the cantidadUno to set
	 */
	public void setCantidadUno(Integer cantidadUnos) {
		this.cantidadUnos = cantidadUnos;
	}

	/**
	 * @return the cantidadDos
	 */
	public Integer getCantidadDos() {
		return cantidadDos;
	}

	/**
	 * @param cantidadDos the cantidadDos to set
	 */
	public void setCantidadDos(Integer cantidadDos) {
		this.cantidadDos = cantidadDos;
	}

	/**
	 * @return the cantidadTres
	 */
	public Integer getCantidadTres() {
		return cantidadTres;
	}

	/**
	 * @param cantidadTres the cantidadTres to set
	 */
	public void setCantidadTres(Integer cantidadTres) {
		this.cantidadTres = cantidadTres;
	}

	/**
	 * @return the cantidadCuatros
	 */
	public Integer getCantidadCuatros() {
		return cantidadCuatros;
	}

	/**
	 * @param cantidadCuatros the cantidadCuatros to set
	 */
	public void setCantidadCuatros(Integer cantidadCuatros) {
		this.cantidadCuatros = cantidadCuatros;
	}

	/**
	 * @return the cantidadCincos
	 */
	public Integer getCantidadCincos() {
		return cantidadCincos;
	}

	/**
	 * @param cantidadCincos the cantidadCincos to set
	 */
	public void setCantidadCincos(Integer cantidadCincos) {
		this.cantidadCincos = cantidadCincos;
	}

	/**
	 * @return the cantidadRetirados
	 */
	public Integer getCantidadRetirados() {
		return cantidadRetirados;
	}

	/**
	 * @param cantidadRetirados the cantidadRetirados to set
	 */
	public void setCantidadRetirados(Integer cantidadRetirados) {
		this.cantidadRetirados = cantidadRetirados;
	}

	/**
	 * @return the codigoMateria
	 */
	public String getCodigoMateria() {
		return codigoMateria;
	}

	/**
	 * @param codigoMateria the codigoMateria to set
	 */
	public void setCodigoMateria(String codigoMateria) {
		this.codigoMateria = codigoMateria;
	}
}