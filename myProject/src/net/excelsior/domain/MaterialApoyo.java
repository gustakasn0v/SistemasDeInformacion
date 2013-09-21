package net.excelsior.domain;

import java.util.HashSet;
import java.util.Set;
 
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
 
@Entity
@Table(name="MATERIAL")
public class MaterialApoyo {
     
//    @Id
//    @Column(name="MATERIAL_ID")
//    @GeneratedValue
//    private Long materialId;
	
    @Id 
    @Column(name="TITULO")
    private String titulo;
     
    @Column(name="ARCHIVO")
    private String archivo;
    
    @Column(name="REVISOR")
    private String revisor;
     
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="REALIZADO_POR", 
                joinColumns={@JoinColumn(name="TITULO")}, 
                inverseJoinColumns={@JoinColumn(name="NOMBRE_USUARIO")})
    private Set<Profesor> profesores = new HashSet<Profesor>();
     
    public MaterialApoyo() {
    }
 
    public MaterialApoyo(String titulo, String archivo, String revisor) {
        this.titulo= titulo;
        this.archivo = archivo;
        this.revisor = revisor;
    }
         
    // Getter and Setter methods
}