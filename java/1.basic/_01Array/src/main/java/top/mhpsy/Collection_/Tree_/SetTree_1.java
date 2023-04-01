package top.mhpsy.Collection_.Tree_;

import java.util.TreeSet;

public class SetTree_1 {

    public static void main(String[] args) {
        // 创建一个TreeSet对象
        TreeSet<Integer> set = new TreeSet<>();

        // 添加元素到集合中
        set.add(10);
        set.add(5);
        set.add(20);
        set.add(15);
        set.add(30);

        // 打印集合中的元素
        System.out.println("TreeSet集合中的元素：" + set);

        // 返回集合中的第一个元素
        System.out.println("集合中的第一个元素：" + set.first());

        // 返回集合中的最后一个元素
        System.out.println("集合中的最后一个元素：" + set.last());

        // 返回小于等于指定元素的最大元素
        System.out.println("小于等于25的最大元素：" + set.floor(25));

        // 返回大于指定元素的最小元素
        System.out.println("大于25的最小元素：" + set.higher(25));

        // 从集合中删除指定元素
        set.remove(15);
        System.out.println("删除15后的集合元素：" + set);

        // 返回集合中元素的数量
        System.out.println("集合中元素的数量：" + set.size());

        // 遍历集合中的元素
        System.out.println("遍历集合中的元素：");
        for (Integer i : set) {
            System.out.println(i);
        }
    }
}
