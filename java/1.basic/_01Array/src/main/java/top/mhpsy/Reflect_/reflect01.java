package top.mhpsy.Reflect_;

public class reflect01 {
    public static void main(String[] args) {
        // 1.获取Class对象
        // 1.1调用运行时类的属性：.class
        Class<Person> personClass = Person.class;
        System.out.println(personClass);
        // 1.2通过运行时类的对象
        Person person = new Person();
        Class<? extends Person> aClass = person.getClass();
        System.out.println(aClass);
        // 1.3调用Class的静态方法：forName(String classPath)
        try {
            Class<?> aClass1 = Class.forName("top.mhpsy.Reflect_.Person");
            System.out.println(aClass1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 1.4使用类的加载器：ClassLoader
        ClassLoader classLoader = reflect01.class.getClassLoader();
        try {
            Class<?> aClass2 = classLoader.loadClass("top.mhpsy.Reflect_.Person");
            System.out.println(aClass2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
