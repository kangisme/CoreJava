package corejava.extend;

/**
 * 初始化顺序：父类静态初始化--子类静态初始化--父类初始化--父类构造函数--子类初始化--子类构造函数
 */
public class ChildClass extends SuperClass {
    static {
        System.out.println("ChildClass static initial");
    }

    {
        System.out.println("ChildClass initial");
    }


    public ChildClass(String name) {
        // 当父类没有默认构造器时，子类必须显式调用父类构造器，并且必须放在第一行
        super(name);
        System.out.println("ChildClass constructor: " + name);
    }

    public static void main(String[] args) {
        new ChildClass("kang");
    }
}
