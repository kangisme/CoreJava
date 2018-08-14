package chap6.annotation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class InheritedTest {
    public static void main(String[] args) {
        Class b = B.class;
        Test test = (Test) b.getAnnotation(Test.class);
        if (test != null) {
            System.out.println("B有Test注解");
        }
    }
}

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@interface Test {}


@Test
class A {}

class B extends A {}
