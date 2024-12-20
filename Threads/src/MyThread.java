public class MyThread extends Thread {
    private long num;

    public void run() {
        while (num-- > 0) {
            System.out.println("Thread id: " + getId()+ " . Num " + num);
        }
    }

    public MyThread(long num) {
        super();
        this.num = num;
    }
}