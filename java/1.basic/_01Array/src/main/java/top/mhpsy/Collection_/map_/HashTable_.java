package top.mhpsy.Collection_.map_;

import java.util.Hashtable;

public class HashTable_ {
    public static void main(String[] args) {
        Hashtable<String, Integer> table = new Hashtable<>();
        table.put("java", 1);
        table.put("php", 2);
        System.out.println(table.get("java"));
        System.out.println(table.getOrDefault("c", 0));
        System.out.println(table);
    }
}
