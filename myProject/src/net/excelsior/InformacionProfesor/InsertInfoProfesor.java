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
public class InsertInfoProfesor extends ActionSupport{
    
     private static final long serialVersionUID = 1L;
     private String nombreProf;
     private String cedulaProf;
     private String titulo1;
     private String titulo2;
     private String titulo3;
     private final Database dBase = new Database(
             getText("database.jdbcToken")+getText("database.dbname"),
			getText("database.login"),
			getText("database.password"));
     
     
     public void setCedulaProf(String ced){
    	 this.cedulaProf = ced;
     }
     
     public String getCedulaProf(){
    	 return this.cedulaProf;
     }
     
     public void setTitulo1(String tit1){
    	 this.titulo1 = tit1;
     }
     
     public String getTitulo1(){
    	 return this.titulo1;
     }
     /* Falta verificar un monton de cosas y hacerlo mas ordenado con una 
        clase profesor! El nombre ingresado, por ahora, debe ser el nombre 
        de usuario*/
     
     public String execute(){
    	 
    	 this.dBase.initializeConnection();
         
         String query = "select nombre_usuario from usuario where " +
                        "cedula = " + this.cedulaProf + ";";
         System.out.println(query);
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
         
         String insert = "insert into formacion values ('" + titulo1 +
                 "', '" + nombreUsuario + "');";
         this.dBase.executeInsert(insert);
         this.dBase.closeConnection();
         addActionError(getText("valid.profInfoInserted"));
         this.nombreProf = null;
         this.cedulaProf = null;
         this.titulo1= null;
         this.titulo2= null;
         this.titulo3= null;
         return "success";
 
     }
     
     
     
    
    
}
