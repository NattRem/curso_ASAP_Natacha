package ar.edu.asap.practica0.modelo;

public class Tijera extends PiedraPapelTijeraFactory {

	public Tijera() {
		this("tijera", PiedraPapelTijeraFactory.TIJERA);
	}
	
	public Tijera(String nombre, int numero) {
		super(nombre, numero);

	}

	@Override
	public boolean isMe(int pNUm) {
		return pNUm==PiedraPapelTijeraFactory.TIJERA;
	}

	@Override
	public int comparar(PiedraPapelTijeraFactory pPPTFact) {
		int result=0;
		
		switch (pPPTFact.getNumero()) {
		case PiedraPapelTijeraFactory.PAPEL:
			result=1;
			this.descriptionResultado = nombre + " le gana a " + pPPTFact.getNombre();
			break;
			
		case PiedraPapelTijeraFactory.LAGARTIJA:
			result=1;
			this.descriptionResultado = nombre + " le gana a " + pPPTFact.getNombre();
			break;
			
		case PiedraPapelTijeraFactory.PIEDRA:
			result= -1;
			this.descriptionResultado = nombre + " pierde con " + pPPTFact.getNombre();
			break;
			
		case PiedraPapelTijeraFactory.SPOCK:
			result= -1;
			this.descriptionResultado = nombre + " pierde con " + pPPTFact.getNombre();
			break;
			
		default:
			this.descriptionResultado = nombre + " empata con " + pPPTFact.getNombre();
			break;
		}
		return result;
	}

}
