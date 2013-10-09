package net.excelsior.domain;

import java.util.HashSet;
import java.util.Set;
 

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.NotEmpty;
 
@Entity
@Table(name="MATERIAL_APOYO")
public class MaterialApoyo {
     
    @Id
    @Column(name="MATERIAL_ID")
    @GeneratedValue
    private Long Id;
	
    @NotEmpty(message = "El nombre del material no puede estar vacío")
    @Column(name="TITULO_MATERIAL")
    private String titulo;
     
    @NotEmpty(message = "El campo del archivo no puede estar vacío")
    @Column(name="ARCHIVO")
    private String archivo;
    
    @NotEmpty(message = "El nombre del revisor no puede estar vacío")
    @Column(name="REVISOR")
    private String revisor;
     
    @ManyToMany(fetch = FetchType.LAZY)
    //@ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="REALIZADO_POR", 
                joinColumns={@JoinColumn(name="MATERIAL_ID")}, 
                inverseJoinColumns={@JoinColumn(name="NOMBRE_USUARIO_PROF")})
	public Set<Profesor> profesores = new HashSet<Profesor>();
     

 // Getter and Setter methods
    
	public Long getId() {
		return Id;
	}

	public void setId(Long materialId) {
		this.Id = materialId;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public String getRevisor() {
		return revisor;
	}

	public void setRevisor(String revisor) {
		this.revisor = revisor;
	}
         
}