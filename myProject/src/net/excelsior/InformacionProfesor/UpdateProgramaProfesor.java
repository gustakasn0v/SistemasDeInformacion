package net.excelsior.InformacionProfesor;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import net.excelsior.Authentication.Database;

/**
 *
 * @author marcos
 */
public class UpdateProgramaProfesor extends ActionSupport{
    
     private static final long serialVersionUID = 1L;
     private String nombreProf;
     private String cedulaProf;
     private String programa1;
     private String programa2;
     private final Database dBase = new Database(
             getText("database.jdbcToken")+getText("database.dbname"),
			getText("database.login"),
			getText("database.password"));
     
     
     public void setNombreProf(String nom){
    	 this.nombreProf = nom;
     }
     
     public void setCedulaProf(String ced){
    	 this.cedulaProf = ced;
     }
     
     public String getCedulaProf(){
    	 return this.cedulaProf;
     }
     
     public void setPrograma1(String tit1){
    	 this.programa1 = tit1;
     }
     
     public String getPrograma1(){
    	 return this.programa1;
     }
     
     public void setPrograma2(String tit2){
    	 this.programa2 = tit2;
     }
     
     public String getPrograma2(){
    	 return this.programa2;
     }
     
     /* Falta verificar un monton de cosas y hacerlo mas ordenado con una 
        clase profesor! */
     
     public String execute(){
    	 
    	 this.dBase.initializeConnection();
         
         String query = "select nombre_usuario from usuario where " +
                        "cedula = " + this.cedulaProf + ";";
         ResultSet rs = dBase.executeCommand(query);
         String nombreUsuario = null;
         
         try{
             rs.next();
             nombreUsuario = rs.getString("nombre_usuario");
             
         } catch (SQLException e){
             
             System.out.println("El profesor no esta registrado en el sistema.");
             System.out.println(e.getMessage());
             addActionError(getText("error.noProfessor"));
             return "error";
         }
         
         
         if (!programa1.equals("") && !programa2.equals("")){
	         String update = "update programa set progama = '" + programa2 + "' where formacion = '" 
	        		 + programa1 + "' and nombre_usuario ='" + nombreUsuario + "';";
	         
	         this.dBase.executeInsert(update);
         }
         
         
         addActionError(getText("valid.profInfoUpdated"));
         this.nombreProf = null;
         this.cedulaProf = null;
         this.programa1= null;
         this.dBase.closeConnection();
         return "success";
 
     }

    
}