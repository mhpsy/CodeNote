package top.mhpsy.Collection_.map_;

import java.util.HashMap;

public class HashMap_ {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("java", 1);
        map.put("php", 2);
        System.out.println(map.get("java"));
        System.out.println(map.getOrDefault("c", 0));
        System.out.println(map);


    }
}
