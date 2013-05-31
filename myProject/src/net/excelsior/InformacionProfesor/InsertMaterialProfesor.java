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
public class InsertMaterialProfesor extends ActionSupport{
    
     private static final long serialVersionUID = 1L;
     private String nombreProf;
     private String cedulaProf;
     private String material1;
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
     
     public void setMaterial1(String tit1){
    	 this.material1 = tit1;
     }
     
     public String getMaterial1(){
    	 return this.material1;
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
         
         
         if (!material1.equals("")){
	         String insert = "insert into material_apoyo values ('" + material1 +
	                 "', '" + nombreUsuario + "');";
	         this.dBase.executeInsert(insert);
         }
         
         
         addActionError(getText("valid.profInfoInserted"));
         this.nombreProf = null;
         this.cedulaProf = null;
         this.material1= null;
         this.dBase.closeConnection();
         return "success";
 
     }
     
     
     
    
    
}
