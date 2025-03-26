import java.util.*;
public class ProductManager implements Ordinabile{
	
	public void Inserimento_lista(Prodotto p,LinkedList<Prodotto> elenco_prodotti ) {
		p.calculateDiscount();
		elenco_prodotti.add(p);
	}
	
	public void Visualizza_elenco(LinkedList<Prodotto> lista){
		
		for ( var p : lista) {
			System.out.println(p.toString());
			System.out.println();
			
		}
		
	}

	@Override
	public LinkedList<Prodotto> sortByPrice(LinkedList<Prodotto> prodotti) {
		Collections.sort(prodotti);
		return prodotti;
	}
	
	
}
