package concurrency.c10deadlook;

/**
 * 简单锁顺序死锁
 * 多线程调用leftRight和rightLeft，就有可能发生死锁
 */
public class LeftRightDeadLock {
    private final Object left = new Object();
    private final Object right = new Object();

    private LeftRightDeadLock() {

    }

    private static class Inner {
        private static final LeftRightDeadLock instance = new LeftRightDeadLock();
    }

    public static LeftRightDeadLock getInstance() {
        return Inner.instance;
    }

    public void leftRight() {
        synchronized (left) {
            System.out.println("已获取left，等待right");
            synchronized (right) {

            }
        }
    }

    public void rightLeft() {
        synchronized (right) {
            System.out.println("已获取right，等待left");
            synchronized (left) {

            }
        }
    }
}
