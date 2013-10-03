/**
 * 
 */
package net.excelsior.Authentication;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author gustavo
 *
 */
public class LoginAction extends ActionSupport {
	
	private final AuthDatabase data = new AuthDatabase(
			);
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	
	public void validate(){
		if("".equals(this.getUsername())){
			addActionError("El nombre de usuario no puede estar vacio");
		}
	}
	
	/**
	 * M�todo: authenticate
	 * Descripci�n: Obtiene al informaci�n de la base de datos para
	 * determinar si el usuario est� autenticado
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * 
	 */
	
	public String execute() throws InstantiationException, IllegalAccessException{
		// Verifico si ya el usuario se logueo antes
		Map<String, Object> session = ActionContext.getContext().getSession();
		String usuarioPrevio = (String)session.get("username");
		if (usuarioPrevio != null){
			this.setUsername(usuarioPrevio);
			if (this.data.isProfessor(this.username)){
				session.put("username",username);
				return "successProfessor";
			} else {
				return "successDpto";
			}
		}
		
		if (this.data.checkPassword(this.username,this.password)){
			// Por ahora solo coloco los dos casos relevantes en un futuro hay que poner mas
			if (this.data.isProfessor(this.username)){
				session.put("username",username);
				return "successProfessor";
			} else {
				return "successDpto";
			}
		}
		else{
			addActionError(getText("error.login"));
			return "error";
		}		
		
	}
	
	/**
	 * Obtiene el nombre de usuario de la instancia.
	 * Este m�todo siempre retorna.
	 * 
	 * @return	Nombre de usuario
	 */
	public String getUsername(){
		return this.username;
	}
	
	/**
	 * Obtiene la clave de la instancia.
	 * Este m�todo siempre retorna.
	 * 
	 * @return	Clave
	 */
	public String getPassword(){
		return this.password;
	}
	
	/**
	 * Setea el nombre de usuario de la instancia.
	 * Este m�todo siempre retorna.
	 * @param	usuario		Nombre de usuario
	 */
	public void setUsername(String user){
		this.username = user;
	}
	/**
	 * Setea la clave de la instancia.
	 * Este m�todo siempre retorna.
	 * @param Clave
	 */
	public void setPassword(String pass){
		this.password = pass;
	}
	
	/**
	 * Desloguea al usuario
	 * Este m�todo siempre retorna.
	 *
	 */
	
	public String logout(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("username");
		return("success");
	}
}
