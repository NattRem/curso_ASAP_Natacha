package ar.edu.asap.practica0.modelo;

import java.util.Date;
import java.util.Objects;

public class Jugada {

	private int codigo;
	private Date fechaHora;
	private Jugador jug1;
	private Jugador jug2;
	
	public Jugada() {}

	public Jugada(int codigo, Date fechaHora, Jugador jug1, Jugador jug2) {
		super();
		this.codigo = codigo;
		this.fechaHora = fechaHora;
		this.jug1 = jug1;
		this.jug2 = jug2;
	}


	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Jugador getJug1() {
		return jug1;
	}

	public void setJug1(Jugador jug1) {
		this.jug1 = jug1;
	}

	public Jugador getJug2() {
		return jug2;
	}

	public void setJug2(Jugador jug2) {
		this.jug2 = jug2;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, fechaHora);
	}
	
	public String getDescripcionDelresultado() {
		jug1.getJugadaElegida().comparar(jug2.getJugadaElegida());		
		return jug1.getJugadaElegida().getDescriptionResultado();
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugada other = (Jugada) obj;
		return codigo == other.codigo && Objects.equals(fechaHora, other.fechaHora);
	}
	



	@Override
	public String toString() {
		return "Jugada [codigo=" + codigo + ", fechaHora=" + fechaHora + ", jug1=" + jug1 + ", jug2=" + jug2
				+ ", getCodigo()=" + getCodigo() + ", getFechaHora()=" + getFechaHora() + ", getJug1()=" + getJug1()
				+ ", getJug2()=" + getJug2() + ", hashCode()=" + hashCode() + ", getDescripcionDelResultado()="
				+ getDescripcionDelresultado() + ", getClass()=" + getClass() + ", toString()=" + super.toString()
				+ "]";
	}

	


}
