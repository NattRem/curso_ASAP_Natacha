package ar.edu.asap.practica0.modelo;

import java.util.Date;

public class Autoria {
	private Date fecha;
	private int cantidadJugadas;
	
	
	public Autoria() {
		super();
	}


	public Autoria(Date fecha, int cantidadJugadas) {
		this.fecha = fecha;
		this.cantidadJugadas = cantidadJugadas;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public int getCantidadJugadas() {
		return cantidadJugadas;
	}


	public void setCantidadJugadas(int cantidadJugadas) {
		this.cantidadJugadas = cantidadJugadas;
	}
	
	public void contarDespuesDeLaJugada() {
		cantidadJugadas++;
	}
	
}
