
public class Aereo {
	private String nome;
	private Integer posti_disponibili;
	private Integer posti_occupati = 0;

	

	public Aereo(String nome, Integer posti_disponibili) {
		super();
		this.nome = nome;
		this.posti_disponibili = posti_disponibili;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getPosti_disponibili() {
		return posti_disponibili;
	}

	public void setPosti_disponibili(Integer posti_disponibili) {
		this.posti_disponibili = posti_disponibili;
	}

	public Integer getPosti_occupati() {
		return posti_occupati;
	}

	public void setPosti_occupati(Integer posti_occupati) {
		this.posti_occupati = posti_occupati;
	}

	@Override
	public String toString() {
		return "Aereo [nome=" + nome + ", posti_disponibili=" + posti_disponibili + ", posti_occupati=" + posti_occupati
				+ "]";
	}
	

}
