package ar.edu.asap.practica0.modelo;

public class Papel extends PiedraPapelTijeraFactory {

	public Papel() {
		this("papel", PiedraPapelTijeraFactory.PAPEL);
	}
	
	
	public Papel(String nombre, int numero) {
		super(nombre, numero);

	}

	@Override
	public boolean isMe(int pNUm) {

		return pNUm==PiedraPapelTijeraFactory.PAPEL;
	}

	@Override
	public int comparar(PiedraPapelTijeraFactory pPPTFact) {

			int result=0;
			
			switch (pPPTFact.getNumero()) {
			case PiedraPapelTijeraFactory.PIEDRA:
				result=1;
				this.descriptionResultado = nombre + " le gana a " + pPPTFact.getNombre();
				break;
				
			case PiedraPapelTijeraFactory.SPOCK:
				result=1;
				this.descriptionResultado = nombre + " le gana a " + pPPTFact.getNombre();
				break;
				
			case PiedraPapelTijeraFactory.TIJERA:
				result= -1;
				this.descriptionResultado = nombre + " pierde con " + pPPTFact.getNombre();
				break;
				
			case PiedraPapelTijeraFactory.LAGARTIJA:
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

