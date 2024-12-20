import java.util.Comparator;

public class Motociclo extends Automezzo implements Comparable<Motociclo>{
	
	private Integer cilindrata;
	private Double consumo;
	
	public Motociclo(Integer ruote, String carburante, Integer cilindrata, Double consumo) {
		super(ruote, carburante);
		this.cilindrata = cilindrata;
		this.consumo = consumo;
	}
	public Motociclo(Integer ruote, String carburante) {
		super(ruote, carburante);
	}
	
	public Integer getCilindrata() {
		return cilindrata;
	}
	public void setCilindrata(Integer cilindrata) {
		this.cilindrata = cilindrata;
	}
	public Double getConsumo() {
		return consumo;
	}
	public void setConsumo(Double consumo) {
		this.consumo = consumo;
	}
	
	@Override
	public Double getMaxSpeed() {
		// TODO Auto-generated method stub
		return (double) 200;
	}
	@Override
	public String toString() {
		return "Motociclo [cilindrata=" + cilindrata + ", consumo=" + consumo + ", velocita =" + getMaxSpeed()
				+ "," + super.toString() + "]";
	}
	@Override
	public int compareTo(Motociclo o) {
		// TODO Auto-generated method stub
		return consumo.compareTo(o.getConsumo());
	}

	
	
	

	

}
