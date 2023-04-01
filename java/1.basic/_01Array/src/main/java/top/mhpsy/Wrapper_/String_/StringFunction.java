package top.mhpsy.Wrapper_.String_;

public class StringFunction {
    public static void main(String[] args) {
        String str = "abc";
        String str2 = new String("abc");
        useString(str);
        useString(str2);
        System.out.println(str);
        System.out.println(str2);

    }

    public static void useString(String str) {
        str += "abc";
    }
}
