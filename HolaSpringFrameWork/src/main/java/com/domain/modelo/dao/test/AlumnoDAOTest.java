package com.domain.modelo.dao.test;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.domain.modelo.Alumno;
import com.domain.modelo.dao.AlumnoDAO;

class AlumnoDAOTest {
	AlumnoDAO aluDao;
	Alumno alumno;
	Alumno aluMod;

	@BeforeEach
	public void setUp() throws Exception {
		aluDao = new AlumnoDAO();
		alumno = new Alumno(0, "Natacha_Test","Gomez_Test", "remnatt4@mail_Test","Terciarios_Test", "git_Test");
	}

	@AfterEach
	public void tearDown() throws Exception {
		aluDao=null;
		alumno=null;
	}

	@Test
	public void testAgregar() {
		try {
			aluDao.agregar(alumno);
			assertTrue(true);
		}catch(ClassNotFoundException | SQLException e){
			assertTrue(false);
			e.printStackTrace();
			
		}
	}

}
