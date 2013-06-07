package net.excelsior.InformacionProfesor;
 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import net.excelsior.Authentication.Database;

public class ModifyTitles extends ActionSupport implements SessionAware{

	private Map<String,Object> session;
	private static final long serialVersionUID = 1L;
	private List<String> titulos;
	private long cedula;
	private String professorUsername ; //Tentativamente esto lo voy a usar como nombre del profesor
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
	
	public void setCedula(long ci){
		cedula = ci;
	}
	
	public long getCedula(){
		return cedula;
	}
	
	public String execute(){
		
		//Map session = ActionContext.getContext().getSession();
		//session.put("cedula",cedula);
		
		this.session = ActionContext.getContext().getSession();
		this.professorUsername = (String)this.session.get("username");
		
		this.dBase.initializeConnection();
        
        String queryTitulos = "select formacion from formacion F where F.nombre_usuario = '" + this.professorUsername + "';";
        
		System.out.println(queryTitulos);
        
        ResultSet resultTitulos = dBase.executeCommand(queryTitulos);
        
        titulos = new ArrayList<String>();
        try{
        	while(resultTitulos.next()){
        		System.out.println("webo");
        		titulos.add(resultTitulos.getString("formacion"));
        	}
        	
        } catch (SQLException e){
            
            System.out.println("El profesor no esta registrado en el sistema.");
            System.out.println(e.getMessage());
            addActionError(getText("error.noProfessor"));
            return "error";
        }
        
		return "success";
		
	}

	public void setSession(Map ses) {
		this.session = ses;	
	}
	
	public Map getSession() {
		return this.session;	
	}
	
}
