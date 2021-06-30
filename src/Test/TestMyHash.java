package Test;

import java.util.*;

public class TestMyHash {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(1,22);
        map.put(3,22);
        map.put(2,23);
        System.out.println("map = " + map);
        System.out.println("map.hashCode = " + map.hashCode());

        Set set = new HashSet();
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        set.add("5");
        set.addAll(Arrays.asList(new String[]{"6", "7", "8"}));
        System.out.println("set = " + set);
        System.out.println("set.hashCode = " + set.hashCode());
        set.removeAll(Arrays.asList(new String[]{"1", "5", "7"}));
        System.out.println("set = " + set);
        String[] s1 = (String[]) set.toArray(new String[set.size()]);
        for (String a :s1) {
            System.out.println(a);
        }
    }
}
