package esercizio6;

public class Studente extends Persona{
	private String corso;
	private int annoDiFrequenza;
	
	public Studente(String corso, int annoDiFrequenza) {
		super();
		this.corso = corso;
		this.annoDiFrequenza = annoDiFrequenza;
	}

	public Studente(String nome, int eta, String corso, int annoDiFrequenza) {
		super(nome, eta);
		this.corso = corso;
		this.annoDiFrequenza = annoDiFrequenza;
	}


}
