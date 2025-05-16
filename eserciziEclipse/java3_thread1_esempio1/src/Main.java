
public class Main {

	public static void main(String[] args) {
		// esercizio 3
//		Thread t2 = new Thread(new Thread3());
//		t2.start();
//		
//		Thread t22 = new Thread(new Thread3());
//		t22.start();
//		
//		Thread t3 = new Thread(new Thread3());
//		t3.run();

		// esercizio4
//		Thread t2 = new Thread(new Thread3());
//		t2.start();
//
//		Thread t22 = new Thread(new Thread3());
//		t22.start();

		//esercizio5
//		Classe1 t2 = new Classe1(true);
//		t2.start();
//
//		Classe1 t22 = new Classe1(false);
//		t22.start();

		//esercizio6
//		Classe1 t2 = new Classe1();
//			
//		t2.setName("Thread1");
//		t2.start();
//
//		Classe1 t22 = new Classe1();
//		
//		t22.setName("Thread2");
//		t22.start();
//		
		
		// esercizio 7
		Classe1 t2 =  new Classe1();
		System.out.println("stato del thread " + t2.getState());
		t2.start();
		try {
			t2.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.interrupt();
		System.out.println("stato del thread " + t2.getState());
		

	}

}
