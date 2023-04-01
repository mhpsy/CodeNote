package top.mhpsy.Collection_.Tree_;

import java.util.Comparator;
import java.util.TreeSet;

public class SetTree_ {
    public static void main(String[] args) {
        TreeSet<String> tree = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        tree.add("java");
        tree.add("php");
        tree.add("php");
        tree.add("c");
        System.out.println(tree);//[c, java, php]
    }
}
