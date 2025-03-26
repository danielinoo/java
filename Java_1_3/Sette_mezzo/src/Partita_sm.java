import java.util.*;
import java.io.*;

public class Partita_sm {

	double valore;
	PrintWriter writer;
	BufferedReader reader;
	LinkedList<String> mazzo = new LinkedList<>();

	LinkedList<String> mano_utente = new LinkedList<>();

	LinkedList<String> mano_banco = new LinkedList<>();

	Scanner testo = new Scanner(System.in);

	public Partita_sm(PrintWriter writer, BufferedReader reader) {
		super();
		this.writer = writer;
		this.reader = reader;
	}

	public void menu() throws IOException {
		String t = null;
		while (t == "esci") {
			writer.println("vuoi continuare a giocare (scrivere \"esci \" per uscire");
			t = reader.readLine();

			giocata();

		}

		writer.println("fine partita");
		

	}

	public void giocata() throws IOException {
		mazzo.addAll(Arrays.asList("asso di bastoni", "due di bastoni", "tre di bastoni", "quattro di bastoni",
				"cinque di bastoni", "sei di bastoni", "sette di bastoni", "otto di bastoni", "nove di bastoni",
				"dieci di bastoni", "fante di bastoni", "cavallo di bastoni", "re di bastoni", "asso di coppe",
				"due di coppe", "tre di coppe", "quattro di coppe", "cinque di coppe", "sei di coppe", "sette di coppe",
				"otto di coppe", "nove di coppe", "dieci di coppe", "fante di coppe", "cavallo di coppe", "re di coppe",
				"asso di denari", "due di denari", "tre di denari", "quattro di denari", "cinque di denari",
				"sei di denari", "sette di denari", "otto di denari", "nove di denari", "dieci di denari",
				"fante di denari", "cavallo di denari", "re di denari", "asso di spade", "due di spade", "tre di spade",
				"quattro di spade", "cinque di spade", "sei di spade", "sette di spade", "otto di spade",
				"nove di spade", "dieci di spade", "fante di spade", "cavallo di spade", "re di spade"));
		Collections.shuffle(mazzo);
		double valore_carte_utente = 0;
		double valore_carte_banco = 0;
		Random random = new Random();

		// gestione giocatore

		// gestione assegnazione prima carta del giocatore
		int i = random.nextInt(mazzo.size());
		String prima_carta = mazzo.get(i);
		mano_utente.add(prima_carta);
		writer.println("la tua carta è " + prima_carta);

		// gestione giocata
		while (true) {

			String a = null;
			writer.println("vuoi richiedere carta? (s/n)");
			a = reader.readLine();
			if (a == "s") {

				// aggiunge un altra carta all utente
				while (true) {
					i = random.nextInt(mazzo.size());
					String carta = mazzo.get(i);
					if (!mano_utente.contains(carta)) {
						mano_utente.add(carta);

						valore_carte_utente = gestione_valori(mano_utente);

					}
					if (valore_carte_utente > 7.5) {
						writer.println("hai sballato!");
					}
					if (valore_carte_utente == 7.5) {
						writer.println("7.5 hai vinto");
						break;
					}
					break;
				} // while giocatore
				
		if (valore_carte_utente == 7.5) {
			writer.println("7.5 hai vinto");
			break;
		}
		if (valore_carte_utente > 7.5) {
				break;
			}

		}//quando utente accetta carta

		// gestione banco

		if (a == "n") {
			writer.println("giocata del banco");

			i = random.nextInt(mazzo.size());
			prima_carta = mazzo.get(i);
			mano_banco.add(prima_carta);
			writer.println("la prima carta del banco è " + prima_carta);

			// aggiunge un altra carta al banco
			while (true) {
				i = random.nextInt(mazzo.size());
				String carta = mazzo.get(i);
				if (!mano_utente.contains(carta) && !mano_banco.contains(carta)) {
					mano_banco.add(carta);

					valore_carte_banco = gestione_valori(mano_banco);
					
					if (valore_carte_banco == 7.5) {
						writer.println("7.5 banco ha vinto");
						break;
					}
					if (valore_carte_banco > 7.5) {
						writer.println("banco ha sballato");
						break;
					}
					if (valore_carte_banco >= valore_carte_utente) {
						writer.println("banco ha vinto");

						break;
					}
				}//gestione carta banco

			} // secondo banco

		} // quando utente non accetta carta
		
		if (valore_carte_banco == 7.5) {
			writer.println("7.5 banco ha vinto");
			break;
		}
		if (valore_carte_banco > 7.5) {
			writer.println("banco ha sballato");
			break;
		}
		if (valore_carte_banco >= valore_carte_utente) {
			writer.println("banco ha vinto");

			break;
		}

			if (valore_carte_banco > 7.5) {
			break;
		}
			} // while generale
		


} // funzione generale

private double gestione_valori(LinkedList<String> l) {
		double v = 0;
		for (var car : l) {
			if (car.contains("asso")) {
				valore = 1;
				v = v + valore;
			}
			if (car.contains("due")) {
				valore = 2;
				v = v + valore;
			}
			if (car.contains("tre")) {
				valore = 3;
				v = v + valore;
			}
			if (car.contains("quattro")) {
				valore = 4;
				v = v + valore;
			}
			if (car.contains("cinque")) {
				valore = 5;
				v = v + valore;
			}
			if (car.contains("sei")) {
				valore = 6;
				v = v + valore;
			}
			if (car.contains("sette")) {
				valore = 0.5;
				v = v + valore;
			}
			if (car.contains("otto")) {
				valore = 0.5;
				v = v + valore;
			}
			if (car.contains("nove")) {
				valore = 0.5;
				v = v + valore;
			}

			if (car.contains("dieci")) {

				if (car.contains("dieci di denari")) {
					
					if(v == 7) {
						v = 7.5;
						return v;
					}
				 	} else if (v % 1 == 0) {
				 		v= 7;
				 		
				 	}
				 		
				 	
				 else {
				            // Se ha una parte decimale
				           v = 7.5;
				           return v;
				 	}
				


				}

				else {
					valore = 0.5;
					v = v + valore;
				}

			}
		
		
		return v;
	}

}
