package concurrency;

import com.sun.istack.internal.NotNull;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ThreadPool {
    private volatile boolean RUNNING = true;

    private static BlockingQueue<Runnable> queue = null;

    private final HashSet<Worker> workers = new HashSet<>();

    private final List<Thread> threadList = new ArrayList<>();

    int poolSize = 0;

    int coreSize = 0;

    boolean shutdown = false;

    public ThreadPool(int poolSize) {
        this.poolSize = poolSize;
        queue = new LinkedBlockingDeque<>();
    }

    public void exec(@NotNull Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException();
        }
        if (coreSize < poolSize) {
            addThread(runnable);
        } else {
            try {
                queue.put(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void addThread(Runnable runnable) {
        coreSize++;
        Worker worker = new Worker(runnable);
        workers.add(worker);
        Thread t = new Thread(worker);
        threadList.add(t);
        t.start();
    }

    public void shutDown() {
        RUNNING = false;
        if (!workers.isEmpty()) {
            for (Worker worker : workers) {
                worker.interruptIfIdle();
            }
        }
        shutdown = true;
        Thread.currentThread().interrupt();
    }

    public boolean isRunning() {
        return RUNNING;
    }

    class Worker implements Runnable {

        public Worker(Runnable runnable) {
            queue.offer(runnable);
        }

        @Override
        public void run() {
            while (RUNNING) {
                if (shutdown) {
                    Thread.interrupted();
                }
                Runnable task = null;
                try {
                    task = queue.take();
                    task.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void interruptIfIdle() {
            for (Thread thread :threadList) {
                System.out.println(thread.getName() + " interrupt");
                thread.interrupt();
            }
        }
    }
}

