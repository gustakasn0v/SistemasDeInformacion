/**
 * 
 */
package net.excelsior.Authentication;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.*;

import net.excelsior.Authentication.Database;

/**
 * @author gustavo
 *
 */
public class AuthDatabase extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private final Database db = new Database(
			getText("database.jdbcToken")+getText("database.dbname"),
			getText("database.login"),
			getText("database.password"));
	
	/**
	 * Determina si un usuario existe en la base de datos
	 * Este método siempre retorna.
	 * 
	 * @param	user	Nombre del usuario a buscar 
	 * @return			Booleano que indica si el usuario existe
	 *
	 */
	public boolean userExists(String user) {
		
		if (!this.db.initializeConnection()) return false;
		String sqlquery = "select * from usuario where nombre_usuario= '" + user + "';";
		ResultSet rs = this.db.executeCommand(sqlquery);
		
		try{
			this.db.closeConnection();
			return rs.next();
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Retorna la clave de un usuario. Requiere que el usuario exista-
	 * Si el usuario no existe retorna null
	 * 
	 * @param user Nombre del usuario a buscar 
	 * @return String que representa la clave del usuario
	 *  
	 */
	private String lookForPassword(String user){
		if (!userExists(user)) return null;
				
		if (!this.db.initializeConnection()) return null;
		String sqlquery = "select contrasenia from usuario where nombre_usuario = '" + user + "';";
		System.out.println(sqlquery);
		ResultSet rs = this.db.executeCommand(sqlquery);
		
		try{
			this.db.closeConnection();
			rs.next();
			return rs.getString("contrasenia");
		}
		catch(SQLException e){
			System.out.println("Error leyendo resultado del query");
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Determina si el usuario introdujo una clave válida
	 * Si el usuario no existe retorna false
	 * 
	 * @param	user		Nombre del usuario a buscar
	 * @param	password	Clave que el usuario introdujo
	 * @return 				String que representa la clave del usuario
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public  boolean checkPassword(String user,String password) throws InstantiationException, IllegalAccessException{
		if (!this.userExists(user)) return false;
		String hash = lookForPassword(user);
		return hash.equals(password);
	}
}
