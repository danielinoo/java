//implements --> implementa le interfaccie 
// comparable --> serve per generare compareTo


public class Ghepardo extends Mammifero implements Must, Req, Comparable<Ghepardo>{

	
	//aggiunta del metodo astratto
	@Override
	public String Verso() {
		// TODO Auto-generated method stub
		return "Roarrr";
	}
	
	private Double speed;


	public Double getSpeed() {
		return speed;
	}


	public void setSpeed(Double speed) {
		this.speed = speed;
	}


	public Ghepardo() {
		super();
	}


	public Ghepardo(Integer freq_respiratoria, Integer req_cardio, Double speed) {
		super(freq_respiratoria, req_cardio);
		this.speed = speed;
	}

	

	@Override
	public String toString() {
		return "\nGhepardo [speed=" + speed + ", toString()=" + super.toString() + "]";
	}


	@Override
	public String GetClassName() {
		// TODO Auto-generated method stub
		return "Ghepardo";
	}


	@Override
	public String GetVersion() {
		// TODO Auto-generated method stub
		return "1.0";
	}


	@Override
	public String GetSerie() {
		// TODO Auto-generated method stub
		return "AI48";
	}


	
	//confronta il ghepardo corrente co quello che je passi pe parametro
	@Override
	public int compareTo(Ghepardo o) {
		
		Integer ret =  speed.compareTo(o.speed);
		
		if (ret != 0) {
			return ret;
		}
		else {
			return getReq_cardio().compareTo(o.getReq_cardio());
			
		}
	}
	
	
	
	

}
