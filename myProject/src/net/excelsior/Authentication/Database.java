package net.excelsior.Authentication;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
	
	private	String url;
	private String user;
	private String pass;
	private Connection connectionToken;
	
	public Database(String url, String user, String pass){
		this.url = url;
				
		this.user = user;
		this.pass = pass;
	}
	
	/**
	 * M�todo que inicia la conexi�n a la base de datos
	 * 
	 * @return Token de conexi�n a la base de datos
	 */
	public boolean initializeConnection() {
		try{
			Class.forName("org.postgresql.Driver");
		}
		catch(ClassNotFoundException e){
			System.out.println("Error registrando la clase");
			e.printStackTrace();
			return false;
		}
		try{
			this.connectionToken = DriverManager.getConnection(url,user,pass);
			return true;
		}
		catch(SQLException e){
			System.out.println("Error iniciando la conexi�n");
			e.printStackTrace();
			return false;
		}
	}
	
	public ResultSet executeCommand(String command){
		try{
			Statement state= this.connectionToken.createStatement();
			return state.executeQuery(command);
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
			return null;
		}
	}
	
    /**
     * Ejecuta un insert en la base de datos
     * @param command 
     */
    
    public void executeInsert(String command){
        try{
            Statement state= this.connectionToken.createStatement();
            state.executeUpdate(command);
            
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Ingresa un nuevo usuario a la base de datos
     * @param command 
     * @return  True si se ingreso el usuario, False si el usuario ya existe
     */
    
    public boolean executeInsertNewUser(String command){
    	
    	
		if (this.userExists(command)) return false;
		
        try{
            Statement state= this.connectionToken.createStatement();
            state.executeUpdate(command);
            return true;
            
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
	
	
	/**
	 * M�todo que cierra la conexi�n a la base de datos
	 * 
	 */
	public void closeConnection(){
		try {
			this.connectionToken.close();
		} catch (SQLException e) {
			System.out.println("Error cerrando la conexi�n");
			e.printStackTrace();
		}
	}
}

