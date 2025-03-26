
public class GenID extends Thread{

	static Mutex m = new Mutex();
	static long ID =0;
	
	public void Increase() {
		
		
		
	}
	
	public void run() {
        for (int i=0; i<100; i++) {
            System.out.println(ID + " " + getId());
            // Simulare un minimo di tempo di calcolo
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            ID = ID + 1;
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
	

}
