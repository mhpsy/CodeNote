package top.mhpsy.IO_;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class F02 {
    public static void main(String[] args) {
        F02_ f02_ = new F02_();
//        f02_.m1();
//        f02_.m2();
        f02_.m4();// 创建100个文件
        f02_.m3();// 删除100个文件

    }
}

class F02_ {
    public void m1() {
        File file = new File("D:\\IO\\", "F01_01.txt");
        boolean isFile = file.isFile();
        boolean isDirectory = file.isDirectory();
        long lastModified = file.lastModified();
        long length = file.length();
        System.out.println("是否为文件: " + isFile);
        System.out.println("是否为目录: " + isDirectory);
        System.out.println("最后修改时间: " + new Date(lastModified));
        System.out.println("文件大小: " + length);
    }

    public void m2() {
        File file = new File("D:\\IO\\");
        String[] list = file.list();// 返回文件夹下所有文件的名称

        for (String s : list) {
            boolean delete = new File(file, s).delete();
            System.out.println("删除文件: " + s + " " + delete);
        }

    }

    public void m3() {
        File file = new File("D:\\IO\\");
        File[] files = file.listFiles();// 返回文件夹下所有文件的名称的File对象

        for (File f : files) {
            boolean delete = f.delete();
            System.out.println("删除文件: " + f.getName() + " " + delete);
        }

    }

    public void m4() {
        File file = new File("D:\\IO\\");

        for (int i = 0; i < 100; i++) {
            // 创建文件
            try {
                new File(file, i + ".txt").createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
