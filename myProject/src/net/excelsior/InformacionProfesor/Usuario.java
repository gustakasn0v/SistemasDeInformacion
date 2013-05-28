/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.excelsior.InformacionProfesor;

/**
 *
 * @author marcos
 */
public class Usuario {
    
    private String nombreUsuario;
    private String contrasenia;
    private String nombre;
    private String eMail;
    private long cedula;
    
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
