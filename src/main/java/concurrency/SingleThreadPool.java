package concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 单线程顺序执行线程池
 */
public class SingleThreadPool {

    private volatile boolean isRunning = true;

    private BlockingQueue<Runnable> queue = null;

    private Worker worker = null;

    private SingleThreadPool() {
        queue = new LinkedBlockingQueue<>();

    }

    private static class Inner {
        private static final SingleThreadPool instance = new SingleThreadPool();
    }

    public static SingleThreadPool getInstance() {
        return Inner.instance;
    }

    public boolean add(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException();
        }
        if (worker == null) {
            worker = new Worker();
            worker.start();
        }
        return queue.offer(runnable);
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void shutDown() {
        isRunning = false;
        worker.interrupt();
    }

    private class Worker extends Thread {
        @Override
        public void run() {
            while (isRunning) {
                try {
                    queue.take().run();
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                }
            }
        }
    }
}
