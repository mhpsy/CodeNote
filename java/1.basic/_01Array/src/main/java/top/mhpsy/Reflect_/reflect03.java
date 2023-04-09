package top.mhpsy.Reflect_;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class reflect03 {
    private static Object o2;

    public static void main(String[] args) throws Exception {
        Class<?> personClass = Class.forName("top.mhpsy.Reflect_.Person");
        Constructor<?> personClassConstructor = personClass.getConstructor();
        Object o1 = personClassConstructor.newInstance();
        System.out.println(personClassConstructor);
        System.out.println(o1);
        //public top.mhpsy.Reflect_.Person()
        //Person{name='null', age=0}

        Constructor<?> personClassConstructor1 =
                personClass.getConstructor("".getClass(), int.class);
        System.out.println(personClassConstructor1);
        //传入的参数类型必须和构造器的参数类型一致
        Object o2 = personClassConstructor1.newInstance("mhpsy", 18);
        System.out.println(o2);
        //public top.mhpsy.Reflect_.Person(java.lang.String,int)
        //Person{name='mhpsy', age=18}

        Field name = personClass.getDeclaredField("name");
        //getField()只能获取public的属性
        //getDeclaredField()可以获取所有的属性
        name.setAccessible(true);
        //设置私有属性的访问权限
        String s = (String) name.get(o2);
        System.out.println(s);//mhpsy

    }
}
