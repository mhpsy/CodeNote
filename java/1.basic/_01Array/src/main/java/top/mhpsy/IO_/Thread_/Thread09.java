package top.mhpsy.IO_.Thread_;

public class Thread09 {
    public static void main(String[] args) {
        Runnable r = () -> System.out.println("hello");
        //等价于下面的
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };
        Thread t = new Thread(r);
        Thread t1 = new Thread(r1);
        System.out.println(t.getId());
        System.out.println(t1.getId());
        System.out.println(t.isAlive());
        System.out.println(Runtime.getRuntime().availableProcessors());//获取cpu核数
        t.start();
    }
}
