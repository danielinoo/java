
public class Elefante extends Mammifero  implements Must, Req, Comparable<Elefante>{
	
	private Double peso;

	
	public Elefante(Integer freq_respiratoria, Integer req_cardio) {
		super(freq_respiratoria, req_cardio);
	}

	public Elefante(Integer freq_respiratoria, Integer req_cardio, Double peso) {
		super(freq_respiratoria, req_cardio);
		this.peso = peso;
	}
	
	

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	@Override
	public String GetClassName() {
		// TODO Auto-generated method stub
		return "Elefante";
	}

	@Override
	public String GetVersion() {
		// TODO Auto-generated method stub
		return "1.0";
	}

	@Override
	public String GetSerie() {
		// TODO Auto-generated method stub
		return "TJ89";
	}

	@Override
	public String Verso() {
		// TODO Auto-generated method stub
		return "barrito";
	}
	
	
	
	
	@Override
	public String toString() {
		return "\nElefante [peso=" + peso + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int compareTo(Elefante o) {
		// TODO Auto-generated method stub
		return peso.compareTo(o.peso);
	}
}
