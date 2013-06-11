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
	
	/**
	 * M�todo: authenticate
	 * Descripci�n: Obtiene al informaci�n de la base de datos para
	 * determinar si el usuario est� autenticado
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * 
	 */
	
	public String authenticate() throws InstantiationException, IllegalAccessException{
		System.out.println("Merwno");
		Map session = ActionContext.getContext().getSession();
		session.put("username",username);
		
		if (this.data.checkPassword(this.username,this.password)){
			// Por ahora solo coloco los dos casos relevantes en un futuro hay que poner mas
			if (this.data.isProfessor(this.username)){
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
}
