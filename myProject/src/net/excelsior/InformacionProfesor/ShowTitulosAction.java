package net.excelsior.InformacionProfesor;
 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import net.excelsior.Authentication.Database;

public class ShowTitulosAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private List<String> titulos;
	private String professorUsername;
	private final Database dBase = new Database(
            getText("database.jdbcToken")+getText("database.dbname"),
			getText("database.login"),
			getText("database.password"));
	
	
	public List<String> getTitulos(){
		return titulos;
	}
	
	public void setTitulos(List<String> misTitulos){
		titulos = misTitulos;
	}
	
	public String getProfessorUsername(){
		return professorUsername;
	}
	
	public void setProfessorUsername(String professor){
		professorUsername = professor;
	}
	
	public String execute(){
		this.dBase.initializeConnection();
        
        String query = "select formacion from formacion where " +
                       "nombre_usuario = '" + professorUsername + "';";
        System.out.println(query);
        
        ResultSet rs = dBase.executeCommand(query);
        titulos = new ArrayList<String>();
        System.out.println("HOLA ");
        try{
        	while(rs.next()){
            titulos.add(rs.getString("formacion"));
        	System.out.println("HOLA " + rs.getString("formacion"));
        	}
        } catch (SQLException e){
            
            System.out.println("El profesor no esta registrado en el sistema.");
            System.out.println(e.getMessage());
            addActionError(getText("error.noProfessor"));
            return "error";
        }
        
		return "success";
		
	}
	
}
