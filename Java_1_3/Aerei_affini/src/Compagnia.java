
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class Compagnia {
	
	String nome;
	LinkedList<Aereo>  aerei= new LinkedList<Aereo>();
	LinkedList<Volo> voli = new LinkedList<Volo>();
	

	//crea aereo
	public String crea_aereo(String nome, Integer posti_disponibili) {
		Aereo a = new Aereo(nome, posti_disponibili);
		
		aerei.add(a);
		return "nuovo aereo creato";
	}
	
	//crea volo
	public String crea_volo(LocalDate orario_arrivo,
							LocalDate orario_partenza,
							String nome_aereo,
							String partenza,
							String arrivo) {
		Volo v = new Volo(orario_arrivo, orario_partenza, nome_aereo, partenza, arrivo);
		
		voli.add(v);
		
		return "volo creato";
	}
	
	
	//elimina 
	public String elimina_volo(Volo v) {
		
		try {
		voli.remove(v);
		
		return "VOLO ELIMINATO";
		}catch (Exception e) {
			return "volo non trovato";
		}
	}
	
	
	
	
	
	
	
	//prenotazioni
	public String prenotazione(Aereo a,Integer np) {
		Integer pd = a.getPosti_disponibili();
		Integer po = a.getPosti_occupati();
			try {
				pd = pd - np; //posti disponibili - numero posti che prova a prendere
				po= po + np;// posti occupati + numero posti che prova a prendere
				a.setPosti_disponibili(pd);
				a.setPosti_occupati(po);
				return "PRENOTAZIONE COMPLETATA";
			}catch (Exception e) {
				return "IMPOSSIBILE PRENOTARE "+ np + "POSTI"+ "I POSTI DISPONIBILI NEL VOLO SONO: "+ pd;
			}
			
		}
	
	public String cancello_prenotazione(Aereo a,Integer np) {
		Integer pd = a.getPosti_disponibili();
		Integer po = a.getPosti_occupati();
			try {
				pd = pd + np; //posti disponibili - numero posti che prova a prendere
				po= po - np; // posti occupati + numero posti che prova a prendere
				a.setPosti_disponibili(pd);
				a.setPosti_occupati(po);
				
				return 	"CALCELLAZIONE COMPLETATA";
			}catch (Exception e) {
				
				return "ERRORE DURANTE LA CANCELLAZIONE DELLA PRENOTAZIONE (te tocca parti lo stesso";
			}
				
	}
	
	
	public void menuCompagnia() {
	Scanner ic= new Scanner(System.in);
	int i;
	String n;
	
	do {
		System.out.println("------------------------------------------");
		System.out.println("MENU COMPAGNIA");
		System.out.println("1) aggiungi volo");
		System.out.println("2) elimina volo");
		System.out.println("3) crea aereo");
		System.out.println("4)esci");
		
		i = ic.nextInt();
		ic.nextLine();
		
		switch (i) {
		case 1: {
			//formato che deve avere la strnga
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			
			System.out.println("inserisci l'orario di arrivo dell' aereo");
			String arr = ic.nextLine();
			
			//conversione stringa in LocalDate
			LocalDate orario_arrivo = LocalDate.parse(arr, formato);
			
			
			System.out.println("inseririsco l orario di partenza");
			String part = ic.nextLine();
			
			LocalDate orario_partenza = LocalDate.parse(part, formato);
			
			
			System.out.println("inserisci il nome dell aereo");
			String nome_aereo= ic.nextLine();
			
			
			System.out.println("inserisci l' aeroporto di partenza");
			String partenza= ic.nextLine();
			
			System.out.println("inserisci l'aeroporto di arrivo");
			String arrivo= ic.nextLine();
			
			crea_volo(orario_arrivo, orario_partenza, nome_aereo, partenza, arrivo);
			ic.nextLine();
			

			break;
		}
		case 2: {
			
			System.out.println("inserisci il volo da eliminare");
			System.out.println();
			
			//formato che deve avere la strnga
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			
			System.out.println("inserisci l'orario di arrivo dell' aereo");
			String arr = ic.nextLine();
			
			//conversione stringa in LocalDate
			LocalDate orario_arrivo = LocalDate.parse(arr, formato);
			
			
			System.out.println("inseririsco l orario di partenza");
			String part = ic.nextLine();
			
			LocalDate orario_partenza = LocalDate.parse(part, formato);
			
			
			System.out.println("inserisci il nome dell aereo");
			String nome_aereo= ic.nextLine();
			
			
			System.out.println("inserisci l' aeroporto di partenza");
			String partenza= ic.nextLine();
			
			System.out.println("inserisci l'aeroporto di arrivo");
			String arrivo= ic.nextLine();
			
			Volo v = new Volo(orario_arrivo, orario_partenza, nome_aereo, partenza, arrivo);
			elimina_volo(v);
			ic.nextLine();
			
			break;
		}
		case 3:{
			
			break;
		}
		case 4: {
			
			break;
		}
		}

	} while (i !=4);
	
	ic.close();

	
	
	}
	
	
	
	
	
}

