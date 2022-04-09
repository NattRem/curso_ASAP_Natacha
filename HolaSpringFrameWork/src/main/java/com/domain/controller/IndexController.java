package com.domain.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.domain.modelo.dao.AlumnoDAO;

import ar.edu.asap.practica0.modelo.Lagartija;
import ar.edu.asap.practica0.modelo.Papel;
import ar.edu.asap.practica0.modelo.Piedra;
import ar.edu.asap.practica0.modelo.PiedraPapelTijeraFactory;
import ar.edu.asap.practica0.modelo.Spock;
import ar.edu.asap.practica0.modelo.Tijera;





@Controller
public class IndexController {

	@RequestMapping("/home")
	public String goIndex (){
		return "Index";

	}
	
	@RequestMapping("/")
	public String goPresentacion() {
		return "Presentacion";
	}
	
	@RequestMapping("/listado")
	public String goListado(Model model) {
		
		AlumnoDAO aluDao;
		try {
			aluDao = new AlumnoDAO();
			List<com.domain.modelo.Model> alumnos = aluDao.leer(null); 
			
			model.addAttribute("titulo", "Listado de alumnos");
			model.addAttribute("profesor", "Gabriel Casas");
			model.addAttribute("alumnos", alumnos);

		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		return "Listado";
	}
	
	@RequestMapping("/juego")
	public String goJuegos(Model model) {
		
		List<PiedraPapelTijeraFactory> opcion = new ArrayList<PiedraPapelTijeraFactory>();
		opcion.add(new Piedra());
		opcion.add(new Papel());
		opcion.add(new Tijera());
		opcion.add(new Spock());
		opcion.add(new Lagartija());
		
		model.addAttribute("opciones", opcion);
				
		
		return "PiedraPapelTijera";
	}
	

	
	@RequestMapping("/resolverJuego")
	public String goResultado(@RequestParam(required = false) Integer selOpcion, Model model ) {
		
		PiedraPapelTijeraFactory jugador = PiedraPapelTijeraFactory.getInstance(selOpcion);
		PiedraPapelTijeraFactory computadora = PiedraPapelTijeraFactory.getInstance((int)(Math.random()*5+1));
		int result = jugador.comparar(computadora);
		
		model.addAttribute("numero", selOpcion);
		model.addAttribute("jugador", jugador);
		model.addAttribute("computadora", computadora);
		model.addAttribute("resultado", jugador.getDescriptionResultado());
		
	   return "Resultado";
	}


	
	
	

}
