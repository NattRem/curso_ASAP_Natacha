package com.domain.util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import java.sql.Connection;
import java.sql.SQLException;


import com.domain.util.ConnectionManager;

class ConnectionManagerTest {
	Connection con;
	
	@BeforeEach
	void setUp() throws ClassNotFoundException, SQLException {
		ConnectionManager.conectar();
		con = ConnectionManager.getConection();
	}
	@AfterEach
	void tearDown() {
		con=null;
	}
	
	@Test
	void testConectarYGetConection() {
		try {
			ConnectionManager.conectar();
			assertNotNull(ConnectionManager.getConection());
			assertTrue(true);
		} catch (ClassNotFoundException | SQLException e) {
			assertTrue(false);
			e.printStackTrace();
					
		}
	}
	
	@Test
	void testDesconectar() throws SQLException {
		ConnectionManager.desConectar();
		assertTrue(con.isClosed());
	}

}


