package chap6;

import chap6.annotation.TestAnnotation;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

@TestAnnotation(id = 3, msg = "hello annotation")
public class Chap6 {

    public static void main(String[] args) {
        getTime();
        getAnnotation();
    }

    private static void getAnnotation() {
        TestAnnotation testAnnotation = Chap6.class.getAnnotation(TestAnnotation.class);
        if (testAnnotation != null) {
            System.out.println("id:" + testAnnotation.id());
            System.out.println("msg:" + testAnnotation.msg());
        }
    }

    private static void getTime() {
        // Java1.0
        System.out.println(new Date());

        // Java1.1
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());

        // Java1.8
        Instant instant = Instant.now();
        System.out.println(instant);
    }

}
