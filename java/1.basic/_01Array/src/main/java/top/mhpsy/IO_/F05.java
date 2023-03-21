package top.mhpsy.IO_;

import java.io.*;

public class F05 {
    public static void main(String[] args) {
        F05_ f05_ = new F05_();
//        f05_.m2();
//        f05_.m1();
        f05_.m3();
    }
}

class F05_ {
    public void m1() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("D:\\IO\\a.txt"));
            while (bufferedReader.readLine() != null) {
                System.out.println(bufferedReader.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void m2() {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter("D:\\IO\\a.txt", true));
            for (int i = 0; i < 10; i++) {
                bufferedWriter.write("hello");
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public void m3() {
        BufferedInputStream bi = null;
        BufferedOutputStream bo = null;
        try {
            bi = new BufferedInputStream(new FileInputStream("D:\\IO\\a.jpg"));
            bo = new BufferedOutputStream(new FileOutputStream("D:\\IO\\c.jpg"));
            byte buffer[] = new byte[1024];
            int len = 0;
            while ((len = bi.read(buffer)) != -1) {
                bo.write(buffer, 0, len);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (bi != null) {
                    bi.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    if (bo != null) {
                        bo.close();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}