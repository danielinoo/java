package esercizio3;

public class Main {

	public static void main(String[] args) {
		
		for (int i = 0; i <10; i++ ) {
			double d = Math.random();
			System.out.printf("%2d)\t%4.3g\n", i+1,d);
		}
		System.out.println();
			
		}
	
	
	

}


/* printf: 
*d = intero
 c = char
g = float
s = string
\n vai a capo in nuova riga
\r = a capo su una riga corrente
\t = inserisci un tab
 
subito dopo % e prima dei modificatori (d,c,g,s) è possibile 
mettere un valore intero che indica la dimensione del campo

es:
System.out.printf("numero libero: %07d\n",987);
System.out.printf("numero libero: %07d\n",1124987);
*/
