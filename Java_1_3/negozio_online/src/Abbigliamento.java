
public class Abbigliamento extends Prodotto{

	public Abbigliamento(String name, Double price, String categoria) {
		super(name, price, categoria);
	}

	public Abbigliamento() {
		super();
	}

	@Override
	public Double calculateDiscount() {
		Double sconto = 0.0;
		if(categoria == "Abbigliamento invernale") {
			sconto =price - (price * 0.15);
			setPrice(sconto);
			return sconto;
		}
		else {
			return this.price;
		}
		
		
	}

	@Override
	public String toString() {
		return "ABBIGLIAMENTO" + super.toString() + "]";
	}
	
	
}
