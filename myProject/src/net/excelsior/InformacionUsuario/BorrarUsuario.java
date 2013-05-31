package net.excelsior.InformacionUsuario;

import com.opensymphony.xwork2.ActionSupport;
import net.excelsior.Authentication.Database;
import net.excelsior.Authentication.AuthDatabase;
import net.excelsior.InformacionUsuario.CrearUsuario;

public class BorrarUsuario extends ActionSupport{
	
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
    private final AuthDatabase dBase2 = new AuthDatabase(
			);   

    
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
    
    

public String execute(){
	
	 this.dBase.initializeConnection();
	 
	if (!this.dBase2.userExists(nombreUsuario)) return "error";
    
	
    String user = "delete from usuario where nombre_usuario = '" + nombreUsuario +
            "';";
   
    System.out.println(user);
    this.dBase.executeInsert(user);
    
    
    addActionError(getText("valid.userInfoInserted"));
    this.nombreUsuario = null;
    this.contrasenia = null;
    this.nombre= null;
    this.eMail= null;
    this.cedula= 0;
    this.dBase.closeConnection();
    return "success";
	}

}