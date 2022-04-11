package ar.edu.asap.practica0.modelo;

import java.util.Objects;

public class Jugador {
	
	private int codigo;
	private String nombre;
	private String nickName;
	private PiedraPapelTijeraFactory jugadaElegida;
	
	public Jugador() {
		super();
	}

	public Jugador(int codigo, String nombre, String nickName, PiedraPapelTijeraFactory jugadaElegida) {

		this.codigo = codigo;
		this.nombre = nombre;
		this.nickName = nickName;
		this.jugadaElegida = jugadaElegida;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	

	public PiedraPapelTijeraFactory getJugadaElegida() {
		return jugadaElegida;
	}

	public void setJugadaElegida(PiedraPapelTijeraFactory jugadaElegida) {
		this.jugadaElegida = jugadaElegida;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, jugadaElegida, nickName, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		return codigo == other.codigo && Objects.equals(jugadaElegida, other.jugadaElegida)
				&& Objects.equals(nickName, other.nickName) && Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Jugador [codigo=" + codigo + ", nombre=" + nombre + ", nickName=" + nickName + ", jugadaElegida="
				+ jugadaElegida + ", getCodigo()=" + getCodigo() + ", getNombre()=" + getNombre() + ", getNickName()="
				+ getNickName() + ", getJugadaElegida()=" + getJugadaElegida() + ", hashCode()=" + hashCode()
				+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
