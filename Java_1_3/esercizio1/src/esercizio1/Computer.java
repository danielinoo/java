package esercizio1;

public class Computer {

	
	//toString serve per printare la classe
	
	// attributi
	private double peso;
	private double larghezza;
	private double altezza;
	private double profondita;
	private String produttore;
	private int anno_produzione;	
	private double prezzo;
	//static -> stessa variabile per tutti gli oggetti
	private static int contatore;
	//costruttore -> metodo per creare l oggetto
	public Computer(double prezzo, double peso, double larghezza, double altezza, 
			double profondita, String produttore,
			int anno_produzione) {
		
		super();
		contatore += 1;
		this.prezzo = prezzo;
		this.peso = peso;
		this.larghezza = larghezza;
		this.altezza = altezza;
		this.profondita = profondita;
		this.produttore = produttore;
		this.anno_produzione = anno_produzione;
	}
	
	//setter-> modifica valore ;;; getter -> passa il valore
	public double getC() {
		return contatore;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
        this.peso = peso;
	}
	public double getLarghezza() {
		return larghezza;
	}
	public void setLarghezza(double larghezza) {
        this.larghezza = larghezza;
	}
	public double getAltezza() {
		return altezza;
	}
	public void setAltezza(double altezza) {
        this.altezza = altezza;
	}
	public double getProfondita() {
		return profondita;
	}
	public void setProfondita(double profondita) {
        this.profondita = profondita;
	}
	public String getProduttore() {
		return produttore;
	}
	public void setProduttore(String produttore) {
		this.produttore = produttore;
	}
	public int getAnno_produzione() {
		return anno_produzione;
	}
	public void setAnno_produzione(int anno_produzione) {
        this.anno_produzione = anno_produzione;
	}
	
	@Override
	public String toString() {
        return String.format("| Prezzo: %.2f $ \n| Peso: %.0f g. \n| Dimensioni: %.2f x %.2f x %.2f\n| Produttore: %s\n| Anno di produzione: %d ", prezzo, peso, larghezza, altezza, profondita,produttore, anno_produzione );
    }
	
	
}

