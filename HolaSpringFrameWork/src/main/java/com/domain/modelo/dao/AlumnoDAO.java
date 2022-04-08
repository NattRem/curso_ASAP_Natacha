package com.domain.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.domain.modelo.Alumno;
import com.domain.modelo.Model;
import com.domain.util.ConnectionManager;


public class AlumnoDAO implements DAO {
	 private Connection conexion;
	 public AlumnoDAO() throws ClassNotFoundException, SQLException{};
	 
	@Override
	public void agregar(Model pModel) throws ClassNotFoundException, SQLException {
		ConnectionManager.conectar();
		conexion= ConnectionManager.getConection(); 
		
		
		StringBuilder sql = new StringBuilder("INSERT INTO alumnos (ALU_NOMBRE, ALU_APELLIDO, ALU_EMAIL,	");
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
		
		ConnectionManager.desConectar();
	}


	@Override
	public void modificar(Model pModel) throws ClassNotFoundException, SQLException {
		ConnectionManager.conectar();
		conexion= ConnectionManager.getConection(); 
		
		
		StringBuilder sql = new StringBuilder("update alumnos set alumnos ALU_NOMBRE	=?  ");
					  sql		.append			(", ALU_APELLIDO						=?	")
					  			.append			(", ALU_EMAIL							=?	")
					  			.append			(", ALU_CONOCIMIENTOS					=?	")
					  			.append			(", ALU_GIT								=?	")
					  			.append			("  WHERE ALU_ID 						=?	");

		
		
		Alumno alu = (Alumno)pModel;
		
		PreparedStatement stm = conexion.prepareStatement(sql.toString());
		stm.setString(1, alu.getNombre());
		stm.setString(2, alu.getApellido());
		stm.setString(3, alu.getEmail());
		stm.setString(4, alu.getEstudios());
		stm.setString(5, alu.getLinkArepositorio());
		stm.setInt(6, alu.getCodigo());
		
		stm.execute();
		
		ConnectionManager.desConectar();

	}

	@Override
	public void eliminar(Model pModel) throws ClassNotFoundException, SQLException {
		ConnectionManager.conectar();
		conexion= ConnectionManager.getConection(); 
		
		
		StringBuilder sql = new StringBuilder("delete from alumnos "	);
					  sql		.append			("  WHERE ALU_ID 	=?	");
		
		
		Alumno alu = (Alumno)pModel;
		
		PreparedStatement stm = conexion.prepareStatement(sql.toString());
		stm.setInt(1, alu.getCodigo());
		
		stm.execute();
		
		ConnectionManager.desConectar();

	}

	@Override
	public List<Model> leer(Model pModel) throws ClassNotFoundException, SQLException {

		ConnectionManager.conectar();
		conexion= ConnectionManager.getConection(); 
		
		
		StringBuilder sql = new StringBuilder("select   ALU_NOMBRE, ALU_APELLIDO, ALU_EMAIL,	");
					sql		.append						("ALU_CONOCIMIENTOS, ALU_GIT			")
							.append						("FROM ALUMNOS							)");
							
		
		
		Alumno alu = (Alumno)pModel;
		PreparedStatement stm = null;
		
		if(alu!=null && !alu.isEmpty()) {
			if(alu.getCodigo() > 0) {
				sql.append("where alu_id=?");
				stm = conexion.prepareStatement(sql.toString());
				stm.setInt(1, alu.getCodigo());
			}
			else if (alu.getNombre()!=null && !alu.getNombre().isEmpty()){
			sql.append("where alu_nombre =?");
			stm = conexion.prepareStatement(sql.toString());
			stm.setString(1, alu.getNombre());
			}
		}else {
			stm = conexion.prepareStatement(sql.toString());
		}
		ResultSet rs = stm.executeQuery();
		while(rs.next()) {
			List<Model> alumnos = new ArrayList<Model>();
			alumnos .add(new Alumno(rs.getInt("ALU_ID"),
					rs.getString("ALU_NOMBRE"),
					rs.getInt("ALU_APELLIDO"),
					rs.getString("ALU_EMAIL"),
					rs.getInt("ALU_CONOCIMIENTOSO"),
					rs.getInt("ALU_GIT")));
		}
		
		
		ConnectionManager.desConectar();
		return null;
	}

}
