package chapter9;

import java.util.*;

public class Chapter9 {
    public static void main(String[] args) {
        collections();
        subList();
    }

    private static void subList() {
        List<String> staff = new ArrayList<>();
        staff.add("1");
        staff.add("2");
        staff.add("3");
        staff.add("4");
        staff.add("5");
        // subList函数只是生成一个视图
        List group = staff.subList(3, 5);
        group.clear();
        System.out.println(staff);
    }

    private static void collections() {
        // ArrayList随意添加null
        List<Object> strings = new ArrayList<>();
        if (strings.add(null)) {
            System.out.print(true);
        }
        if (strings.add(null)) {
            System.out.print(true);
        }
        System.out.println(strings);

        // HashSet可以添加一次null
        Set<Object> objects = new HashSet<>();
        if (objects.add(null)) {
            System.out.print(true);
        }
        if (objects.add(null)) {
            System.out.print(true);
        }
        System.out.println(objects);

        // HashMap的key可以为null，但唯一，值可以为null
        Map<Integer, String> map = new HashMap<>();
        System.out.print(map.put(null, "test"));
        System.out.print(map.put(null, "test"));
        map.put(1, null);
        map.put(2, null);
        // 1.8更新映射值新方法
        map.merge(1, "add", String::concat);
        System.out.println(map);
        // 1.8访问所有映射条目最高效的方法
        map.forEach((integer, s) -> {
            System.out.println(integer + "=" + s);
        });
    }
}
