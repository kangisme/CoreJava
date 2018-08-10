package concurrency.c5.productor;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueue {
    private static int count = 0;
    final java.util.concurrent.BlockingQueue bq = new ArrayBlockingQueue<Integer>(10);

    public static void main(String[] args) {
        BlockingQueue t = new BlockingQueue();
        new Thread(t.new Producer()).start();
        new Thread(t.new Consumer()).start();
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    bq.put(1);
                    count++;
                    System.out.println(Thread.currentThread().getName() + "produce:: " + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                try {
                    bq.take();
                    count--;
                    System.out.println(Thread.currentThread().getName() + "consume:: " + count);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
