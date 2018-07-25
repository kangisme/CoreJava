package chapter5;

import org.omg.CORBA.IntHolder;

import java.util.ArrayList;

public class Chapter5 {

    /**
     * 示例field
     */
    public String field;

    /**
     * 子类数组的引用可以转换成超类数组的引用，而不需要采用强制类型转换
     * 这将导致调用一个不存在的实例域，进而搅乱相邻存储空间的内容
     */
    private static void ManagerToEmployee() {
        Manager[] managers = new Manager[10];
        Employee[] staff = managers;
        staff[0] = new Manager("Harry Hacker", 8000, 2018, 12, 12);
        managers[0].setBonus(2000);
        System.out.println(managers[0].getSalary());
    }

    private static void arrayList() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.ensureCapacity(100);
    }

    /**
     * int与Integer比较的是值
     * Integer与Integer比较的是对象是否指向同一个存储区域
     */
    private static void autoBoxing() {
        Integer i = 1234;
        int j = 1234;
        Integer k = 1234;
        System.out.println("Integer与int比较" + (i == j));
        System.out.println("Integer与Integer比较" + (i == k));
        Integer a = 123;
        Integer b = 123;
        System.out.println("Integer值位于[-128,127]区间时，指向统一存储区域" + (a == b));
    }

    public enum Size {
        SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

        private String abbreviation;

        private Size(String abbreviation) {
            this.abbreviation = abbreviation;
        }

        public String getAbbreviation() {
            return abbreviation;
        }

    }

    /**
     * 鉴于历史原因，getName方法在应用于数组类型的时候回返回一个很奇怪的名字
     */
    private static void getClassName() {
        System.out.println(int[].class.getName());
        System.out.println(Double[].class.getName());
    }

    public static void main(String[] args) {
        ManagerToEmployee();
        arrayList();
        autoBoxing();
        getClassName();
    }

    /**
     * 自反性，对称性，传递性，一致性，非空引用x，x.equals(null)返回false
     * 完美equals方法
     */
    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null) {
            return false;
        }
        if (getClass() != otherObject.getClass()) {
            return false;
        }
        Chapter5 other = (Chapter5) otherObject;
        return this.field.equals(other.field);
    }
}
