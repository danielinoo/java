
public class Persona {
	
	private String nome;
	private int eta;
	public Persona(String nome, int eta) {
		super();
		this.nome = nome;
		this.eta =eta;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCognome() {
		return eta;
	}
	public void setCognome(int eta) {
		this.eta =eta;
	}
	
	@Override
	public String toString() {
		return "Persona [nome=" + nome + ",eta =" +eta + "]";
	}
	
	
	

	
}