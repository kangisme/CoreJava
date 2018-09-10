package test;

public interface AnnotationTest {
    public static void main(String[] args) {
        System.out.println("hello");
        print();
    }

    default void prints() {
        System.out.println("fsdjfi");
    }

    static void print() {
        System.out.println("fsdjfs");
    }
}
