package top.mhpsy.Wrapper_;

public class IntegerStringTransfer {
    public static void main(String[] args) {
        // Integer -> String
        Integer i = 100;
        String s = i.toString();
        String s1 = String.valueOf(i);
        String s2 = i + "";
        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);
        // String -> Integer
        String str = "100";
        Integer i1 = Integer.parseInt(str);
        Integer i2 = Integer.valueOf(str);
        Integer i3 = new Integer(str);
        //不推荐直接new
        //因为Integer.valueOf()方法会对-128到127之间的数进行缓存，所以直接new的话会造成内存浪费
        Integer i4 = new Integer(100);
        Integer i5 = Integer.valueOf(100);
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println(i1 == i2);//true
        System.out.println(i2 == i3);//false
        System.out.println(i3 == i4);//false
        System.out.println(i2 == i5);//true

        System.out.println(i1 == 100);//true
        //只要有基本类型参与运算，那么就是比较基本类型(自动拆箱)
    }
}
