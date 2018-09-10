package design_pattern.proxy;

public class ProxyTest {
    public static void main(String[] args) {
        Subject subject = new RealSubject();
        Proxy proxy = new Proxy(subject);
        proxy.play();
    }
}
