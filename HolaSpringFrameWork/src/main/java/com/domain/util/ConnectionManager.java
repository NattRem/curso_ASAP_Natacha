package com.domain.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static Connection conection;
	
		
	public static void conectar() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/asap", "root", "Rocamadour2020");
	}
	public static void desConectar() throws SQLException {
		conection.close();
		
	}

	public static Connection getConection() {
		return conection;
	}

	
}
