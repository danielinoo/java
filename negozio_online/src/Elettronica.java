
public class Elettronica extends Prodotto{
	
	

	public Elettronica(String name, Double price, String categoria) {
		super(name, price, categoria);
	}
	
	
	public Elettronica() {
		super();
	}
	
	

	@Override
	public Double calculateDiscount() {
		if(price > 500) {
			price =price - ( price * 0.10);
		}
		
		return price;
	}


	@Override
	public String toString() {
		return "ELETTRONICA" + super.toString() + "]";
	}


	
	
	
	

}
