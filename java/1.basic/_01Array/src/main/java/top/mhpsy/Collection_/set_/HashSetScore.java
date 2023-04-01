package top.mhpsy.Collection_.set_;

import java.util.HashSet;
import java.util.Set;

public class HashSetScore {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("java");
        hashSet.add("xxx");
        hashSet.add("java");
        System.out.println(hashSet);
    }
}
