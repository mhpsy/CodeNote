package top.mhpsy.Collection_.Collections_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("all")
public class A_rray_list_1 {
    public static void main(String[] args) {
        List arrayList = new ArrayList();
        arrayList.add("a");
        arrayList.add(10);
        arrayList.add(true);
        System.out.println(arrayList);
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next + " 1111");//看不到
        }
    }
}
