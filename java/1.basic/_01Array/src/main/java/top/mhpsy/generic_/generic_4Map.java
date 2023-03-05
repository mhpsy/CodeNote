package top.mhpsy.generic_;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class generic_4Map {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "java");
        map.put(2, "c");
        map.put(3, "php");
        map.put(4, "python");
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry<Integer, String> next : entries) {
            System.out.println(next.getKey() + "==" + next.getValue());
        }

        Iterator<Map.Entry<Integer, String>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> next = iterator.next();
            System.out.println(next.getKey() + "==" + next.getValue());
        }

    }
}
