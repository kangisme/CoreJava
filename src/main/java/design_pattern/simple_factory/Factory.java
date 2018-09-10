package design_pattern.simple_factory;

/**
 * 简单工厂模式
 */
public class Factory {
    public static final String A = "a";

    public static final String B = "b";

    public static Product product(String type) {
        switch (type) {
            case A:
                return new ProductA();
            case B:
                return new ProductB();
            default:
                return new ProductA();
        }
    }
}
