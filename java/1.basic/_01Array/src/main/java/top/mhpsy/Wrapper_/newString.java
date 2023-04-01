package top.mhpsy.Wrapper_;

import java.nio.charset.StandardCharsets;

public class newString {
    public static void main(String[] args) {

        String s1 = "abc";
        String s11 = "abc";
        String s2 = new String("abc");
        String s3 = new String(new char[]{'a', 'b', 'c'});
        String s4 = new String(new byte[]{97, 98, 99});
        String s5 = new String(new byte[]{97, 98, 99}, StandardCharsets.UTF_8);
        String s6 = new String(new byte[]{97, 98, 99}, 0, 3);
        System.out.println(s1 == s2);//false
        System.out.println(s1 == s11);//true

    }
}
