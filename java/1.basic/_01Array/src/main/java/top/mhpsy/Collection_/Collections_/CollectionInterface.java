package top.mhpsy.Collection_.Collections_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@SuppressWarnings("all")
public class CollectionInterface {
    public static void main(String[] args) {
        Collection col = new ArrayList();
        col.add("a");
        col.add(10);
        col.add(true);
        Iterator iterator = col.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }
}
