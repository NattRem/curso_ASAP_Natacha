package com.domain.modelo.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.domain.modelo.Alumno;
import com.domain.modelo.dao.AlumnoDAO;

class AlumnoDAOTest1 {
	AlumnoDAO aluDao;
	Alumno alumno;

	@BeforeEach
	void setUp() throws Exception {
		aluDao = new AlumnoDAO();
		alumno = new Alumno(0, "Natacha test", "Gomez test", "email@gmail.test", "tercearios test", "linkgit test");
	}

	@AfterEach
	void tearDown() throws Exception {
		aluDao = null;
		alumno = null;
	}

	@Test
	void testAgregar() {
		try {
			aluDao.agregar(alumno);
			assertTrue(true);
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
			assertTrue(false);
		}
	}

}
