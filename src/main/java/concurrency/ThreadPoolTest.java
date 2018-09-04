package concurrency;

/**
 * 打印结果正确，为多线程顺序执行
 */
public class ThreadPoolTest {

    private static int i;

    public static void main(String[] args) {
        SingleThreadPool pool = SingleThreadPool.getInstance();
        System.out.println("state: " + pool.isRunning());
        for (int i = 0; i < 1000; i++) {
            pool.add(new Count());
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pool.shutDown();
        System.out.println("state: " + pool.isRunning());
    }

    public static class Count implements Runnable {
        @Override
        public void run() {
            System.out.println(i++);
        }
    }

}
