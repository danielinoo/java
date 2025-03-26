import java.util.*;
public class Main {

	public static void main(String[] args) {
		// definire una classe (CoppiaInt) che contiene due Integer

		Coppia<Integer, Double> c1 = new Coppia<Integer, Double>(1, 2.0);
		Coppia<Integer, Double> c2 = new Coppia<Integer, Double>(3, 6.0);
		System.out.println("prima dello SWAP");
		System.out.println(c1 + " ," + c2);
		System.out.println();
		System.out.println("dopo lo SWAP");

		SwapCoppia(c1, c2);

		System.out.println(c1 + " ," + c2);
		System.out.println();
		
		System.out.println("------------------------------------");

		Coppia<String, String> c3 = new Coppia<String, String>("uno", "due");
		Coppia<String, String> c4 = new Coppia<String, String>("tre", "quattro");
		System.out.println("prima dello SWAP");
		System.out.println(c3 + " ," + c4);
		System.out.println();
		System.out.println("dopo lo SWAP");

		SwapCoppia(c3, c4);

		System.out.println(c3 + " ," + c4);
		System.out.println();
		
		System.out.println("------------------------------------");
		
		LinkedList<Integer> l = new LinkedList<Integer>();
		
		
		l.addAll(Arrays.asList(new Integer[] {1,2,3,4,5,6,7}));
		
		System.out.println("prima dello SWAP");
		System.out.println(l);
		System.out.println();
		System.out.println("dopo lo SWAP");
		
		Swap(l);
		
		System.out.println(l);
		System.out.println();
		
		System.out.println("------------------------------------");
		
		
	}



	private static void Swap(LinkedList<Integer> l) {
		var a = l.get(2);
		var b = l.get(4);
		
		l.set(2, b);
		l.set(4, a);
		}
		


	private static <T1,T2> void SwapCoppia(Coppia<T1, T2> c1, Coppia<T1, T2> c2) {
		Coppia<T1, T2> supporto = new Coppia<T1, T2>(c1.getPrimo(), c1.getSecondo());

		c1.setPrimo(c2.getPrimo());
		c1.setSecondo(c2.getSecondo());

		c2.setPrimo(supporto.getPrimo());
		c2.setSecondo(supporto.getSecondo());

	}

}
