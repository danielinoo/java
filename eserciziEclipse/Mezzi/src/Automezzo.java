
abstract class Automezzo {
	
private Integer ruote;
private String carburante;

public abstract Double getMaxSpeed();

public Automezzo(Integer ruote, String carburante) {
	super();
	this.ruote = ruote;
	this.carburante = carburante;
}

public Automezzo() {
	super();
}

public Integer getRuote() {
	return ruote;
}

public void setRuote(Integer ruote) {
	this.ruote = ruote;
}

public String getCarburante() {
	return carburante;
}

public void setCarburante(String carburante) {
	this.carburante = carburante;
}

@Override
public String toString() {
	return "ruote=" + ruote + ", carburante=" + carburante ;
}
	



}


