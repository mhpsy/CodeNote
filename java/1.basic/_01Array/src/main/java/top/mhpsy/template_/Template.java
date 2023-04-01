package top.mhpsy.template_;

abstract public class Template {
    public abstract void doSomething();

    public void calculateTime() {
        // 利用模板方法，计算方法执行时间
        long start = System.currentTimeMillis();
        doSomething();
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
    }
}
