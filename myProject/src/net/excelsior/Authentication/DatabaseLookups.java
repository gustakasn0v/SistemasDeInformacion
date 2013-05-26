/**
 * 
 */
package net.excelsior.Authentication;
import java.sql.*;

import net.excelsior.Authentication.Database;

/**
 * @author gustavo
 *
 */
public class DatabaseLookups {
	
	
	/**
	 * Determina si un usuario existe en la base de datos
	 * Este método siempre retorna.
	 * 
	 * @param	user	Nombre del usuario a buscar 
	 * @return			Booleano que indica si el usuario existe
	 *
	 */
	public static boolean userExists(String user) {
		Database db = new Database(
				"jdbc:postgresql://192.168.1.3/sistemas",
				"sys",
				"123");
		
		if (!db.initializeConnection()) return false;
		String sqlquery = "select * from users where username = '" + user + "';";
		ResultSet rs = db.executeCommand(sqlquery);
		
		try{
			db.closeConnection();
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
	private static String lookForPassword(String user){
		if (!userExists(user)) return null;
		Database db = new Database(
				"jdbc:postgresql://192.168.1.3/sistemas",
				"sys",
				"123");
		
		if (!db.initializeConnection()) return null;
		String sqlquery = "select password from users where username = '" + user + "';";
		ResultSet rs = db.executeCommand(sqlquery);
		
		try{
			db.closeConnection();
			rs.next();
			return rs.getString("password");
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
	
	public static boolean checkPassword(String user,String password) throws InstantiationException, IllegalAccessException{
		if (!userExists(user)) return false;
		String hash = lookForPassword(user);
		return hash.equals(password);
	}
}
