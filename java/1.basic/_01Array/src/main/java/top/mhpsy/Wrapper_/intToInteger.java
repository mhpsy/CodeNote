package top.mhpsy.Wrapper_;

public class intToInteger {
    public static void main(String[] args) {
        int i = 1;
        Integer integer = new Integer(i);//手动装箱
        Integer integer1 = Integer.valueOf(i);//手动装箱
        Integer integer2 = i;//自动装箱
        int ii = integer.intValue();//手动拆箱
        int iii = integer;//自动拆箱
        System.out.println(integer);
        System.out.println(integer1);
        System.out.println(integer2);
    }
}
