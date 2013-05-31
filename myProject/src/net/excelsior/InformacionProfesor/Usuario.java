/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.excelsior.InformacionProfesor;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import net.excelsior.Authentication.Database;

/**
 *
 * @author marcos
 */
public class InsertInfoUsuario extends ActionSupport{
	
    private static final long serialVersionUID = 1L;    
    private String nombreUsuario;
    private String contrasenia;
    private String nombre;
    private String eMail;
    private long cedula;
    private final Database dBase = new Database(
            getText("database.jdbcToken")+getText("database.dbname"),
			getText("database.login"),
			getText("database.password"));    
    
    
    public String getNombreUsuario(){
        return this.nombreUsuario;
    }
    
    public void setNombreUsuario(String name){ 
        this.nombreUsuario = name; 
    }
    
    public String getContrasenia(){
        return this.contrasenia;
    }
    
    public void setContrasenia(String pass){
        this.contrasenia = pass;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String name){
        this.nombre = name;
    }
    
    public String getEMail(){
        return this.eMail;
    }
    
    public void setEMail(String mail){
        this.eMail = mail;
    }
    
    public long getCedula(){
        return this.cedula;
    }
    
    public void setCedula(long ci){
        this.cedula = ci;
    }
    
   

}