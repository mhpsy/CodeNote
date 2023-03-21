package top.mhpsy.IO_;

import java.io.*;

public class F04 {
    public static void main(String[] args) {
        F04_ f04_ = new F04_();
//        f04_.m1();
//        f04_.m2();
        f04_.m3();
    }
}

class F04_ {
    public void m1() {
        File file = new File("D:\\IO\\b.jpg");
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream("D:\\IO\\a.jpg");
            byte buffer[] = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, len);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }

    }

    public void m2() {
        FileWriter writer = null;
        try {
            writer = new FileWriter("D:\\IO\\a.txt", true);
            writer.write("hello");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void m3() {
        FileReader reader = null;
        try {
            reader = new FileReader("D:\\IO\\a.txt");
            char[] buffer = new char[1024];
            int len = 0;
            while (((len = reader.read(buffer)) != -1)) {
                System.out.println(new String(buffer, 0, len));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
