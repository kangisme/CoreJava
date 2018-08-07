package chap6;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

@TestAnnotation(id = 3, msg = "hello annotation")
public class Chap6 {

    public static void main(String[] args) {
        getTime();
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
