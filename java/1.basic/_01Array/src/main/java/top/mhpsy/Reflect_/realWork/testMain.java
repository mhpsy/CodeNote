package top.mhpsy.Reflect_.realWork;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class testMain {
    private static Properties properties = null;

    static {
        properties = new Properties();
        System.out.println(testMain.class.getClassLoader().getResource("bean.properties"));

        try {
            properties.load(new FileInputStream("bean.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(properties);
        System.out.println(properties.get("beanPath"));
    }
}
