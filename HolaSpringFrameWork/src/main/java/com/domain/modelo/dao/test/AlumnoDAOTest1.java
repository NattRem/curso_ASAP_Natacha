package com.domain.modelo.dao.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.domain.modelo.Alumno;
import com.domain.modelo.dao.AlumnoDAO;
import com.domain.util.ConnectionManager;

class AlumnoDAOTest1 {
	AlumnoDAO aluDao;
	
	Alumno alumnoAgregar;
	Alumno alumnoEliminar;
	Alumno alumnoModificar;
	Alumno alumnoLeerCod;
	Alumno alumnoLeerNom;
	
	
	Connection con;
	Statement stm;
	ResultSet rs;

	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		ConnectionManager.conectar();
		Connection con = ConnectionManager.getConection();
		
	    Statement consulta= con.createStatement();
	
	    String sql = "";
	    BufferedReader bf = new BufferedReader( new InputStreamReader( AlumnoDAO.class.getResource( "AlumnosCrear.sql" ).openStream() ) );
	    while ( (sql = bf.readLine()) != null ) {
	       if ( sql.trim().length() != 0 &&
	            !sql.startsWith( "--" ) ) {              
	          consulta.executeUpdate( sql );
	       }
	    }
	    ConnectionManager.desConectar();
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {


		ConnectionManager.conectar();
		Connection con = ConnectionManager.getConection();
		
	    Statement consulta= con.createStatement();
	
	    String sql = "";
	    BufferedReader bf = new BufferedReader( new InputStreamReader( AlumnoDAOTest1.class.getResource( "AlumnosEliminar.sql" ).openStream() ) );
	    while ( (sql = bf.readLine()) != null ) {
	       if ( sql.trim().length() != 0 &&
	            !sql.startsWith( "--" ) ) {              
	          consulta.executeUpdate( sql );
	       }
	    }
	    ConnectionManager.desConectar();
	}

	
	@BeforeEach
	void setUp() throws Exception {
		aluDao = new AlumnoDAO();
		
		alumnoAgregar = new Alumno(0, "Natacha_test", "Gomez_test", "email@gmail.test", "tercearios_test", "linkgit_test");
		ConnectionManager.conectar();
		con = ConnectionManager.getConection();
		stm =con.createStatement();
		StringBuilder sql =new StringBuilder("select ALU_NOMBRE , ALU_APELLIDO , ALU_EMAIL, ALU_CONOCIMIENTOS , ALU_GIT");
						sql.append("From alumnos");
						sql.append("Where ALU_NOMBRE=Marina_test");
		rs = stm.executeQuery(sql.toString());
		rs.next();
		if(rs.next())
			alumnoModificar = new Alumno(rs.getInt("ALU_ID"),
									rs.getString("ALU_NOMBRE"),
									rs.getInt("ALU_APELLIDO"),
									rs.getString("ALU_EMAIL"),
									rs.getInt("ALU_CONOCIMIENTOSO"),
									rs.getInt("ALU_GIT"));
		
		sql = new StringBuilder("Select ALU_ID FROM ALUMNOS WHERE ALU_NOMBRE= 'Monsef_test'");
		
		rs = stm.executeQuery(sql.toString());
		if(rs.next())
			alumnoEliminar = new Alumno(rs.getInt("ALU_ID"));
		
		
		//leer x codigo
		
		sql =new StringBuilder("select ALU_NOMBRE , ALU_APELLIDO , ALU_EMAIL, ALU_CONOCIMIENTOS , ALU_GIT");
		sql.append("From alumnos");
		sql.append("Where ALU_NOMBRE=Marina_test");
		
		rs = stm.executeQuery(sql.toString());
		if(rs.next());
		
		alumnoLeerCod = new Alumno(rs.getInt("ALU_ID"),
								rs.getString("ALU_NOMBRE"),
								rs.getInt("ALU_APELLIDO"),
								rs.getString("ALU_EMAIL"),
								rs.getInt("ALU_CONOCIMIENTOSO"),
								rs.getInt("ALU_GIT"));
		
	}

