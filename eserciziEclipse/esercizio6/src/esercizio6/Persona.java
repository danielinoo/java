package esercizio6;

public class Persona {

	private String nome;
	private int eta;
	
	
	public Persona () {
		super();
	}
	public Persona(String nome, int eta) {
		super();
		this.nome = nome;
		this.eta = eta;
	}
	@Override
	public String toString() {
		return "Persona [nome=" + nome + ", eta=" + eta + "]";
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getEta() {
		return eta;
	}
	public void setEta(int eta) {
		this.eta = eta;
	}
	
	
	

	
}
