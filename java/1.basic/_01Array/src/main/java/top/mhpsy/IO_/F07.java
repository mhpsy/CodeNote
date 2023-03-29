package top.mhpsy.IO_;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class F07 {
    public static void main(String[] args) {
        F07_1 f07_1 = new F07_1();
        f07_1.m1();
    }
}

class F07_1 {
    public void m1() {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                    new BufferedOutputStream(
                            new FileOutputStream("D:\\IO\\OutputStreamWriter.txt")),
                    StandardCharsets.UTF_8);
            //StandardCharsets.UTF_8 也可以用 "UTF-8"
            outputStreamWriter.write("hello");
            outputStreamWriter.flush();
            outputStreamWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void m2() {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(
                    new BufferedInputStream(
                            new FileInputStream("D:\\IO\\OutputStreamWriter.txt")),
                    StandardCharsets.UTF_8);
            //StandardCharsets.UTF_8 也可以用 "UTF-8"
            char[] buffer = new char[1024];
            int len = 0;
            while ((len = inputStreamReader.read(buffer)) != -1) {
                System.out.println(new String(buffer, 0, len));
            }
            inputStreamReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
