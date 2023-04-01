package top.mhpsy.Wrapper_.String_;

public class testStringBuffer {
    public static void main(String[] args) {
        StringBuffer hello = new StringBuffer("hello");
        System.out.println(hello);
        hello.append(" world");
        System.out.println(hello);
        hello.insert(5, " ");
        System.out.println(hello);
    }
}
