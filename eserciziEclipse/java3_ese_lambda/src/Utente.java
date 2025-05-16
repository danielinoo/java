import java.util.ArrayList;
import java.util.List;

public class Utente {

	String nome;
	String cognome;
	int eta;
	String citta;
	String test;
	
	

	public Utente(String nome, String cognome, int eta, String citta, String test) {
		// TODO Auto-generated constructor stub
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
	
	private List<Utente> elencoUtenti() {
		List<Utente> utenti = new ArrayList<Utente>();

		utenti.add(new Utente("Paolo", "Rossi", 39, "Roma", "test"));
		utenti.add(new Utente("Mario", "Rossi", 40, "Roma", "test"));
		utenti.add(new Utente("Antonio", "Di Girolamo", 23, "Roma", "test"));
		utenti.add(new Utente("Caterina", "Montefalco", 55, "Roma", "test"));
		utenti.add(new Utente("Valeria", "Natelli", 45, "Roma", "test"));
		utenti.add(new Utente("Giovanna", "D'Antonelli", 50, "Roma", "test"));
		utenti.add(new Utente("Paolo", "Pisani", 21, "Catanzaro", "test"));
		utenti.add(new Utente("Laura", "Gambaro", 19, "Roma", "test"));
		utenti.add(new Utente("Benedetto", "Satini", 38, "Roma", "test"));
		return utenti;
	}

}
