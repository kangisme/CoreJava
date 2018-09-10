package design_pattern.facade;

/**
 * 外观模式，结构型模式
 */
public class Facade {
    private SubSystemA a = new SubSystemA();
    private SubSystemB b = new SubSystemB();
    private SubSystemC c = new SubSystemC();

    public void method() {
        a.methodA();
        b.methodB();
        c.methodC();
    }
}
