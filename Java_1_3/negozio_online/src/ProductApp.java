import java.util.*;
public class ProductApp{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//creo lista e inizializzo ProductManager
		LinkedList<Prodotto> elenco = new LinkedList<Prodotto>();
		ProductManager pm = new ProductManager();
		
		//creo e aggiungo prodotti alla lista 
		Elettronica e1 = new Elettronica("iphone X", 950.0, "Telefoni");
		Elettronica e2 = new Elettronica("Samsung gs", 450.0, "Telefoni");
		Elettronica e3 = new Elettronica("redmi 30p", 350.0, "Telefoni");
		Abbigliamento a1 = new Abbigliamento("tuta nike",60.0, "sportswear");
		Abbigliamento a2 = new Abbigliamento("giacca north face",600.0, "Abbigliamento invernale");
		Abbigliamento a3 = new Abbigliamento("tuta jordan",70.0, "sportswear");
		
		pm.Inserimento_lista(e1, elenco);		
		pm.Inserimento_lista(a1, elenco);		
		pm.Inserimento_lista(e3, elenco);
		pm.Inserimento_lista(a2, elenco);
		pm.Inserimento_lista(e2, elenco);		
		pm.Inserimento_lista(a3, elenco);


		
		//visualizzo lista prima dell ordinamento
		System.out.println("\nGli sconti sono già applicati\n\nelenco prodotti NON ORDINATI:");
		pm.Visualizza_elenco(elenco);
		System.out.println();
		
		//ordino la lista per prezzo e visualizzo la lista 
		pm.sortByPrice(elenco);
		System.out.println("elenco prodotti ORDINATI:");
		pm.Visualizza_elenco(elenco);
		System.out.println();
		
		
		
		
		
		
		
	
		

	}

}
