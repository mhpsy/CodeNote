package top.mhpsy.IO_;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class F10 {
    public static void main(String[] args) {
        F10_ f10_ = new F10_();
        f10_.m1();
    }
}

class F10_ {
    public void m1() {
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter("D:\\IO\\F10.txt"));
            printWriter.println("F10_");
            printWriter.println("F10_");
            printWriter.println("F10_");
            printWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
