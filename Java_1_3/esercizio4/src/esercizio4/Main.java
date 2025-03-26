package esercizio4;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//dichialazione lista/array
		double [] v1;
		v1= new double[100];
		
		int[] v2;
		v2 = new int[100];
		
		for(int i = 0; i < 100; i++) {
			
			v2[i] = i +1;
		}
		
		for (int i = 100; i > 0; i--) {
			v2[i] = i;		
		
		}
		
		
		
		Stampav(v2); //uso metodo di stampa
		
		//inserisco numeri pari
		for(int i = 0;i < 100; i++ ) {
			
			v2[i] = (i+1) * 2;
		}
		
		
		//inserisco numeri dispari
		for(int i = 0;i < 100; i++ ) {
					
					v2[i] = (i+1) * 2 -1;
				}
		
		//serie armonica (1,1/2,1/3,1/4,....)
		for (int i = 1 ; i < 100; i++) {
			v1 [i-1]= 1.0/i;
		}
		
		//inserimento serie numerica di fibonacci
		v2[0] = 1;
		v2[1] = 1;
		for (int i = 2 ; i < 100; i++) {
			v2[i] = v2[i-1] + v2[i-2];
		}
		
		

	}	
	
	private static void Stampav(int[] v2){
			
	for (int v : v2) {
		System.out.print(v + " ");
			}
		System.out.println();
		}


}
