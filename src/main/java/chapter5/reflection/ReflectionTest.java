package chapter5.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {
    /**
     * 反射：加载类的字节码
     *
     * @throws SecurityException
     * @throws NoSuchMethodException
     */
    public static void main(String[] args) throws Exception {

        refGetClass();

        // 获取并调用无参构造函数
        refGetPublicConstructor();

        // 获取并调用私有的含参构造函数
        refGetPrivateConstructor();

        // 获取并调用无参方法 fun
        refGetMethodWithNoArg();

        // 获取并调用有参数方法 fun
        refGetMethodWithArg();

        // 获取类的字段
        refGetField();
    }

    private static void getPrivate() throws Exception{
        Class clazz = Class.forName("chapter5.reflection.Book");
        Constructor c = clazz.getDeclaredConstructor(null);
        c.setAccessible(true);
        c.newInstance(null);
    }

    private static void refGetClass() throws ClassNotFoundException {
        // 加载类的3种方法
        Class clazz = Class.forName("chapter5.reflection.Person");
        Class clazz1 = new Person().getClass();
        Class class2 = Person.class;
        // 三种方法获取的class实例是一个，可以认为同一个类在jvm中的class实例只有一个
        System.out.println(clazz.hashCode() + "\n" + clazz1.hashCode() + "\n" + class2.hashCode() + "\n");
    }

    private static void refGetPublicConstructor() throws Exception {

        Class clazz = Class.forName("chapter5.reflection.Person");
        Constructor c = clazz.getConstructor(null);

        Person p = (Person) c.newInstance(null);
        System.out.println();
    }

    private static void refGetPrivateConstructor() throws Exception {

        Class clazz = Class.forName("chapter5.reflection.Person");
        Constructor c = clazz
                .getDeclaredConstructor(new Class[]{String.class});

        // 由于构造函数是 private 的，所以需要屏蔽Java语言的访问检查
        c.setAccessible(true);

        Person p = (Person) c
                .newInstance(new Object[]{"I'm a reflect name!"});
        System.out.println();
    }

    private static void refGetMethodWithNoArg() throws Exception {

        Class clazz = Class.forName("chapter5.reflection.Person");
        Constructor c = clazz.getConstructor(null);
        Person p = (Person) c.newInstance(null);

        Method method = clazz.getMethod("fun", null);
        method.invoke(p, null);
        System.out.println();
    }

    private static void refGetMethodWithArg() throws Exception {

        Class clazz = Class.forName("chapter5.reflection.Person");
        Constructor c = clazz.getConstructor(null);
        Person p = (Person) c.newInstance(null);

        Method method = clazz.getMethod("fun", new Class[]{String.class});
        method.invoke(p, new Object[]{"I'm a reflect method!"});
        System.out.println();
    }

    private static void refGetField() throws Exception {

        Class clazz = Class.forName("chapter5.reflection.Person");
        Constructor c = clazz.getDeclaredConstructor(String.class);
        // 由于构造函数是 private 的，所以需要获取控制权限
        c.setAccessible(true);
        Person p = (Person) c
                .newInstance(new Object[]{"I'm a reflect name!"});

        Field f = clazz.getField("name");
        Object value = f.get(p);
        Class type = f.getType();
        System.out.println(type);

        if (type.equals(String.class)) {
            System.out.println((String) value);
        }
        System.out.println();
    }
}
