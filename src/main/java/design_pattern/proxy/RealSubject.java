package design_pattern.proxy;

public class RealSubject implements Subject {
    @Override
    public void play() {
        System.out.println("play...");
    }
}