	@AfterEach
	void tearDown() throws Exception {
		aluDao 			= null;
		
		alumnoAgregar 	= null;
		alumnoEliminar	= null;
		alumnoModificar	= null;
		alumnoLeerCod	= null;
		alumnoLeerNom	= null;
		
		con 			= null;
		stm 			= null;
		rs 				= null;
		
	}
	
	@Test
	void testLeerTodosLosAlumnos() {
		System.out.println("alumnoAgregar" + alumnoAgregar);
		System.out.println("alumnoEliminar" + alumnoEliminar);
		System.out.println("alumnoModificar" + alumnoModificar);
		System.out.println("alumnoLeerCod" + alumnoLeerCod);
		System.out.println("alumnoLeerNom" + alumnoLeerNom);
		
		assertNotNull(alumnoAgregar);
		assertNotNull(alumnoEliminar);
		assertNotNull(alumnoModificar);
		assertNotNull(alumnoLeerCod);
		assertNotNull(alumnoLeerNom);
		
	}

	@Test
	void testAgregar() {
		try {
			aluDao.agregar(alumnoAgregar);
			Alumno aluLeido = null;
			
			StringBuilder sql =new StringBuilder("select ALU_NOMBRE , ALU_APELLIDO , ALU_EMAIL, ALU_CONOCIMIENTOS , ALU_GIT");
			sql.append("From alumnos");
			sql.append("Where ALU_NOMBRE=Marina_test");
			
			rs = stm.executeQuery(sql.toString());
			rs.next();
			if(rs.next())
			 aluLeido = new Alumno(rs.getInt("ALU_ID"),
						rs.getString("ALU_NOMBRE"),
						rs.getInt("ALU_APELLIDO"),
						rs.getString("ALU_EMAIL"),
						rs.getInt("ALU_CONOCIMIENTOSO"),
						rs.getInt("ALU_GIT"));
			
			assertEquals(alumnoAgregar.getNombre(), 		  aluLeido.getNombre());
			assertEquals(alumnoAgregar.getApellido(), 		  aluLeido.getApellido());
			assertEquals(alumnoAgregar.getEmail(), 			  aluLeido.getEmail());
			assertEquals(alumnoAgregar.getEstudios(), 		  aluLeido.getEstudios());
			assertEquals(alumnoAgregar.getLinkArepositorio(), aluLeido.getLinkArepositorio());
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
			assertTrue(false);
		}
	}
	
	@Test
	void testModificar() {
		try {
			alumnoModificar.setNombre("MarinaModi_test");
			alumnoModificar.setApellido("Calvo PereaModif_test");
			alumnoModificar.setEmail("email@gmailModif_test");
			alumnoModificar.setEstudios("Grado enFisicaModif_test");
			alumnoModificar.setLinkArepositorio("https://gitlab.com/marinacalvo/cursojava2021.gitModif_test");
			aluDao.modificar(alumnoModificar);
			Alumno aluLeido = null;
			
			StringBuilder sql =new StringBuilder("select ALU_NOMBRE , ALU_APELLIDO , ALU_EMAIL, ALU_CONOCIMIENTOS , ALU_GIT");
			sql.append("From alumnos");
			sql.append("Where ALU_NOMBRE=MarinaModi_test");
			
			rs = stm.executeQuery(sql.toString());
			rs.next();
			if(rs.next())
			 aluLeido = new Alumno(rs.getInt("ALU_ID"),
						rs.getString("ALU_NOMBRE"),
						rs.getInt("ALU_APELLIDO"),
						rs.getString("ALU_EMAIL"),
						rs.getInt("ALU_CONOCIMIENTOSO"),
						rs.getInt("ALU_GIT"));
			
			assertEquals(alumnoModificar.getNombre(), 		  	aluLeido.getNombre());
			assertEquals(alumnoModificar.getApellido(), 		aluLeido.getApellido());
			assertEquals(alumnoModificar.getEmail(), 			aluLeido.getEmail());
			assertEquals(alumnoModificar.getEstudios(), 		aluLeido.getEstudios());
			assertEquals(alumnoModificar.getLinkArepositorio(), aluLeido.getLinkArepositorio());
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
			assertTrue(false);
		}
	}

}
