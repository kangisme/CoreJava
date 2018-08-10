package concurrency.c5.productor;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    int count = 0;
    final Semaphore put = new Semaphore(5);//初始令牌个数
    final Semaphore get = new Semaphore(0);
    // 二值信号量，这里被用作互斥体，并具备不可重入的加锁语义：谁拥有这个唯一的许可，谁就拥有了互斥锁
    final Semaphore mutex = new Semaphore(1);


    public static void main(String[] args) {
        SemaphoreTest t = new SemaphoreTest();
        new Thread(t.new Producer()).start();
        new Thread(t.new Consumer()).start();
        new Thread(t.new Consumer()).start();
        new Thread(t.new Producer()).start();
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    put.acquire();//注意顺序
                    mutex.acquire();
                    count++;
                    System.out.println(Thread.currentThread().getName() + "produce:: " + count);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    mutex.release();
                    get.release();
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
                    get.acquire();//注意顺序
                    mutex.acquire();
                    count--;
                    System.out.println(Thread.currentThread().getName() + "consume:: " + count);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    mutex.release();
                    put.release();
                }
            }
        }
    }
}