package top.mhpsy.Collection_.Collections_;

import java.util.ArrayList;
import java.util.List;

public class ArrayListScoreLook {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.add(5);
        System.out.println(list);
    }
}
