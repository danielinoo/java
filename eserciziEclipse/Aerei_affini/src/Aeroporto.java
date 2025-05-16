import java.lang.reflect.Method;
import java.util.*;
public class Aeroporto {
	
	private String nome;
	LinkedList<Volo> voli = new LinkedList<Volo>();
	public Aeroporto(String nome, LinkedList<Volo> voli) {
		super();
		this.nome = nome;
		this.voli = voli;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LinkedList<Volo> getVoli() {
		return voli;
	}
	public void setVoli(LinkedList<Volo> voli) {
		this.voli = voli;
	}
	@Override
	public String toString() {
		return "Aeroporto [nome=" + nome + ", voli=" + voli + "]";
	}
	
	
}
	 