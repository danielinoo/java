import java.util.*;
import java.io.*;
public class Agenzia_viaggi {

	public static void main(String[] args) {
		
		Scanner inp = new Scanner(System.in);
				int i;
		
		//lista compagnie
		LinkedList< Compagnia> lc = new LinkedList<Compagnia>();
		
				
				

		//menu generale
		do {
			System.out.println("MENU GENERALE");
			System.out.println("1) entra nel menu delle agenzie");
			System.out.println("2) entra nel menu dell aeroporto");
			System.out.println("3) entra nel menu della compagnia");
			System.out.println("4)esci");
			  i = inp.nextInt();
			  inp.nextLine(); //svuoto lo scanner
		switch (i) {
		case 1: {		
			//menu agenzia(creazione variabile e funzione)
			//gestisce le prenotazioni


			break;
		}
		
		case 2: {		
			//menu aeroporto (creazione variabile e funzione)
			break;
		}
		
		case 3: {		
			Compagnia c = new Compagnia();
			
			c.menuCompagnia();
			break;
		}
		
		case 4: {		
			//menu compagina (creazione variabile e funzione)
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + i);
		}
		
				}while(i != 4);
		
		
		inp.close();
	}

}
