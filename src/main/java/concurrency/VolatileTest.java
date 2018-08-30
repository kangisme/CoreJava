package concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * volatile不能保证i的原子性
 */
public class VolatileTest {
//    static volatile int i = 0;
    static AtomicInteger i = new AtomicInteger(0);
    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(10);
        for (int i = 0; i < 20; i++) {
            threadPool.exec(new Thread1());
        }
    }

    static class Thread1 implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread " + i.getAndIncrement());
        }
    }
}
