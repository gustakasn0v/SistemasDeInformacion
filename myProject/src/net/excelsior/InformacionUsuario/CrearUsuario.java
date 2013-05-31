package net.excelsior.InformacionUsuario;

import com.opensymphony.xwork2.ActionSupport;
import net.excelsior.Authentication.Database;
import net.excelsior.Authentication.AuthDatabase;



public class CrearUsuario extends ActionSupport{
	
    private static final long serialVersionUID = 1L;    
    private String nombreUsuario;
    private String contrasenia;
    private String nombre;
    private String eMail;
    private String cedula;
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
    
    public String getCedula(){
        return this.cedula;
    }
    
    public void setCedula(String ci){
        this.cedula = ci;
    }
    
    public static boolean esNumero( String num ){
        try{
            Long y = Long.parseLong(num);
            return true;
        }
        catch( NumberFormatException err ){
            return false;
        }
    }
    
    

public String execute(){
	
	 this.dBase.initializeConnection();
	 
	if (this.dBase2.userExists(nombreUsuario)) return "error";
    
	if (nombreUsuario.equals("") || contrasenia.equals("") || nombre.equals("") || eMail.equals("")){ 
		addActionError(getText("error.vacio"));
		return "error";
	}	
	
	if (!(eMail.indexOf("@") > 0)){
		addActionError(getText("error.correo"));
		return "error";
	}	
	
	if (!esNumero(cedula)) {
		addActionError(getText("error.cedula"));
		return "error";
	}	
	
    String user = "insert into usuario values ('" + nombreUsuario +
            "', '" + contrasenia + "', '" + nombre +
            "', '" + eMail + "'," + cedula +");";
   
    System.out.println(user);
    this.dBase.executeInsert(user);
    
    
    addActionError(getText("valid.userInfoInserted"));
    this.nombreUsuario = null;
    this.contrasenia = null;
    this.nombre= null;
    this.eMail= null;
    this.cedula= null;
    this.dBase.closeConnection();
    return "success";
	}

}