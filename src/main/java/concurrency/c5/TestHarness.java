package concurrency.c5;

import java.util.concurrent.CountDownLatch;

/**
 * 闭锁
 */
public class TestHarness {

    public static void main(String[] args) {
        try {
            long time = timeTasks(10, new Runnable() {
                @Override
                public void run() {
                    System.out.println("hello world");
                }
            });
            System.out.println(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    try {
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException ignored) {

                    }
                }
            };
            t.start();
        }

        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        return end - start;
    }
}
