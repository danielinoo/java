public class Main {
	public static void main(String[] args) throws InterruptedException {
		ClienteSync c1 = new ClienteSync("Mario", 10);
		ClienteNonSync c2 = new ClienteNonSync("Lucia", 20);
// Avvio i Threads
		c2.start();
		c1.start();

		c1.join();
		c2.join();
	}
}
