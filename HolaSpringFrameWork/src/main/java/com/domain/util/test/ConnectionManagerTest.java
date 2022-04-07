package com.domain.util.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

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
			e.printStackTrace();
			assertTrue(false);
			
		}
	}
	
	@Test
	void testDesconectar() throws SQLException {
		ConnectionManager.desConectar();
		assertTrue(con.isClosed());
	}

}

