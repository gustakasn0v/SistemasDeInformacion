package net.excelsior.domain;

import java.util.HashSet;
import java.util.Set;
 



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;
 
@Entity
@Table(name="MATERIA")
public class MateriaModificada {
     
    @Id
    @Column(name="MATERIA_ID")
    @GeneratedValue
    private Long Id;
	
    @NotEmpty(message = "El código de la materia no puede estar vacío")
    @Length(max=6,message="El código de la materia debe tener 6 dígitos")
    @Column(name="CODIGO_MATERIA")
    private String codigo;
    
    @NotEmpty(message = "El nombre de la materia no puede estar vacío")
    @Column(name="NOMBRE_MATERIA")
    private String nombre;
    
     
    @ManyToMany(fetch = FetchType.LAZY)
    //@ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="MODIFICA", 
                joinColumns={@JoinColumn(name="MATERIA_ID")}, 
                inverseJoinColumns={@JoinColumn(name="NOMBRE_USUARIO_PROF")})
	public Set<Profesor> profesores = new HashSet<Profesor>();
     

 // Getter and Setter methods
    
	public Long getId() {
		return Id;
	}

	public void setId(Long materiaId) {
		this.Id = materiaId;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

         
}