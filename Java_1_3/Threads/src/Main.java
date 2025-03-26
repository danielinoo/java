
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		MyThread th1 = new MyThread(1000);
//        th1.run();
//        
//        MyThread th2 = new MyThread(1000);
//        th2.run();
		
		
//		MyThread th1 = new MyThread(1000);
//        th1.start();
//        
//        MyThread th2 = new MyThread(1000);
//        th2.start();
//        
//        System.exit(0);
		
		GenID id1 = new GenID();
		id1.start();
			
		GenID id2 = new GenID();
		id2.start();
	}

}
