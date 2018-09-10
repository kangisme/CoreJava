package design_pattern.proxy;

public class Proxy implements Subject {
    private Subject subject;

    public Proxy(Subject subject) {
        super();
        this.subject = subject;
    }

    @Override
    public void play() {
        System.out.println("广告1");
        subject.play();
        System.out.println("广告2");
    }
}
