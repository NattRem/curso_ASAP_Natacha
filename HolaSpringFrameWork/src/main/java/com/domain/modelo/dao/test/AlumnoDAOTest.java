package com.domain.modelo.dao.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.servlet.jsp.tagext.TryCatchFinally;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.domain.modelo.Alumno;
import com.domain.modelo.dao.AlumnoDAO;
import com.domain.util.ConnectionManager;

public class AlumnoDAOTest {
	AlumnoDAO aluDao;
	Alumno alumno;
	
	@Before
	public void setUp() throws Exception {
		aluDao = new AlumnoDAO();
		alumno = new Alumno(0, "Gabriel test", "Casas test", "email@gmail.test", "universitarios.test", "http://gitlab/gmsdfdhj.git");
	}

	@After
	public void tearDown() throws Exception {
		aluDao=null;
		alumno=null;
		
	}

	@Test
	public void test() {
		try {
			aluDao.agregar(alumno);
			assertTrue(true);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			assertTrue(false);
		}

	}

}
