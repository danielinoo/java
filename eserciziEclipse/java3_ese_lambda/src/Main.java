import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		// esercizio1
		Calcolatore c = (a, b) -> a + b;
		Integer somma = c.calcola(2, 2);
		System.out.println("esercizio 1: " + somma);
		System.out.println("-------------------------");

//		----------------------------

		// esercizio2
		VerificatoreParola vp = (parola, lunghezza) -> parola.length() == lunghezza;

		Boolean ris_vp = vp.verifica("ciao", 4);
		System.out.println("esercizio 2: " + ris_vp);

		System.out.println("-------------------------");

//		----------------------------

		// esercizio3
		CalcolatoreArea ca = (raggio) -> raggio * raggio;
		double ac = ca.calcola(3);
		System.out.println("esercizio 3: " + ac);

		System.out.println("-------------------------");

//		----------------------------

		// esercizio4

		VerificatoreNumero vn = (numero) -> numero > 0;
		Boolean ris_vn = vn.verifica(5);
		System.out.println("esercizio 4: " + ris_vn);

		System.out.println("-------------------------");

//		----------------------------

		// esercizio5
		ConcatenaStringhe cs = (s1, s2) -> s1 + s2;
		String ris_cs = cs.UnisciString("ciao", " come stai");
		System.out.println("esercizio 5: " + ris_cs);

		System.out.println("-------------------------");

//		----------------------------

		// esercizio6

		VerificaPari vnp = (numero) -> numero % 2 == 0;
		Boolean ris_vnp = vnp.verificapari(5);
		System.out.println("esercizio 6: " + ris_vnp);

		System.out.println("-------------------------");

//		----------------------------

		// esercizio7
		Sommatore s = (lista) -> {
			Integer sup_s = 0;
			for (Integer l : lista) {
				sup_s += l;
			}
			return sup_s;
		};
		LinkedList<Integer> l2 = new LinkedList<>();
		l2.addAll(Arrays.asList(1, 2, 3, 4, 5));
		Integer ris_s = s.somma(l2);
		System.out.println("esercizio 7: " + ris_s);

		System.out.println("-------------------------");

//		----------------------------

		// esercizio8

		VerificatorePal vpal = (parola) -> {
			StringBuilder rev = new StringBuilder(parola);
			rev.reverse();

			return parola.equals(rev.toString());
		};

		boolean ris_vpal = vpal.verifica("anna");
		System.out.println("esercizio 8: " + ris_vpal);

		System.out.println("-------------------------");

//			----------------------------

		// esercizio9

		CalcolatorePotenza cp = (base, esponente) -> {
			Integer sup_p = 1;
			for (int i = 1; i <= esponente; i++) {

				sup_p *= base;

			}
			return sup_p;
		};
		Integer ris_cp = cp.calcola(2, 4);
		System.out.println("esercizio 9: " + ris_cp);
		System.out.println("-------------------------");

//			----------------------------

		// esercizio10
		
		
		CalcolatoreMedia cm = (lista) -> {
			Integer sup_s = 0;
			Integer cont =0;
			for (Integer l : lista) {
				sup_s += l;
				cont ++;
			}
			return sup_s / cont;
		};
		LinkedList<Integer> l3 = new LinkedList<>();
		l3.addAll(Arrays.asList(2,2,2,2,5,6,7,8,9,9,99));
		double ris_med = cm.calcola(l3);
		System.out.println("esercizio 10: " + ris_med);
		System.out.println("-------------------------");

//			----------------------------

		// esercizio11
		
	

	};

}
