package top.mhpsy.IO_;

import java.io.File;
import java.io.IOException;

public class F01 {
    public static void main(String[] args) {
        F01_ f01_ = new F01_();
        f01_.m1();
        f01_.m2();
        f01_.m3();
    }
}

class F01_ {
    public void m1() {
        File file = new File("D:\\IO\\", "F01_01.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void m2() {
        File file = new File("F01_02.txt");
        try {
            boolean newFile = file.createNewFile();
            System.out.println(newFile);
            System.out.println(
                    "file.getAbsolutePath() = " + file.getAbsolutePath()
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void m3() {
        File file = new File("D:\\IO\\");
        File file1 = new File(file, "F01_03.txt");
        try {
            file1.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
