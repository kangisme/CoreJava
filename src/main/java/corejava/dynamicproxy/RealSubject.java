package corejava.dynamicproxy;

public class RealSubject implements Subject {

    @Override
    public void rent() {
        System.out.println("i want to rent my house");
    }

    @Override
    public void hello(String string) {
        System.out.println("hello: " + string);
    }
}
