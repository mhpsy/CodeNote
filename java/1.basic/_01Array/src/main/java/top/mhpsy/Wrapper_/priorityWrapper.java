package top.mhpsy.Wrapper_;

public class priorityWrapper {
    public static void main(String[] args) {
        Object obj = true ? new Integer(1) : new Double(2.0);
        System.out.println(obj);//1.0
        // 很经典的一个题目因为三目运算要看做是一个整体，所以会先计算整体的类型，然后再赋值
        Object obj1;
        if (true) {
            obj1 = new Integer(1);
        } else {
            obj1 = new Double(2.0);
        }
        System.out.println(obj1);//1
    }
}
