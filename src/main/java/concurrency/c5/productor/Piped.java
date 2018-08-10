package concurrency.c5.productor;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 从结果上看出也可以实现同步，但一般不使用，因为缓冲区不易控制、数据不易封装和传输。
 */
public class Piped {
    final PipedInputStream pis = new PipedInputStream();
    final PipedOutputStream pos = new PipedOutputStream();

    public static void main(String[] args) {
        Piped t = new Piped();
        new Thread(t.new Producer()).start();
        new Thread(t.new Consumer()).start();
    }

    class Producer implements Runnable {

        @Override
        public void run() {
            try {
                pis.connect(pos);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                while (true) { //不断的产生数据
                    int n = (int) (Math.random() * 255);
                    System.out.println(Thread.currentThread().getName() + "produce::" + n);
                    pos.write(n);
                    pos.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    pis.close();
                    pos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    class Consumer implements Runnable {

        @Override
        public void run() {
            int n;
            try {
                while (true) {
                    n = pis.read();
                    System.out.println(Thread.currentThread().getName() + "consume::" + n);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    pis.close();
                    pos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
