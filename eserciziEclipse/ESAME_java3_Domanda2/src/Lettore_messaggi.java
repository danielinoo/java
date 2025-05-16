public class Lettore_messaggi extends Thread {
    private Casella_postale cp;

    public Lettore_messaggi(Casella_postale cp) {
		super();
        this.cp = cp;
    }

    @Override
    public void run() {
        while (true) {
            	cp.leggi();
            try {
                Thread.sleep(1500);  // Aspetta 1,5 secondi prima di leggere il  messaggio
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
