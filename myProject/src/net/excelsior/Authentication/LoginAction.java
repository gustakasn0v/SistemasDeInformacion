/**
 * 
 */
package net.excelsior.Authentication;

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
	 * Método: authinticate
	 * Descripción: Obtiene al información de la base de datos para
	 * determinar si el usuario está autenticado
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * 
	 */
	
	public String authenticate() throws InstantiationException, IllegalAccessException{
		if (this.data.checkPassword(this.username,this.password)){
			return "success";
		}
		else{
			addActionError(getText("error.login"));
			return "error";
		}		
		
	}
	
	/**
	 * Obtiene el nombre de usuario de la instancia.
	 * Este método siempre retorna.
	 * 
	 * @return	Nombre de usuario
	 */
	public String getUsername(){
		return this.username;
	}
	
	/**
	 * Obtiene la clave de la instancia.
	 * Este método siempre retorna.
	 * 
	 * @return	Clave
	 */
	public String getPassword(){
		return this.password;
	}
	
	/**
	 * Setea el nombre de usuario de la instancia.
	 * Este método siempre retorna.
	 * @param	usuario		Nombre de usuario
	 */
	public void setUsername(String user){
		this.username = user;
	}
	/**
	 * Setea la clave de la instancia.
	 * Este método siempre retorna.
	 * @param Clave
	 */
	public void setPassword(String pass){
		this.password = pass;
	}
}
