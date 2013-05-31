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

public class ShowInfoAction extends ActionSupport implements SessionAware{

	private Map session;
	private static final long serialVersionUID = 1L;
	private List<String> titulos;
	private long cedula;
	private String professorUsername; //Tentativamente esto lo voy a usar como nombre del profesor
	private List<String> materialApoyo;
	private List<String> programas; 
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

	public List<String> getMaterialApoyo(){
		return titulos;
	}

	public void setProgramas(List<String> misTitulos){
		programas = misTitulos;
	}

	public List<String> getProgramasApoyo(){
		return programas;
	}	
	
	public void setMaterialApoyo(List<String> misMateriales){
		titulos = misMateriales;
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
		
		Map session = ActionContext.getContext().getSession();
		session.put("cedula",cedula);
		
		this.dBase.initializeConnection();
        
        String queryTitulos = "select formacion from formacion F, usuario U where " +
                       "U.cedula = " + cedula + " and F.nombre_usuario = U.nombre_usuario;";
        
        String queryMaterial = "select material from material_apoyo M, usuario U where " +
        		"U.cedula = " + cedula + " and M.nombre_usuario = U.nombre_usuario;";
        
        String queryPrograma = "select programa from programa P, usuario U where " +
        		"U.cedula = " + cedula + " and P.nombre_usuario = U.nombre_usuario;";
        
        ResultSet resultTitulos = dBase.executeCommand(queryTitulos);
        ResultSet resultProgramas = dBase.executeCommand(queryPrograma);
        ResultSet resultMaterial = dBase.executeCommand(queryMaterial);
        titulos = new ArrayList<String>();
        materialApoyo = new ArrayList<String>();
        programas = new ArrayList<String>();
        try{
        	while(resultTitulos.next()){
        		titulos.add(resultTitulos.getString("formacion"));
        	}
        	
        	while(resultMaterial.next()){
                materialApoyo.add(resultMaterial.getString("material"));
                System.out.println(resultMaterial.getString("material"));
            }	
        
        	while(resultProgramas.next()){
                programas.add(resultProgramas.getString("programa"));
                System.out.println("dfgdfg");
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
