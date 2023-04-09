package top.mhpsy.Reflect_;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class reflect04 {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        SolutionReflect04 s4 = new SolutionReflect04();
        s4.m1();//4
        s4.m2();//8413
        //如果setAccessible(true); 那么是7441毫秒 其实提升不了多少
    }
}

class SolutionReflect04 {
    public void m1() {
        Person person = new Person();
        long l = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            person.eat();
        }
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
    }

    public void m2() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> personCls = Class.forName("top.mhpsy.Reflect_.Person");
        Person p = (Person) personCls.getConstructor((Class<?>[]) null).newInstance();
        Method eat = personCls.getMethod("eat");
        eat.setAccessible(true);
        long l = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            eat.invoke(p);
        }
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
    }
}