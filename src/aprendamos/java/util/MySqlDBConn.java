package aprendamos.java.util;

// Esta clase nos retornara una conexion a base de datos

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDBConn {

	
	// evitamos que puedan instanciar esta clase
	private MySqlDBConn() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	// Registrar el driver de conexion a b.d. es una
	// tarea que solo debe implementarse una sola vez
	// No es necesario hacerlo cada que vez que recuperemos
	// un objeto conexion
	
	// Un bloque static solo se ejecuta la primera vez
	// que referencio a la clase
	
	static{
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	// creamos el metodo que nos permite obtener una conexion
	public static Connection obtenerConexion(){
		
		// 1. Para referenciar al pool creamos un contexto JNDI
		// Java Naming and Directory Interface
		Connection cn=null;

		
		try {
			cn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mydb", 
					"root", 
					"admin");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cn;
		
	}
	
	
	
	
}
