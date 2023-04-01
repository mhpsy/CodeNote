package top.mhpsy.generic_.test;

import java.util.List;

public class test2 {
    public static void main(String[] args) {
        useGeneric.printList(List.of(1, 2, 3));
        useGeneric.printList2(List.of(1, 2, 3));
        useGeneric.printList3(List.of(1, 2, 3));
    }
}

class useGeneric {
    public static void printList(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static void printList2(List<? extends Number> list) {
        // Number是Integer的父类
        for (Number o : list) {
            System.out.println(o);
        }
    }

    public static void printList3(List<? super Integer> list) {
        // Integer是Number的子类
        for (Object o : list) {
            System.out.println(o);
        }
    }

}