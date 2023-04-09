package top.mhpsy.Reflect_;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class reflect02 {
    public static void main(String[] args) {
        try {
            Class<?> person1 = Class.forName("top.mhpsy.Reflect_.Person");
            System.out.println(person1);

            Object o = person1.newInstance();
            System.out.println(o);

            Method eat = person1.getMethod("eat");
            eat.invoke(o);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }
}
