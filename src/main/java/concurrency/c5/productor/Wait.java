package concurrency.c5.productor;

public class Wait {
    private static int count = 0;
    private final int FULL = 10;
    private static String lock = "lock";

    public static void main(String[] args) {
        Wait t = new Wait();
        new Thread(t.new Producer(), "Producer 1").start();
        new Thread(t.new Producer(), "Producer 2").start();
        new Thread(t.new Consumer(), "Consumer 1").start();
        new Thread(t.new Consumer(), "Consumer 2").start();
        new Thread(t.new Consumer(), "Consumer 3").start();
        new Thread(t.new Consumer(), "Consumer 4").start();
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            while(true) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                synchronized (lock) {
                    while (count == FULL) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + " produce:: " + count);
                    lock.notifyAll();
                }
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            while(true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                synchronized (lock) {
                    while (count == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + " consume:: " + count);
                    lock.notifyAll();
                }
            }
        }
    }
}