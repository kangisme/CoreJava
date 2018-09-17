package corejava;

import java.time.LocalDate;

public class Chapter8 {
    public static void main(String[] args) {
        LocalDate[] birthdays =
                {
                        LocalDate.of(1906, 12, 9),
                        LocalDate.of(1815, 12, 10),
                        LocalDate.of(1903, 12, 3),
                        LocalDate.of(1910, 6, 22)
                };
        Pair<LocalDate> mm = minmax(birthdays);
        System.out.println(mm.getFirst());
        System.out.println(mm.getSecond());
    }

    public static <T extends Comparable> Pair<T> minmax(T[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        T min = a[0];
        T max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) {
                min = a[i];
            }
            if (max.compareTo(a[i]) < 0) {
                max = a[i];
            }
        }
        return new Pair<>(min, max);
    }
}
