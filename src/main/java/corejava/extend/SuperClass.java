package corejava.extend;

public class SuperClass {

    protected String name;

    static{
        System.out.println("SuperClass static initial");
    }

    {
        System.out.println("SuperClass initial");
    }

//    public SuperClass() {
//        this("kang");
//    }

    public SuperClass(String name) {
        this.name = name;
        System.out.println("SuperClass Constructor: " + name);
    }
}
