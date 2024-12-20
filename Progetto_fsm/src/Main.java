import java.io.InputStream;
import java.util.*;
public class Main {


	public static void main(String[] args) {
		
		int piano_corrente= 0;
		int piano_raggiunto = 0;
		Scanner piano_utente = new Scanner(System.in);
		
		
		while(true) {
			System.out.println("---------------");
			System.out.println("scegli il piano (0,1,2,3)");
			
			int pu =piano_utente.nextInt();
			
			if (pu <= 3 && pu >= 0)
			
			
			//aggiornamento piano e specifica direzione
				if (pu != piano_corrente) {
				 piano_raggiunto= Namo(pu, piano_corrente);
				 System.out.println("hai raggiunto " + piano_raggiunto);
				 te_dico_ndovai(pu,piano_corrente);
				 piano_corrente = piano_raggiunto;
				}
				else {
					System.out.println("hai gia raggiunto questo piano");
				}
		}
		
		
	}

	private static void te_dico_ndovai(int pu, int piano_corrente) {
		int ndovai;
		if (pu > piano_corrente) {
			ndovai = pu - piano_corrente;
			System.out.println("stai salendo di "+ ndovai + " piani");
		}
		else {
			ndovai = piano_corrente - pu;
			System.out.println("stai scendendo di "+ ndovai + " piani");
		}
	}

	private static int Namo(int pu, int piano_corrente) {
		
				piano_corrente = pu;
				return piano_corrente;

			
			
			
			
			
		}
		
	}



