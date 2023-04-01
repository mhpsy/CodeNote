package top.mhpsy.IO_.Properties_;

import java.io.*;
import java.util.Properties;

public class P01_ {
    public static void main(String[] args) {
        SolutionP01_ p01_ = new SolutionP01_();
//        p01_.m1();
//        p01_.m2();
        p01_.m3();
    }
}

class SolutionP01_ {
    public void m1() {
        try {
            System.out.println(new File("test.properties").getAbsoluteFile());
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("test.properties"));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line.split("=")[0] + " = " + line.split("=")[1]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void m2() {
        try {
            Properties properties = new Properties();
            properties.load(new FileReader("test.properties"));
            String name = properties.getProperty("root");
            System.out.println("name = " + name);

            properties.list(System.out);//打印到控制台

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void m3() {
        Properties properties = new Properties();
        properties.setProperty("root", "xx");
        properties.setProperty("pwd", "xx");
        properties.setProperty("url", "xx");
        try {
            properties.store(new FileWriter("P01_m3.properties"), "test");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
