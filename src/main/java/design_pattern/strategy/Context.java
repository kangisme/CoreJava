package design_pattern.strategy;

/**
 * 策略模式，行为型模式
 * 环境类
 */
public class Context {
    private AbstractStrategy strategy;

    public void setStrategy(AbstractStrategy strategy) {
        this.strategy = strategy;
    }

    public void algorithm() {
        strategy.algorithm();
    }
}
