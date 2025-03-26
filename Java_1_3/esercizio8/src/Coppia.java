
public class Coppia<T1, T2> {
	private T1 primo;
	private T2 secondo;
	public Coppia(T1 primo, T2 secondo) {
		super();
		this.primo = primo;
		this.secondo = secondo;
	}
	public Coppia() {
		super();
	}
	public T1 getPrimo() {
		return primo;
	}
	public void setPrimo(T1 primo) {
		this.primo = primo;
	}
	public T2 getSecondo() {
		return secondo;
	}
	public void setSecondo(T2 secondo) {
		this.secondo = secondo;
	}
	@Override
	public String toString() {
		return "Coppia [primo=" + primo + ", secondo=" + secondo + "]";
	}
	
	

}
