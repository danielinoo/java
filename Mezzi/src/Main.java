import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		LinkedList<Motociclo> lm = new LinkedList<Motociclo>();
		LinkedList<Autovettura> la = new LinkedList<Autovettura>();

		Motociclo m1 = new Motociclo(2, "benzina", 400,1.0);
		Motociclo m2 = new Motociclo(2, "benzina", 500,1.4);
		Motociclo m3 = new Motociclo(2, "benzina", 600,1.7);
		Motociclo m4 = new Motociclo(2, "benzina", 300,0.1);
		Motociclo m5 = new Motociclo(2, "benzina", 250,1.0);
		Motociclo m6 = new Motociclo(2, "benzina", 125,0.8);
		Motociclo m7 = new Motociclo(2, "benzina", 400,1.1);
		Motociclo m8 = new Motociclo(2, "benzina", 200,1.0);
		Motociclo m9 = new Motociclo(2, "benzina", 300,1.0);
		Motociclo m10 = new Motociclo(2, "benzina", 500,1.4);
		
		lm.addAll(Arrays.asList(m1,m2,m3,m4,m5,m6,m7,m8,m9,m10));
		Collections.sort(lm);
			
		System.out.println("lista motocicli ordinata per consumo:");
		for (var m : lm) {
		System.out.println(m);
		}
		System.out.println();
		
		Autovettura a1 = new Autovettura(4, "diesel", 3000, 2.5);
		Autovettura a2 = new Autovettura(4, "benzina", 2500, 1.3);
		Autovettura a3 = new Autovettura(4, "benzina", 4000, 3.5);
		Autovettura a4 = new Autovettura(4, "diesel", 2000, 1.5);
		Autovettura a5 = new Autovettura(4, "elettrica", 2000, 2.5);
		Autovettura a6= new Autovettura(4, "diesel", 2500, 2.5);
		Autovettura a7 = new Autovettura(4, "diesel",3000, 3.0);
		Autovettura a8 = new Autovettura(4, "diesel", 2000, 1.5);
		Autovettura a9 = new Autovettura(4, "benzina", 1600, 1.0);
		Autovettura a10 = new Autovettura(4, "diesel",300, 2.5);
		
		la.addAll(Arrays.asList(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10));
		Collections.sort(la);
		
		System.out.println("lista autovetture ordinata per consumo:");
		for (var a : la) {
		System.out.println(a);
		}
		System.out.println();
		
		LinkedList<Automezzo>  ta = new LinkedList<Automezzo>();
		ta.addAll(Arrays.asList(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,m1,m2,m3,m4,m5,m6,m7,m8,m9,m10));
		Collections.shuffle(ta);
		
		ta.sort(new Comparator<Automezzo>() {
		public int compare(Automezzo a, Automezzo b) {
			return a.getMaxSpeed().compareTo(b.getMaxSpeed());
		}
	});
		System.out.println("lista automezzi completa ordinata per consumo:");
		for (var m : ta) {
		System.out.println(m);
		}
		System.out.println();
		
		
	
		}
		
		
		
	
	
	}
		
		



