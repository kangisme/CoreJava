package chapter5;

public class Chapter5 {

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

    public static void main(String[] args) {
        ManagerToEmployee();
    }
}
