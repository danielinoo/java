

abstract class Prodotto implements Comparable<Prodotto>{
	String name;
	Double price;
	String categoria;

	public Prodotto(String name, Double price, String categoria) {
		super();
		this.name = name;
		this.price = price;
		this.categoria = categoria;
	}

	public Prodotto() {
		super();
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public abstract Double calculateDiscount();
	
	@Override
	public int compareTo(Prodotto p) {
		// TODO Auto-generated method stub
		return price.compareTo(p.getPrice());
	}

	@Override
	public String toString() {
		return "[name = " + name + ", price=" + price + ", categoria=" + categoria;
	}
	
	

}
