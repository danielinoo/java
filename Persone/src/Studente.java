
public class Studente extends Persona{
	
	private int annoIscrizione;
	private String corso;
	public Studente(String nome, int eta, String corso ,int annoIscrizione) {
		super(nome, eta);
		this.annoIscrizione = annoIscrizione;
		this.corso = corso;
	}
	public int getAnnoIscrizione() {
		return annoIscrizione;
	}
	public void setAnnoIscrizione(int annoIscrizione) {
		this.annoIscrizione = annoIscrizione;
	}
	public String getCorso() {
		return corso;
	}
	public void setCorso(String corso) {
		this.corso = corso;
	}
	
	@Override
	public String toString() {
		return "Studente ["+ super.toString() +" annoIscrizione=" + annoIscrizione + ", corso=" + corso + "]";
	}

	
	
	
	
	
	
}
