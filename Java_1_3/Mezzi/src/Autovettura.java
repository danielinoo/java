
public class Autovettura extends Automezzo implements Comparable<Autovettura>{
	
	private Integer cilindrata;
	private Double consumo;
	public Autovettura(Integer ruote, String carburante, Integer cilindrata, Double consumo) {
		super(ruote, carburante);
		this.cilindrata = cilindrata;
		this.consumo = consumo;
	}
	public Autovettura(Integer ruote, String carburante) {
		super(ruote, carburante);
	}
	@Override
	public Double getMaxSpeed() {
		// TODO Auto-generated method stub
		return (double) 200;
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
	public String toString() {
		return "Autovettura [cilindrata=" + cilindrata + ", consumo=" + consumo + ", velocita=" + getMaxSpeed()
				+ "," + super.toString() + "]";
	}
	@Override
	public int compareTo(Autovettura o) {
		// TODO Auto-generated method stub
		return consumo.compareTo(o.getConsumo());
	}
	
	
	

}
