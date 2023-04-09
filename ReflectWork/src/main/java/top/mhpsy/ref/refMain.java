package top.mhpsy.ref;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class refMain {
    private static Properties pr = null;

    static {
        pr = new Properties();
//        System.out.println(refMain.class.getClassLoader().getResource("config.properties"));
        try {
            pr.load(refMain.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(pr);
        System.out.println(pr.get("beanPath"));
        Class<?> cls = Class.forName((String) pr.get("beanPath"));
        Constructor<?> constructor = cls.getConstructor("".getClass(), int.class);
        System.out.println(constructor);
        Object tom = constructor.newInstance("Tom", 1);
//        System.out.println(tom);
//        ((Cat) tom).setName("Jerry");
//        System.out.println(tom);
        Field name = cls.getDeclaredField("name");
        name.setAccessible(true);
        name.set(tom, "Jerry");

        cls.getMethod("eat").invoke(tom);

        Method eat = cls.getDeclaredMethod("eat", String.class);
        eat.setAccessible(true); // private method
        eat.invoke(tom, "fish");

        Method eat1 = cls.getDeclaredMethod("eat", int.class);
        eat1.setAccessible(true); // private method
        eat1.invoke(tom, 2);


    }
}
