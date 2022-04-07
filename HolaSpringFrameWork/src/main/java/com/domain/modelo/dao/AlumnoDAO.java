package com.domain.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.domain.modelo.Alumno;
import com.domain.modelo.Model;
import com.domain.util.ConnectionManager;


public class AlumnoDAO implements DAO {
	 private Connection conexion;
	 public AlumnoDAO() throws ClassNotFoundException, SQLException{
		ConnectionManager.conectar();
		conexion= ConnectionManager.getConection(); 
	 }
	 
	@Override
	public void agregar(Model pModel) throws ClassNotFoundException, SQLException {
		
		
		StringBuilder sql = new StringBuilder("INSERT INTO alumnos (ALU_NOMBRE, ALU_APELLIDO, ALU_EMAIL,"	);
					sql		.append						("ALU_CONOCIMIENTOS, ALU_GIT)")
							.append						("values(?,?,?,?,?"						);
		
		
		Alumno alu = (Alumno)pModel;
		
		PreparedStatement stm = conexion.prepareStatement(sql.toString());
		stm.setString(1, alu.getNombre());
		stm.setString(2, alu.getApellido());
		stm.setString(3, alu.getEmail());
		stm.setString(4, alu.getEstudios());
		stm.setString(5, alu.getLinkArepositorio());
		
		stm.execute();
	}


	@Override
	public void modificar(Model pModel) {


	}

	@Override
	public void eliminar(Model pModel) {


	}

	@Override
	public List<Model> leer(Model pModel) {

		return null;
	}

}
