
public class Secondo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("prima riga");
		System.out.println("seconda riga");
		System.out.println("terza riga");
		System.out.println();
		
		byte b1 = 10;
		byte b2;
		b2 = 100;
		byte b3,b4,b5;
		System.out.println("il valore di b1 è " + b1);
		b1 = 127;
		System.out.println("il valore di b1 è " + b1);
		b1 += 1;
		System.out.println("il valore di b1 è " + b1);
		System.out.println();
		/*
		 * && -> and
		 * || -> or
		 * 
		 * logica binaria:
		 * & -> and
		 * | or
		 * 
		 * 
		 * 
		 * altri operatori aritmetici:
		 * 
		 * ++, --, +=, -=, *=,/=, &=,
		 */
		int v1 = 30;
		int v2 = 41;
		
		if (v1 == 1 && v2 == 0) {
		System.out.println("daje");
		}
		else {
			System.out.println();
		}
		
		System.out.println(v1 & v2);
		

	}

}
