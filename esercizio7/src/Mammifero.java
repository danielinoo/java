//abstract --> classe astratta
// abstract String verso --> quando c ho un dato astratto devo perforza usarlo nelle classi figlie
public abstract class Mammifero {
	
	private Integer freq_respiratoria;
	private Integer req_cardio;
	public abstract String Verso();
	
	public Mammifero(Integer freq_respiratoria, Integer req_cardio) {
		super();
		this.freq_respiratoria = freq_respiratoria;
		this.req_cardio = req_cardio;
	}

	public Mammifero() {
		super();
	}
	
	

	public Integer getFreq_respiratoria() {
		return freq_respiratoria;
	}

	public void setFreq_respiratoria(Integer freq_respiratoria) {
		this.freq_respiratoria = freq_respiratoria;
	}

	public Integer getReq_cardio() {
		return req_cardio;
	}

	public void setReq_cardio(Integer req_cardio) {
		this.req_cardio = req_cardio;
	}

	
	
	@Override
	public String toString() {
		return "Mammifero [freq_respiratoria=" + freq_respiratoria + ", req_cardio=" + req_cardio + "]";
	}
	
	
	
	

}
