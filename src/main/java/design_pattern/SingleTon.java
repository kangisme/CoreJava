package design_pattern;

/**
 * 内部类实现单例模式
 * 利用Jvm加载类机制保证多线程安全
 */
public class SingleTon {

    private SingleTon() {

    }

    private static class Inner {
        private static final SingleTon instance = new SingleTon();
    }

    public static SingleTon getInstance() {
        return Inner.instance;
    }
}
