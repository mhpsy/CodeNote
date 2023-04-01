package top.mhpsy.Wrapper_.String_;

public class testString {
    public static void main(String[] args) {
//        String str = "abc";
//        str += 'd';
//        System.out.println(str);
        String s1 = "hello";
        String s2 = " tom";
        String s3 = s1 + s2;
        // s1 + s2 会在堆中创建一个新的对象
        // s3 指向堆中的新对象 理论上来说是创建一个空的StringBuffer对象
        // 然后调用两次append方法追加s1和s2，最后调用toString方法返回一个String对象
        String s4 = "hello tom";
        System.out.println(s3 == s4);//false
        System.out.println(s3.intern() == s4);//true
        String s5 = "hello" + " tom";//实际上是在编译期间就被优化成了"hello tom"
        System.out.println(s4 == s5);//true
    }
}
