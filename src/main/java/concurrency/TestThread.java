package concurrency;

public class TestThread extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 50000; i ++) {
            System.out.println("i = " + i);
        }
    }

    public static void main(String[] args) {
        Thread t = new TestThread();
        t.start();
        try {
            Thread.sleep(200);
            // interrupt方法并不会立即中断线程
            t.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
