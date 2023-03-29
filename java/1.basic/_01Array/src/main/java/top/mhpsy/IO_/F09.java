package top.mhpsy.IO_;

import java.io.IOException;
import java.io.PrintStream;

public class F09 {
    public static void main(String[] args) {
        F09_ f09_ = new F09_();
        f09_.m1();
    }
}

class F09_ {
    public void m1() {
        PrintStream out = System.out;
        //    public static final PrintStream out = null;
        out.print("hello");
        try {
            out.write("hello".getBytes());
            System.setOut(new PrintStream("D:\\IO\\F09.txt"));
            System.out.println("F09_");
            System.out.println("F09_");
            System.out.println("F09_");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
