import java.util.*;

//linkedlist --> sequenziali per arrivare al 10 elemento li devo passa tutti
// 		LinkedList<Integer> --> dentro indica il tipo di lista
// 		LinkedList<Integer> li--> dopo aver detto il tipo dico il nome
//		LinkedList<Integer> li = new LinkedList<Integer>() --> 	

// arrayList --> non sequenziale c ha l indice e va diretto all elemento
//Collection

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList<Integer> li = new LinkedList<Integer>();

		li.add(7); // add aggiunge in fondo
		li.add(5);
		li.add(9);
		li.add(2);
		System.out.println(li);
		li.addFirst(11);
		li.addLast(36);
		li.add(3, 99);

		li.add(li.size(), 3); // size

		Integer piu_grande = Collections.max(li);
		Collections.sort(li);

		Collections.shuffle(li); // mischia random la lista

		Ghepardo g1 = new Ghepardo(15, 60, 90.0);
		Ghepardo g2 = new Ghepardo(13, 66, 80.0);
		Ghepardo g3 = new Ghepardo(16, 50, 100.0);
		Ghepardo g4 = new Ghepardo(14, 55, 85.0);

		LinkedList<Ghepardo> lg = new LinkedList<Ghepardo>();
		lg.add(g1);
		lg.add(g2);
		lg.add(g3);
		lg.add(g4);

		Collections.sort(lg);

		// print ogni singolo elemento della lista
		// var --> assegna il tipo del risultato dopo i : (in questo vaso da a G il tipo
		// Ghepardo)
		for (var g : lg) {
			System.out.println(g);
		}

		Collections.shuffle(lg);
		lg.sort(new Comparator<Ghepardo>() {
			public int compare(Ghepardo g1, Ghepardo g2) {
				return g1.getSpeed().compareTo(g2.getSpeed());
			}

		});

		LinkedList<Elefante> le = new LinkedList<Elefante>();

		le.add(new Elefante(5, 10, 4500.0));
		le.add(new Elefante(4, 11, 4550.0));
		le.add(new Elefante(4, 9, 4900.0));
		le.add(new Elefante(4, 8, 4900.0));

		// lista di tipo classe Padre accetta tutti gli oggetti di classi figlie
		LinkedList<Mammifero> lm = new LinkedList<Mammifero>();

		// addAll --> prende tutti gli oggetti delle liste (devono essere classi figlie)
		lm.addAll(le);
		lm.addAll(lg);

		System.out.println(lm);

		LinkedList<Integer> l1 = new LinkedList<Integer>();
		LinkedList<Integer> l2 = new LinkedList<Integer>();	
		
        l1.add(3);
        l1.add(8);
        l1.add(11);
        l2.add(1);
        l2.add(2);
        l2.add(3);
        l2.add(4);
        l2.add(9);
        l2.add(12);
        l2.add(15);
        

        LinkedList<Integer> lsorted = MergeLists(l1, l2);

	}
	
	private static LinkedList<Integer> MergeLists(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        //Prima cosa: impariamo a usare gli iteratori!!!

        //Usando un iteratore, stampare una lista
		
		//iteratore serve per indicarti l' indice
//        Iterator<Integer> it1 = l1.iterator();
//        while (it1.hasNext()) {
//            Integer num = it1.next();
//            System.out.println(num);
		
		
		//lista risultato
		LinkedList<Integer> lret = new LinkedList<Integer>();
		
		//merge delle 2 liste ordinate
		Iterator<Integer> it1 = l1.iterator();
		Iterator<Integer> it2 = l2.iterator();
		
		if (l1.size() == 0) {
			lret.addAll(l1);
			return lret;
		}
		
		if (l2.size() == 0) {
			lret.addAll(l2);
			return lret;
		}
		
		Integer n1 = it1.next();
		Integer n2 = it2.next();
		while (true) {

			if (n1 <= n2) {
				lret.add(n1);
				if (it1.hasNext()) {
					n1 = it1.next();
				}else {
					lret.add(n2);
					while (it2.hasNext()) {
						lret.add(it1.next());
					}
					return lret;
				}
			}
			
			
			
		
        }


        return null;
    }
﻿
		
}
