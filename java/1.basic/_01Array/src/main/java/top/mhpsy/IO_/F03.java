package top.mhpsy.IO_;

import java.io.File;
import java.io.IOException;

public class F03 {
    public static void main(String[] args) {
        F03_ f03_ = new F03_();
        f03_.m1();
    }
}

class F03_ {
    public void m1() {
        File parent = new File("D:\\IO\\");
        File file = new File(parent, "a\\b\\c\\d");
        boolean mkdirs = file.mkdirs();// 创建多级目录
        System.out.println("mkdirs = " + mkdirs);
        try {
            new File(file, "e.txt").createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
