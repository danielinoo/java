import java.time.LocalDate;
import java.util.*;
public class Volo {
	LocalDate orario_arrivo;
	LocalDate orario_partenza;
	String nome_aereo;
	String partenza;
	String arrivo;
	


	


	public Volo(LocalDate orario_arrivo, LocalDate orario_partenza, String nome_aereo, String partenza, String arrivo) {
		super();
		this.orario_arrivo = orario_arrivo;
		this.orario_partenza = orario_partenza;
		this.nome_aereo = nome_aereo;
		this.partenza = partenza;
		this.arrivo = arrivo;
	}
	

	public LocalDate getOrario_arrivo() {
		return orario_arrivo;
	}





	public void setOrario_arrivo(LocalDate orario_arrivo) {
		this.orario_arrivo = orario_arrivo;
	}





	public LocalDate getOrario_partenza() {
		return orario_partenza;
	}





	public void setOrario_partenza(LocalDate orario_partenza) {
		this.orario_partenza = orario_partenza;
	}





	public String getNome_aereo() {
		return nome_aereo;
	}





	public void setNome_aereo(String nome_aereo) {		
		this.nome_aereo = nome_aereo;
	}





	public String getPartenza() {
		return partenza;
	}





	public void setPartenza(String partenza) {
		this.partenza = partenza;
	}





	public String getArrivo() {
		return arrivo;
	}





	public void setArrivo(String arrivo) {
		this.arrivo = arrivo;
	}


	@Override
	public String toString() {
		return "Volo [ partenza=" + partenza + ", arrivo="  + arrivo+  ", nome_aereo=" 
				+ nome_aereo + ", orario_partenza=" + orario_partenza + ", orario_arrivo=" + orario_arrivo + "]";
	}





}
