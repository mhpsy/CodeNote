package top.mhpsy.ref;

import java.io.*;
import java.lang.reflect.Constructor;
import java.nio.file.Files;

public class HomeWork_1 {
    public static void main(String[] args) throws Exception {
        Class<?> fileCls = Class.forName("java.io.File");
        Constructor<?> fileClsConstructor = fileCls.getConstructor("".getClass());
        //写入到resources目录下的fileCls.properties文件中
        Object o = fileClsConstructor.newInstance("fileCls.properties");
        File file = (File) o;
        boolean delete = file.delete();
        boolean newFile = file.createNewFile();
        if (newFile) {
            System.out.println(file.getPath());
            System.out.println(file.getAbsolutePath());
//            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(Files.newOutputStream(file.toPath()));
            bufferedOutputStream.write("beanPath=top.mhpsy.ref.Dog".getBytes());
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } else {
            System.out.println("创建失败");
        }

    }
}
