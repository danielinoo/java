
public class Thread3 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub

		for(int i = 1; i <=5; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}

}
