package esercizio1;

public class Main {

	public static void main(String[] args) {
		
		Computer[] c = new Computer[10];
		
		for (int i = 0; i < c.length; i++) {
			
			//inizializzo l oggetto vuoto
			c[i] = new Computer(0,0,0,0,0,"",0);
			
	        c[i].setPrezzo(Math.random()*(2000-1000)+1000);
	        c[i].setPeso(Math.random()*(200-100)+100);
	        c[i].setLarghezza( Math.random()*5.1);
	        c[i].setAltezza(Math.random()*5.1);
	        c[i].setProfondita(Math.random()*5.1);
	        c[i].setAnno_produzione((int) (Math.floor(Math.random() * 5) + 2000));
	           if (i % 2 == 0) {
	               c[i].setProduttore("Lenovo");
	           }
	           else {
	        	   c[i].setProduttore("Lg");
	           }
	           
	          
	           System.out.println(c[i].toString());
	           System.out.println();
	           System.out.println("-".repeat(10));
	           System.out.println();
	           
		}
		
		
	}

}
