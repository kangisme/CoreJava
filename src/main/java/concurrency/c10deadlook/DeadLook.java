package concurrency.c10deadlook;

/**
 * 互斥，不可剥夺，请求和保持，循坏等待
 */
public class DeadLook {
    private static LeftRightDeadLock lock = LeftRightDeadLock.getInstance();

    public static void main(String[] args) {
        new Thread(new Thread1()).start();
        new Thread(new Thread2()).start();
    }

    private static class Thread1 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                lock.leftRight();
            }
        }
    }

    private static class Thread2 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                lock.rightLeft();
            }
        }
    }

}
